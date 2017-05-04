package com.example.framelib.utils.bitmap.helper;

import android.os.Environment;

import com.example.framelib.utils.Tools.MD5;
import com.example.framelib.utils.bitmap.model.ImageSize;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * 存储卡管理类.
 *
 * @author MaXingliang
 */
public class StorageHelper {

    /**
     * The Constant TAG.
     */
    private final String TAG = "StorageHelper";
    /**
     * 更目录，SD卡
     */
    protected final String APP_DIR = Environment.getExternalStorageDirectory().toString() + "/Zhuoer/";
    /**
     * 缓存图片文件夹.
     */
    protected final String IMAGE_DIR = APP_DIR + "image/";
    /**
     * 拼接缓存图片目录
     */
    protected final String SPLICE_IMAGE_DIR = APP_DIR + "splice/";
    /**
     * Gif文件缓存目录
     */
    protected final String GIF_DIR = APP_DIR + "gif/";
    /**
     * 日志文件目录
     */
    protected final String LOG_DIR = APP_DIR + "log/";
    /**
     * 音频文件目录
     */
    protected final String VOICE_DIR = APP_DIR + "voice/";
    /**
     * 临时文件目录
     */
    protected final String TEMP_DIR = APP_DIR + "temp/";
    /**
     * 视频文件目录
     */
    protected final String VIDEO_DIR = APP_DIR + "video/";

    /**
     * The Constant DIR_TYPE_IMAGE.
     */
    public static final int DIR_TYPE_IMAGE = 1;
    /**
     * The Constant DIR_TYPE_LOG.
     */
    public static final int DIR_TYPE_LOG = 2;
    /**
     * 声音
     */
    public static final int DIR_TYPE_VOICE = 3;
    /**
     * 临时文件
     */
    public static final int DIR_TYPE_TEMP = 4;
    /**
     * 拼接图片目录
     */
    public static final int DIR_TYPE_SPLICE_IMAGE = 5;
    /**
     * Gif目录
     */
    public static final int DIR_TYPE_GIF = 6;
    /**
     * video
     */
    public static final int DIR_TYPE_VIDEO = 7;

    /**
     * 该文件用来在图库中屏蔽本应用的图片.
     */
    private final String NOMEDIA_FILE = APP_DIR + ".nomedia";

    private static StorageHelper INSTANCE = null;

    private StorageHelper() {
        INSTANCE = this;
        createNoMediaFile();
    }

    /**
     * 创建.nomedia文件
     */
    protected void createNoMediaFile() {
        File file = new File(NOMEDIA_FILE);
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized StorageHelper getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new StorageHelper();
        }
        return INSTANCE;
    }

    /**
     * Checks for external storage.
     *
     * @return true, if successful
     */
    public boolean hasExternalStorage() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * Gets the dir by type.
     *
     * @param type the type
     * @return the dir by type
     */
    public String getDirByType(int type) {
        String dir = APP_DIR;
        String filePath = "";
        switch (type) {
            case DIR_TYPE_IMAGE:
                filePath = IMAGE_DIR;
                break;
            case DIR_TYPE_LOG:
                filePath = LOG_DIR;
                break;
            case DIR_TYPE_VOICE:
                filePath = VOICE_DIR;
                break;
            case DIR_TYPE_TEMP:
                filePath = TEMP_DIR;
                break;
            case DIR_TYPE_SPLICE_IMAGE:
                filePath = SPLICE_IMAGE_DIR;
                break;
            case DIR_TYPE_GIF:
                filePath = GIF_DIR;
                break;
            case DIR_TYPE_VIDEO:
                filePath = VIDEO_DIR;
                break;
            default:
                filePath = TEMP_DIR;
                break;
        }
        // 创建文件
        File file = new File(filePath);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                dir = file.getPath();
            }
        } else {
            // 文件没创建成功，可能是sd卡不存在，但是还是把路径返回
            dir = filePath;
        }
        return dir;
    }

    /**
     * 获取随机文件名称
     *
     * @param type
     * @param fileType
     * @return
     */
    public String getRandomFilePath(int type, String fileType) {
        long time = System.currentTimeMillis();
        Random random = new Random(time);
        return getDirByType(type) + "/" + time + random.nextInt(8) + fileType;
    }

    /**
     * 网络图片文件缓存路径
     *
     * @param fileType
     * @param url
     * @param imageSize
     * @return
     */
    public String getUrlFilePath(int fileType, String url, ImageSize imageSize) {
        return getDirByType(fileType) + "/" + getImageFileName(url, imageSize);
    }

    /**
     * 网络图片文件缓存路径
     *
     * @param fileType
     * @param url
     * @return
     */
    public String getUrlFilePath(int fileType, String url) {
        return getUrlFilePath(fileType, url, null);
    }

    /**
     * 获取媒体文件缓存名称
     *
     * @param url
     * @return
     */
    private String getImageFileName(String url) {
        return MD5.md5Encode(url);
    }

    /**
     * 获取图片文件缓存名称
     * 精确到两位小数的宽高比与url相加md5，确保一个比例的图片只有一张
     *
     * @param url
     * @param imageSize
     * @return
     */
    private String getImageFileName(String url, ImageSize imageSize) {
        if (imageSize != null) {
            DecimalFormat df = new DecimalFormat("#.00");
            url += df.format(imageSize.width * 1.00 / imageSize.height);
        }
        return getImageFileName(url);
    }

    /**
     * 非图片文件缓存名称
     *
     * @param url
     * @return
     */
    private String getMediaFileName(String url) {
        return MD5.md5Encode(url + ".media");
    }

    /**
     * 非图片文件缓存路径
     *
     * @param fileType
     * @param url
     * @return
     */
    public String getMediaUrlFilePath(int fileType, String url) {
        return getDirByType(fileType) + "/" + getMediaFileName(url);
    }

    /**
     * 是否插入sdcard.
     *
     * @return true, if is sD card exist
     */
    public boolean isSDCardExist() {
        boolean sdCardExist;
        sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        return sdCardExist;
    }

    /**
     * 如果为本地资源则返回本地路径，如果是网络资源，则返回格式为dirPath + md5.encode(url)
     *
     * @param dirPath
     * @param url
     * @return
     */
    public String getEncodedUrl(String dirPath, String url) {
        String ret = null;
        if (null == url) {
            return url;
        }
        if (url.startsWith("http://") || url.startsWith("https://")) {
            if (null == dirPath) {
                return null;
            }
            File file = new File(dirPath);
            if (file.isDirectory()) {
                ret = dirPath + "/" + MD5.md5Encode(url);
            } else {
                ret = null;
            }
        } else {
            // 本地资源
            ret = url;
        }

        return ret;
    }

    /**
     * create dir at direction
     *
     * @param dir
     */
    public void mkdir(String dir) {
        File file = new File(dir);
        if (!file.exists()) {
            try {
                // 按照指定的路径创建文件夹
                file.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
