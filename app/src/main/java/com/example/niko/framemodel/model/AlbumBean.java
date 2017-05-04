package com.example.niko.framemodel.model;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by niko on 2017/5/1.
 */

public class AlbumBean extends RealmObject {
    /**
     * name : Little Dragon Tales
     * id : 127431
     * type : 专辑
     * size : 13
     * picId : 869713697614503
     * blurPicUrl : http://p1.music.126.net/r5lJYalgFL2c5xckW3ku8w==/869713697614503.jpg
     * companyId : 0
     * pic : 869713697614503
     * picUrl : http://p1.music.126.net/r5lJYalgFL2c5xckW3ku8w==/869713697614503.jpg
     * publishTime : 1322496000007
     * description :
     * tags :
     * company : Undercover Culture Music
     * briefDesc :
     * artist : {"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}
     * songs : []
     * alias : ["Chinese Children's Songs"]
     * status : 3
     * copyrightId : 0
     * commentThreadId : R_AL_3_127431
     * artists : [{"name":"The Shanghai Restoration Project","id":31286,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}]
     */

    private String name;
    private int id;
    private String type;
    private int size;
    private long picId;
    private String blurPicUrl;
    private int companyId;
    private long pic;
    private String picUrl;
    private long publishTime;
    private String description;
    private String tags;
    private String company;
    private String briefDesc;
    private ArtistBean artist;
    private int status;
    private int copyrightId;
    private String commentThreadId;
    private RealmList<RealmString> songs;
   // private RealmList<RealmString> alias;
    private RealmList<ArtistsBean> artists;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getPicId() {
        return picId;
    }

    public void setPicId(long picId) {
        this.picId = picId;
    }

    public String getBlurPicUrl() {
        return blurPicUrl;
    }

    public void setBlurPicUrl(String blurPicUrl) {
        this.blurPicUrl = blurPicUrl;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public long getPic() {
        return pic;
    }

    public void setPic(long pic) {
        this.pic = pic;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public ArtistBean getArtist() {
        return artist;
    }

    public void setArtist(ArtistBean artist) {
        this.artist = artist;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCopyrightId() {
        return copyrightId;
    }

    public void setCopyrightId(int copyrightId) {
        this.copyrightId = copyrightId;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public RealmList<RealmString> getSongs() {
        return songs;
    }

    public void setSongs(RealmList<RealmString> songs) {
        this.songs = songs;
    }

    public RealmList<ArtistsBean> getArtists() {
        return artists;
    }

    public void setArtists(RealmList<ArtistsBean> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "AlbumBean{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", picId=" + picId +
                ", blurPicUrl='" + blurPicUrl + '\'' +
                ", companyId=" + companyId +
                ", pic=" + pic +
                ", picUrl='" + picUrl + '\'' +
                ", publishTime=" + publishTime +
                ", description='" + description + '\'' +
                ", tags='" + tags + '\'' +
                ", company='" + company + '\'' +
                ", briefDesc='" + briefDesc + '\'' +
                ", artist=" + artist +
                ", status=" + status +
                ", copyrightId=" + copyrightId +
                ", commentThreadId='" + commentThreadId + '\'' +
                ", songs=" + songs +
                ", artists=" + artists +
                '}';
    }
}
