package com.example.framelib.eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by niko on 2017/7/14.
 */

public class EventUtil {

    public static void register(Object context){
        if (!EventBus.getDefault().isRegistered(context)) {
            EventBus.getDefault().register(context);
        }
    }
    public static void unregister(Object context){
        if (EventBus.getDefault().isRegistered(context)) {
            EventBus.getDefault().unregister(context);
        }
    }
    public static void sendPostEvent(Object object){
        EventBus.getDefault().post(object);
    }

    public static void sendStickyEvent(Object event) {
        EventBus.getDefault().postSticky(event);
    }
}
