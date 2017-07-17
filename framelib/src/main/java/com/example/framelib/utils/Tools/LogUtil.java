package com.example.framelib.utils.Tools;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by niko on 2017/7/17.
 */

public class LogUtil {

    private static final String TAG = LogUtil.class.getSimpleName();
    /**
     * 日志输出等级
     */
    private static int LOG_LEVEL = Log.VERBOSE;

    /**
     * 是否显示日志
     */
    private static boolean isShowLog = true;

    private static final String DOUBLE_DIVIDER = "-----------------------------------------------------------------------------------------------------------";

    public static void init(boolean isShowLog) {
        LogUtil.isShowLog = isShowLog;
    }

    public static void init(boolean isShowLog, int logLevel) {
        LogUtil.isShowLog = isShowLog;
        LogUtil.LOG_LEVEL = logLevel;
    }

    public static int v(Object msg) {
        return v(TAG, msg);
    }

    public static int v(String tag, Object msg) {
        return v(tag, msg, null);
    }

    public static int v(String tag, Object msg, Throwable tr) {
        return printLog(Log.VERBOSE, tag, msg, tr);
    }

    public static int d(Object msg) {
        return d(TAG, msg);
    }

    public static int d(String tag, Object msg) {
        return d(tag, msg, null);
    }

    public static int d(String tag, Object msg, Throwable tr) {
        return printLog(Log.DEBUG, tag, msg, tr);
    }

    public static int i(Object msg) {
        return i(TAG, msg);
    }

    public static int i(String tag, Object msg) {
        return i(tag, msg, null);
    }

    public static int i(String tag, Object msg, Throwable tr) {
        return printLog(Log.INFO, tag, msg, tr);
    }

    public static int w(Object msg) {
        return w(TAG, msg);
    }

    public static int w(String tag, Object msg) {
        return w(tag, msg, null);
    }

    public static int w(String tag, Object msg, Throwable tr) {
        return printLog(Log.WARN, tag, msg, tr);
    }

    public static int e(Object msg) {
        return e(TAG, msg);
    }

    public static int e(String tag, Object msg) {
        return e(tag, msg, null);
    }

    public static int e(String tag, Object msg, Throwable tr) {
        return printLog(Log.ERROR, tag, msg, tr);
    }

    private static int printLog(int type, String tag, Object msgObj, Throwable tr) {
        if (!isShowLog) {
            return 0;
        }
        String msg;
        StringBuilder builder = new StringBuilder(DOUBLE_DIVIDER).append('\n').append(getFunctionName())
                .append(DOUBLE_DIVIDER).append('\n').append("  ");
        if (msgObj == null) {
            msg = "";
        } else {
            msg = msgObj.toString();
        }
        if (!TextUtils.isEmpty(msg)) {
            builder.append(msg);
        }
        if (tr != null) {
            builder.append('\n').append(Log.getStackTraceString(tr));
        }
        builder.append('\n').append(DOUBLE_DIVIDER);
        switch (type) {
            case Log.VERBOSE:
                if (LOG_LEVEL <= Log.VERBOSE) {
                    return Log.v(tag, builder.toString());
                }
                break;
            case Log.DEBUG:
                if (LOG_LEVEL <= Log.DEBUG) {
                    return Log.d(tag, builder.toString());
                }
                break;
            case Log.INFO:
                if (LOG_LEVEL <= Log.INFO) {
                    return Log.i(tag, builder.toString());
                }
                break;
            case Log.WARN:
                if (LOG_LEVEL <= Log.WARN) {
                    return Log.w(tag, builder.toString());
                }
                break;
            case Log.ERROR:
                if (LOG_LEVEL <= Log.ERROR) {
                    return Log.e(tag, builder.toString());
                }
                break;
        }
        return 0;
    }

    private static String getFunctionName() {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        if (elements == null) {
            return "";
        }
        for (StackTraceElement ste : elements) {
            if (ste.isNativeMethod()) {
                continue;
            }
            if (ste.getClassName().equals(Thread.class.getName())) {
                continue;
            }
            if (ste.getClassName().equals(LogUtil.class.getName())) {
                continue;
            }
            return "  " + ste.getFileName().substring(0, ste.getFileName().indexOf(".")) + "." + ste.getMethodName()
                    + " (" + ste.getFileName() + ":" + ste.getLineNumber() + ")\n";
        }
        return "";


    }



}
