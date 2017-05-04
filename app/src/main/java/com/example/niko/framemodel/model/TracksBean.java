package com.example.niko.framemodel.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by niko on 2017/5/1.
 */

public class TracksBean extends RealmObject {

    /**
     * name : Where is SpringString
     * id : 1234153
     * position : 2
     * alias : []
     * status : 0
     * fee : 8
     * copyrightId : 412011
     * disc :
     * no : 2
     * artists : [{"name":"The Shanghai Restoration Project","id":31286,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}]
     * album : {"name":"Little Dragon Tales","id":127431,"type":"专辑","size":13,"picId":869713697614503,"blurPicUrl":"http://p1.music.126.net/r5lJYalgFL2c5xckW3ku8w==/869713697614503.jpg","companyId":0,"pic":869713697614503,"picUrl":"http://p1.music.126.net/r5lJYalgFL2c5xckW3ku8w==/869713697614503.jpg","publishTime":1322496000007,"description":"","tags":"","company":"Undercover Culture Music","briefDesc":"","artist":{"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0},"songs":[],"alias":["Chinese Children's Songs"],"status":3,"copyrightId":0,"commentThreadId":"R_AL_3_127431","artists":[{"name":"The Shanghai Restoration Project","id":31286,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}]}
     * starred : false
     * popularity : 90.0
     * score : 90
     * starredNum : 0
     * duration : 178259
     * playedNum : 0
     * dayPlays : 0
     * hearTime : 0
     * ringtone :
     * crbt : null
     * audition : null
     * copyFrom :
     * commentThreadId : R_SO_4_1234153
     * rtUrl : null
     * ftype : 0
     * rtUrls : []
     * hMusic : {"name":"Where is SpringString","id":46824277,"size":7178678,"extension":"mp3","sr":44100,"dfsId":6011030069306974,"bitrate":320000,"playTime":178259,"volumeDelta":-1.7}
     * mMusic : {"name":"Where is SpringString","id":46824278,"size":3612442,"extension":"mp3","sr":44100,"dfsId":5915372557638586,"bitrate":160000,"playTime":178259,"volumeDelta":-1.27}
     * lMusic : {"name":"Where is SpringString","id":46824279,"size":2185948,"extension":"mp3","sr":44100,"dfsId":5806520906479763,"bitrate":96000,"playTime":178259,"volumeDelta":-1.3}
     * bMusic : {"name":"Where is SpringString","id":46824279,"size":2185948,"extension":"mp3","sr":44100,"dfsId":5806520906479763,"bitrate":96000,"playTime":178259,"volumeDelta":-1.3}
     * rtype : 0
     * rurl : null
     * mvid : 0
     * mp3Url : http://m2.music.126.net/DWBA5WE8nyA2vhgvkPuRag==/5806520906479763.mp3
     */

    private String name;
    @PrimaryKey
    private int id;
    private int position;
    private int status;
    private int fee;
    private int copyrightId;
    private String disc;
    private int no;
    private AlbumBean album;
    private boolean starred;
    private double popularity;
    private int score;
    private int starredNum;
    private int duration;
    private int playedNum;
    private int dayPlays;
    private int hearTime;
    private String ringtone;
    private String crbt;
    private String audition;
    private String copyFrom;
    private String commentThreadId;
    private String rtUrl;
    private int ftype;
    private HMusicBean hMusic;
    private MMusicBean mMusic;
    private LMusicBean lMusic;
    private BMusicBean bMusic;
    private int rtype;
    private String rurl;
    private int mvid;
    private String mp3Url;
    private RealmList<RealmString> alias;
    private RealmList<ArtistsBeanX> artists;
    private RealmList<RealmString> rtUrls;

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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getCopyrightId() {
        return copyrightId;
    }

