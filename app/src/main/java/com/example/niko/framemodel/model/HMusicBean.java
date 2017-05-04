package com.example.niko.framemodel.model;

import io.realm.RealmObject;

/**
 * Created by niko on 2017/5/1.
 */

public class HMusicBean extends RealmObject {
    /**
     * name : Where is SpringString
     * id : 46824277
     * size : 7178678
     * extension : mp3
     * sr : 44100
     * dfsId : 6011030069306974
     * bitrate : 320000
     * playTime : 178259
     * volumeDelta : -1.7
     */

    private String name;
    private int id;
    private int size;
    private String extension;
    private int sr;
    private long dfsId;
    private int bitrate;
    private int playTime;
    private double volumeDelta;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getSr() {
        return sr;
    }

    public void setSr(int sr) {
        this.sr = sr;
    }

    public long getDfsId() {
        return dfsId;
    }

    public void setDfsId(long dfsId) {
        this.dfsId = dfsId;
    }

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public double getVolumeDelta() {
        return volumeDelta;
    }

    public void setVolumeDelta(double volumeDelta) {
        this.volumeDelta = volumeDelta;
    }

    @Override
    public String toString() {
        return "HMusicBean{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", size=" + size +
                ", extension='" + extension + '\'' +
                ", sr=" + sr +
                ", dfsId=" + dfsId +
                ", bitrate=" + bitrate +
                ", playTime=" + playTime +
                ", volumeDelta=" + volumeDelta +
                '}';
    }
}
