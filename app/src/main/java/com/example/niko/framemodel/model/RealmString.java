package com.example.niko.framemodel.model;

import io.realm.RealmObject;

/**
 * Created by niko on 2017/5/1.
 */

public class RealmString extends RealmObject {
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "RealmString{" +
                "string='" + string + '\'' +
                '}';
    }
}
