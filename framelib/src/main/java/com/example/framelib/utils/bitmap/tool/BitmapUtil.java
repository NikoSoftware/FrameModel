package com.example.framelib.utils.bitmap.tool;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Base64;


import com.example.framelib.utils.Tools.MD5;
import com.example.framelib.utils.bitmap.helper.StorageHelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * 加载大图片工具类：解决Android加载大图片时报OOM异常 解决原理：先设置缩放选项，再读取缩放的图片数据到内存，规避了内存引起的OOM
 */
public class BitmapUtil {

    public static final int UNCONSTRAINED = -1;

    /*
     * 获得设置信息
     */
    public static Options getOptions(String path) {
        Options options = new Options();
        options.inJustDecodeBounds = true;// 只描边，不读取数据
        BitmapFactory.decodeFile(path, options);
        return options;
    }

    /**
     * 质量压缩方法
     * 把图片压缩至小于1MB
     *
     * @param image Bitmap
     * @return Bitmap
     */
    public static Bitmap compressImage(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        image.compress(CompressFormat.JPEG, 100, baos);
        int options = 100;
        // 循环判断如果压缩后图片是否大于100kb,大于继续压缩
        while (baos.toByteArray().length / 1024 > 1000) {
            // 重置baos，即清空baos
            baos.reset();
            // 每次都减少10
            options -= 10;
            // 这里压缩options%，把压缩后的数据存放到baos中
            image.compress(CompressFormat.JPEG, options, baos);
        }
        // 把压缩后的数据baos存放到ByteArrayInputStream中
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        // 把ByteArrayInputStream数据生成图片
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);
        return bitmap;
    }

    //把图片压缩至40%
    public static String compressImage(String path, int percent) {
//        //Log.e("compressImage", path + "->" + percent+"%");
        String ret = null;
        if (percent == 0) {
            percent = 40;
        }
        if (null != path) {
            ret = StorageHelper.getInstance().getDirByType(StorageHelper.DIR_TYPE_IMAGE) + "/" + MD5.md5Encode(path) + ".jpg";
            File file = new File(ret);
            if (file.exists())
                return ret;

            Options options = new Options();
            options.inJustDecodeBounds = false;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inSampleSize = 2;
            Bitmap bitmap = BitmapFactory.decodeFile(path, options);
            if (null != bitmap) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmap.compress(CompressFormat.JPEG, percent, fileOutputStream);
                    fileOutputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    ret = null;
                } catch (IOException e) {
                    e.printStackTrace();
                    ret = null;
                } finally {
                    bitmap.recycle();
                }
            } else {
                ret = null;
            }
        }

        return ret;
    }

    public static Bitmap cutBitmap(String path, int width, int height) {
        Bitmap ret = null;

        if (null == path)
            return null;

        Options options = new Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = 4;
        options.inInputShareable = true;
        options.inPurgeable = true;
        Bitmap bitmap = BitmapFactory.decodeFile(path, options);
        if (null != bitmap) {
            int swidth = bitmap.getWidth();
            int sheight = bitmap.getHeight();

            double sratio = swidth * 1.000 / sheight;
            double ratio = width * 1.000 / height;
            int x = 0, y = 0;
            int cw = 0, ch = 0;
            if (sratio > ratio) {//裁剪宽度
                ch = sheight;
                cw = (int) (sheight * ratio);
                x = Math.abs(swidth - cw) / 2;
            } else {
                cw = swidth;
                ch = (int) (swidth / ratio);
                y = Math.abs(sheight - ch) / 2;
            }

            ret = Bitmap.createBitmap(bitmap, x, y, cw, ch);

            bitmap.recycle();
        }

        return ret;
    }

    /**
     * 根据文件路径等比压缩图片
     *
     * @param path    图片路径
     * @param options
     * @return
     * @throws FileNotFoundException
     */
    public static Bitmap getBitmapByPath(String path, Options options, int screenWidth, int screenHeight)
            throws FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        FileInputStream in;
        in = new FileInputStream(file);
        if (options != null) {
            Rect r = getScreenRegion(screenWidth, screenHeight);
            int w = r.width();
            int h = r.height();
            int maxSize = w > h ? w : h;
            int inSimpleSize = computeSampleSize(options, maxSize, w * h);
            options.inSampleSize = inSimpleSize; // 设置缩放比例
            options.inJustDecodeBounds = false;
        }
        Bitmap b = BitmapFactory.decodeStream(in, null, options);
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

    private static Rect getScreenRegion(int width, int height) {
        return new Rect(0, 0, width, height);
    }

    /**
     * 获取需要进行缩放的比例，即options.inSampleSize
     *
     * @param options
     * @param minSideLength
     * @param maxNumOfPixels
     * @return
     */
    public static int computeSampleSize(Options options, int minSideLength, int maxNumOfPixels) {
        int initialSize = computeInitialSampleSize(options, minSideLength, maxNumOfPixels);

        int roundedSize;
        if (initialSize <= 8) {
            roundedSize = 1;
            while (roundedSize < initialSize) {
                roundedSize <<= 1;
            }
        } else {
            roundedSize = (initialSize + 7) / 8 * 8;
        }

        return roundedSize;
    }

    private static int computeInitialSampleSize(Options options, int minSideLength, int maxNumOfPixels) {
        double w = options.outWidth;
        double h = options.outHeight;
        int lowerBound = (maxNumOfPixels == UNCONSTRAINED) ? 1 : (int) Math.ceil(Math.sqrt(w * h / maxNumOfPixels));
        int upperBound = (minSideLength == UNCONSTRAINED) ? 128 : (int) Math.min(Math.floor(w / minSideLength),
                Math.floor(h / minSideLength));

        if (upperBound < lowerBound) {
            // return the larger one when there is no overlapping zone.
            return lowerBound;
        }

        if ((maxNumOfPixels == UNCONSTRAINED) && (minSideLength == UNCONSTRAINED)) {
            return 1;
        } else if (minSideLength == UNCONSTRAINED) {
            return lowerBound;
        } else {
            return upperBound;
        }
    }

    /**
     * @param source      源图片的路径
     * @param destination 处理后的图片路径
     */
    public static void setExif(String source, String destination) {
        ExifInterface exifInterface1 = null;
        ExifInterface exifInterface2 = null;
        try {
            exifInterface1 = new ExifInterface(source);
            exifInterface2 = new ExifInterface(destination);

            //方向
            exifInterface2.setAttribute(ExifInterface.TAG_ORIENTATION,
                    exifInterface1.getAttribute(ExifInterface.TAG_ORIENTATION));
            exifInterface2.saveAttributes();
            //经度
            exifInterface2.setAttribute(ExifInterface.TAG_GPS_LATITUDE,
                    exifInterface1.getAttribute(ExifInterface.TAG_GPS_LATITUDE));
            exifInterface2.saveAttributes();
            //纬度
            exifInterface2.setAttribute(ExifInterface.TAG_GPS_LONGITUDE,
                    exifInterface1.getAttribute(ExifInterface.TAG_GPS_LONGITUDE));
            exifInterface2.saveAttributes();
            //时间
            exifInterface2.setAttribute(ExifInterface.TAG_DATETIME,
                    exifInterface1.getAttribute(ExifInterface.TAG_DATETIME));
            exifInterface2.saveAttributes();
            //长
            exifInterface2.setAttribute(ExifInterface.TAG_IMAGE_LENGTH,
                    exifInterface1.getAttribute(ExifInterface.TAG_IMAGE_LENGTH));
            exifInterface2.saveAttributes();
            //宽
            exifInterface2.setAttribute(ExifInterface.TAG_IMAGE_WIDTH,
                    exifInterface1.getAttribute(ExifInterface.TAG_IMAGE_WIDTH));
            exifInterface2.saveAttributes();

//			//纬度参考
//			exifInterface2.setAttribute(ExifInterface.TAG_GPS_LATITUDE_REF,
//			        exifInterface1.getAttribute(ExifInterface.TAG_GPS_LATITUDE_REF));
//			exifInterface2.saveAttributes();
//			//经度参考
//			exifInterface2.setAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF,
//			        exifInterface1.getAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF));
//			exifInterface2.saveAttributes();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过uri获取图片的实际路径
     *
     * @param context
     * @param contentURI
     * @return
     */
    @TargetApi(19)
    public static String getRealPathFromURI(Context context, Uri contentURI) {
        String result = "";
        String stringUri = contentURI.toString();
        if (stringUri.startsWith("file://")) {
            result = contentURI.getPath();
        } else if (stringUri.startsWith("content://")) {
            if (android.os.Build.VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(context, contentURI)) {
                String wholeID = DocumentsContract.getDocumentId(contentURI);
                String id = wholeID.split(":")[1];
                String[] column = {MediaStore.Images.Media.DATA};
                String sel = MediaStore.Images.Media._ID + "=?";
                Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        column, sel, new String[]{id}, null);
                int columnIndex = cursor.getColumnIndex(column[0]);
                if (cursor.moveToFirst()) {
                    result = cursor.getString(columnIndex);
                }
                cursor.close();
            } else {
                String[] projection = {MediaStore.Images.Media.DATA};
                Cursor cursor = context.getContentResolver().query(contentURI, projection, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                result = cursor.getString(column_index);
            }
        }
        return result;
    }

    /**
     * 把图片转换成Base64字符串
     *
     * @param bitmap Bitmap
     * @return
     */
    public static String BitmapToBase64(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 40, baos);
            byte[] imgBytes = baos.toByteArray();
            return Base64.encodeToString(imgBytes, Base64.DEFAULT);
        } catch (Exception e) {
            return null;
        } finally {
            try {
                baos.flush();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}