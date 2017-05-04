package com.example.niko.framemodel.model;

import io.realm.RealmObject;

/**
 * Created by niko on 2017/5/1.
 */

public class CreatorBean extends RealmObject {

    /**
     * defaultAvatar : false
     * province : 530000
     * authStatus : 0
     * followed : false
     * avatarUrl : http://p1.music.126.net/u4QQ8AoE5L5Aaj-n9OcBiA==/1373290024250593.jpg
     * accountStatus : 0
     * gender : 1
     * city : 532900
     * birthday : -631180800000
     * userId : 18608696
     * userType : 0
     * nickname : 今天脸也无穷黑
     * signature : 怎么这么黑
     * description :
     * detailDescription :
     * avatarImgId : 1373290024250593
     * backgroundImgId : 3261151490745383
     * backgroundUrl : http://p1.music.126.net/tBnKNz8eSyizxcn51N2h9g==/3261151490745383.jpg
     * authority : 0
     * mutual : false
     * expertTags : ["另类/独立","华语","摇滚"]
     * djStatus : 10
     * vipType : 0
     * remarkName : null
     * avatarImgIdStr : 1373290024250593
     * backgroundImgIdStr : 3261151490745383
     */

    private boolean defaultAvatar;
    private int province;
    private int authStatus;
    private boolean followed;
    private String avatarUrl;
    private int accountStatus;
    private int gender;
    private int city;
    private long birthday;
    private int userId;
    private int userType;
    private String nickname;
    private String signature;
    private String description;
    private String detailDescription;
    private long avatarImgId;
    private long backgroundImgId;
    private String backgroundUrl;
    private int authority;
    private boolean mutual;
    private int djStatus;
    private int vipType;
    private String remarkName;
    private String avatarImgIdStr;
    private String backgroundImgIdStr;

    public boolean isDefaultAvatar() {
        return defaultAvatar;
    }

    public void setDefaultAvatar(boolean defaultAvatar) {
        this.defaultAvatar = defaultAvatar;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(int authStatus) {
        this.authStatus = authStatus;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public long getAvatarImgId() {
        return avatarImgId;
    }

    public void setAvatarImgId(long avatarImgId) {
        this.avatarImgId = avatarImgId;
    }

    public long getBackgroundImgId() {
        return backgroundImgId;
    }

    public void setBackgroundImgId(long backgroundImgId) {
        this.backgroundImgId = backgroundImgId;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public boolean isMutual() {
        return mutual;
    }

    public void setMutual(boolean mutual) {
        this.mutual = mutual;
    }

    public int getDjStatus() {
        return djStatus;
    }

    public void setDjStatus(int djStatus) {
        this.djStatus = djStatus;
    }

    public int getVipType() {
        return vipType;
    }

    public void setVipType(int vipType) {
        this.vipType = vipType;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public String getAvatarImgIdStr() {
        return avatarImgIdStr;
    }

    public void setAvatarImgIdStr(String avatarImgIdStr) {
        this.avatarImgIdStr = avatarImgIdStr;
    }

    public String getBackgroundImgIdStr() {
        return backgroundImgIdStr;
    }

    public void setBackgroundImgIdStr(String backgroundImgIdStr) {
        this.backgroundImgIdStr = backgroundImgIdStr;
    }

    @Override
    public String toString() {
        return "CreatorBean{" +
                "defaultAvatar=" + defaultAvatar +
                ", province=" + province +
                ", authStatus=" + authStatus +
                ", followed=" + followed +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", accountStatus=" + accountStatus +
                ", gender=" + gender +
                ", city=" + city +
                ", birthday=" + birthday +
                ", userId=" + userId +
                ", userType=" + userType +
                ", nickname='" + nickname + '\'' +
                ", signature='" + signature + '\'' +
                ", description='" + description + '\'' +
                ", detailDescription='" + detailDescription + '\'' +
                ", avatarImgId=" + avatarImgId +
                ", backgroundImgId=" + backgroundImgId +
                ", backgroundUrl='" + backgroundUrl + '\'' +
                ", authority=" + authority +
                ", mutual=" + mutual +
                ", djStatus=" + djStatus +
                ", vipType=" + vipType +
                ", remarkName='" + remarkName + '\'' +
                ", avatarImgIdStr='" + avatarImgIdStr + '\'' +
                ", backgroundImgIdStr='" + backgroundImgIdStr + '\'' +
                '}';
    }
}
