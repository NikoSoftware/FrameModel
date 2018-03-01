package com.example.framelib.utils.Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {


    /**
     * 是否为null
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || "null".equals(str) || str.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 是否是网络地址
     * @param url
     * @return
     */
    public static boolean isHttpSource(String url) {
        if (url == null) {
            return false;
        }
        return (url.startsWith("http://") || url.startsWith("https://"));
    }

    /**
     * 是否是当前位置
     * @param url
     * @return
     */
    public static boolean isLocalSource(String url) {
        if (url == null) {
            return false;
        }
        return (url.startsWith("/"));
    }


    /**
     * 是否是图片路径
     * @param url
     * @return
     */
    public static boolean isImageUrl(String url) {
        if (url == null) {
            return false;
        }
        url = url.toLowerCase();
        return (url.endsWith(".png") || url.endsWith(".jpg") || url.endsWith(".jepg"));
    }

    public static boolean isGifUrl(String url) {
        if (url == null) {
            return false;
        }
        url = url.toLowerCase();
        return (url.endsWith(".gif"));
    }


    /**
     * 是否是密码
     * @param passwd
     * @return
     */
    public static boolean isPassword(String passwd) {
        if (isEmpty(passwd)) {
            return false;
        }
        int length = passwd.length();
        if (length >= 6 && length <= 20) {
            return true;
        }
        return false;
    }

    /**
     * 是否是电话号码
     * @param phone
     * @return
     */
    public static boolean isPhoneNumber(String phone) {
        if (isEmpty(phone)) {
            return false;
        }
        Pattern p = Pattern
                .compile("1[34578]\\d{9}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    /**
     * 是否是身份证号
     * @param idCard
     * @return
     */
    public static boolean isIdCard(String idCard) {
        if (isEmpty(idCard)) {
            return false;
        }
        String regExp = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}[x|X|\\d]$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(idCard);
        return m.find();
    }

    /**
     * 输入流转字符串
     * @param is
     * @return
     */
    public static String inputStream2String(InputStream is) {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        try {
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    /**
     * 处理为加密字符
     * @param idCard
     * @return
     */
    public static String idCardDeal(String idCard) {
        StringBuffer sb = new StringBuffer(idCard);
        sb.replace(6, 16, "**********");
        return sb.toString();
    }
}