    public void setCopyrightId(int copyrightId) {
        this.copyrightId = copyrightId;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public AlbumBean getAlbum() {
        return album;
    }

    public void setAlbum(AlbumBean album) {
        this.album = album;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStarredNum() {
        return starredNum;
    }

    public void setStarredNum(int starredNum) {
        this.starredNum = starredNum;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPlayedNum() {
        return playedNum;
    }

    public void setPlayedNum(int playedNum) {
        this.playedNum = playedNum;
    }

    public int getDayPlays() {
        return dayPlays;
    }

    public void setDayPlays(int dayPlays) {
        this.dayPlays = dayPlays;
    }

    public int getHearTime() {
        return hearTime;
    }

    public void setHearTime(int hearTime) {
        this.hearTime = hearTime;
    }

    public String getRingtone() {
        return ringtone;
    }

    public void setRingtone(String ringtone) {
        this.ringtone = ringtone;
    }

    public String getCrbt() {
        return crbt;
    }

    public void setCrbt(String crbt) {
        this.crbt = crbt;
    }

    public String getAudition() {
        return audition;
    }

    public void setAudition(String audition) {
        this.audition = audition;
    }

    public String getCopyFrom() {
        return copyFrom;
    }

    public void setCopyFrom(String copyFrom) {
        this.copyFrom = copyFrom;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public String getRtUrl() {
        return rtUrl;
    }

    public void setRtUrl(String rtUrl) {
        this.rtUrl = rtUrl;
    }

    public int getFtype() {
        return ftype;
    }

    public void setFtype(int ftype) {
        this.ftype = ftype;
    }

    public HMusicBean getHMusic() {
        return hMusic;
    }

    public void setHMusic(HMusicBean hMusic) {
        this.hMusic = hMusic;
    }

    public MMusicBean getMMusic() {
        return mMusic;
    }

    public void setMMusic(MMusicBean mMusic) {
        this.mMusic = mMusic;
    }

    public LMusicBean getLMusic() {
        return lMusic;
    }

    public void setLMusic(LMusicBean lMusic) {
        this.lMusic = lMusic;
    }

    public BMusicBean getBMusic() {
        return bMusic;
    }

    public void setBMusic(BMusicBean bMusic) {
        this.bMusic = bMusic;
    }

    public int getRtype() {
        return rtype;
    }

    public void setRtype(int rtype) {
        this.rtype = rtype;
    }

    public String getRurl() {
        return rurl;
    }

    public void setRurl(String rurl) {
        this.rurl = rurl;
    }

    public int getMvid() {
        return mvid;
    }

    public void setMvid(int mvid) {
        this.mvid = mvid;
    }

    public String getMp3Url() {
        return mp3Url;
    }

    public void setMp3Url(String mp3Url) {
        this.mp3Url = mp3Url;
    }

    public RealmList<RealmString> getAlias() {
        return alias;
    }

    public void setAlias(RealmList<RealmString> alias) {
        this.alias = alias;
    }

    public RealmList<ArtistsBeanX> getArtists() {
        return artists;
    }

    public void setArtists(RealmList<ArtistsBeanX> artists) {
        this.artists = artists;
    }

    public RealmList<RealmString> getRtUrls() {
        return rtUrls;
    }

    public void setRtUrls(RealmList<RealmString> rtUrls) {
        this.rtUrls = rtUrls;
    }

    @Override
    public String toString() {
        return "TracksBean{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", position=" + position +
                ", status=" + status +
                ", fee=" + fee +
                ", copyrightId=" + copyrightId +
                ", disc='" + disc + '\'' +
                ", no=" + no +
                ", album=" + album +
                ", starred=" + starred +
                ", popularity=" + popularity +
                ", score=" + score +
                ", starredNum=" + starredNum +
                ", duration=" + duration +
                ", playedNum=" + playedNum +
                ", dayPlays=" + dayPlays +
                ", hearTime=" + hearTime +
                ", ringtone='" + ringtone + '\'' +
                ", crbt='" + crbt + '\'' +
                ", audition='" + audition + '\'' +
                ", copyFrom='" + copyFrom + '\'' +
                ", commentThreadId='" + commentThreadId + '\'' +
                ", rtUrl='" + rtUrl + '\'' +
                ", ftype=" + ftype +
                ", hMusic=" + hMusic +
                ", mMusic=" + mMusic +
                ", lMusic=" + lMusic +
                ", bMusic=" + bMusic +
                ", rtype=" + rtype +
                ", rurl='" + rurl + '\'' +
                ", mvid=" + mvid +
                ", mp3Url='" + mp3Url + '\'' +
                ", alias=" + alias +
                ", artists=" + artists +
                ", rtUrls=" + rtUrls +
                '}';
    }
}
