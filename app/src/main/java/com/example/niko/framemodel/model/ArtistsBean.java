package com.example.niko.framemodel.model;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by niko on 2017/5/1.
 */

public class ArtistsBean extends RealmObject {

    /**
     * name : The Shanghai Restoration Project
     * id : 31286
     * picId : 0
     * img1v1Id : 0
     * briefDesc :
     * picUrl : http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
     * img1v1Url : http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
     * albumSize : 0
     * alias : []
     * trans :
     * musicSize : 0
     */

    private String name;
    private int id;
    private int picId;
    private int img1v1Id;
    private String briefDesc;
    private String picUrl;
    private String img1v1Url;
    private int albumSize;
    private String trans;
    private int musicSize;
    private RealmList<RealmString> alias;

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

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public int getImg1v1Id() {
        return img1v1Id;
    }

    public void setImg1v1Id(int img1v1Id) {
        this.img1v1Id = img1v1Id;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getImg1v1Url() {
        return img1v1Url;
    }

    public void setImg1v1Url(String img1v1Url) {
        this.img1v1Url = img1v1Url;
    }

    public int getAlbumSize() {
        return albumSize;
    }

    public void setAlbumSize(int albumSize) {
        this.albumSize = albumSize;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public int getMusicSize() {
        return musicSize;
    }

    public void setMusicSize(int musicSize) {
        this.musicSize = musicSize;
    }

    public RealmList<RealmString> getAlias() {
        return alias;
    }

    public void setAlias(RealmList<RealmString> alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "ArtistsBean{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", picId=" + picId +
                ", img1v1Id=" + img1v1Id +
                ", briefDesc='" + briefDesc + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", img1v1Url='" + img1v1Url + '\'' +
                ", albumSize=" + albumSize +
                ", trans='" + trans + '\'' +
                ", musicSize=" + musicSize +
                ", alias=" + alias +
                '}';
    }
}
