package com.example.niko.framemodel.model;

import java.util.List;

/**
 * Created by niko on 2017/3/18.
 */

public class MusicModel {


    /**
     * result : {"subscribers":[],"subscribed":false,"creator":{},"artists":null,"tracks":[],"ordered":true,"tags":[],"adType":0,"trackNumberUpdateTime":1426573494520,"cloudTrackCount":0,"status":10,"privacy":0,"newImported":false,"subscribedCount":413,"specialType":0,"anonimous":false,"description":"丹特","userId":18608696,"coverImgId":7868105208878634,"totalDuration":0,"highQuality":false,"updateTime":1426577277886,"commentThreadId":"A_PL_0_58451795","trackCount":30,"createTime":1426343880849,"playCount":157036,"trackUpdateTime":1483695939310,"coverImgUrl":"http://p1.music.126.net/5FyIC3n9K7LTbChuxraFuQ==/7868105208878634.jpg","name":"2015 春天","id":58451795,"shareCount":17,"commentCount":27}
     * code : 200
     */

    private ResultBean result;
    private int code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        /**
         * subscribers : []
         * subscribed : false
         * creator : {}
         * artists : null
         * tracks : []
         * ordered : true
         * tags : []
         * adType : 0
         * trackNumberUpdateTime : 1426573494520
         * cloudTrackCount : 0
         * status : 10
         * privacy : 0
         * newImported : false
         * subscribedCount : 413
         * specialType : 0
         * anonimous : false
         * description : 丹特
         * userId : 18608696
         * coverImgId : 7868105208878634
         * totalDuration : 0
         * highQuality : false
         * updateTime : 1426577277886
         * commentThreadId : A_PL_0_58451795
         * trackCount : 30
         * createTime : 1426343880849
         * playCount : 157036
         * trackUpdateTime : 1483695939310
         * coverImgUrl : http://p1.music.126.net/5FyIC3n9K7LTbChuxraFuQ==/7868105208878634.jpg
         * name : 2015 春天
         * id : 58451795
         * shareCount : 17
         * commentCount : 27
         */

        private boolean subscribed;
        private CreatorBean creator;
        private Object artists;
        private boolean ordered;
        private int adType;
        private long trackNumberUpdateTime;
        private int cloudTrackCount;
        private int status;
        private int privacy;
        private boolean newImported;
        private int subscribedCount;
        private int specialType;
        private boolean anonimous;
        private String description;
        private int userId;
        private long coverImgId;
        private int totalDuration;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "subscribed=" + subscribed +
                    ", creator=" + creator +
                    ", artists=" + artists +
                    ", ordered=" + ordered +
                    ", adType=" + adType +
                    ", trackNumberUpdateTime=" + trackNumberUpdateTime +
                    ", cloudTrackCount=" + cloudTrackCount +
                    ", status=" + status +
                    ", privacy=" + privacy +
                    ", newImported=" + newImported +
                    ", subscribedCount=" + subscribedCount +
                    ", specialType=" + specialType +
                    ", anonimous=" + anonimous +
                    ", description='" + description + '\'' +
                    ", userId=" + userId +
                    ", coverImgId=" + coverImgId +
                    ", totalDuration=" + totalDuration +
                    ", highQuality=" + highQuality +
                    ", updateTime=" + updateTime +
                    ", commentThreadId='" + commentThreadId + '\'' +
                    ", trackCount=" + trackCount +
                    ", createTime=" + createTime +
                    ", playCount=" + playCount +
                    ", trackUpdateTime=" + trackUpdateTime +
                    ", coverImgUrl='" + coverImgUrl + '\'' +
                    ", name='" + name + '\'' +
                    ", id=" + id +
                    ", shareCount=" + shareCount +
                    ", commentCount=" + commentCount +
                    ", subscribers=" + subscribers +
                    ", tracks=" + tracks +
                    ", tags=" + tags +
                    '}';
        }

        private boolean highQuality;
        private long updateTime;
        private String commentThreadId;
        private int trackCount;
        private long createTime;
        private int playCount;
        private long trackUpdateTime;
        private String coverImgUrl;
        private String name;
        private int id;
        private int shareCount;
        private int commentCount;
        private List<?> subscribers;
        private List<?> tracks;
        private List<?> tags;

        public boolean isSubscribed() {
            return subscribed;
        }

        public void setSubscribed(boolean subscribed) {
            this.subscribed = subscribed;
        }

        public CreatorBean getCreator() {
            return creator;
        }

        public void setCreator(CreatorBean creator) {
            this.creator = creator;
        }

        public Object getArtists() {
            return artists;
        }

        public void setArtists(Object artists) {
            this.artists = artists;
        }

        public boolean isOrdered() {
            return ordered;
        }

        public void setOrdered(boolean ordered) {
            this.ordered = ordered;
        }

        public int getAdType() {
            return adType;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public long getTrackNumberUpdateTime() {
            return trackNumberUpdateTime;
        }

        public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
            this.trackNumberUpdateTime = trackNumberUpdateTime;
        }

        public int getCloudTrackCount() {
            return cloudTrackCount;
        }

        public void setCloudTrackCount(int cloudTrackCount) {
            this.cloudTrackCount = cloudTrackCount;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getPrivacy() {
            return privacy;
        }

        public void setPrivacy(int privacy) {
            this.privacy = privacy;
        }

        public boolean isNewImported() {
            return newImported;
        }

        public void setNewImported(boolean newImported) {
            this.newImported = newImported;
        }

        public int getSubscribedCount() {
            return subscribedCount;
        }

        public void setSubscribedCount(int subscribedCount) {
            this.subscribedCount = subscribedCount;
        }

        public int getSpecialType() {
            return specialType;
        }

        public void setSpecialType(int specialType) {
            this.specialType = specialType;
        }

        public boolean isAnonimous() {
            return anonimous;
        }

        public void setAnonimous(boolean anonimous) {
            this.anonimous = anonimous;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public long getCoverImgId() {
            return coverImgId;
        }

        public void setCoverImgId(long coverImgId) {
            this.coverImgId = coverImgId;
        }

        public int getTotalDuration() {
            return totalDuration;
        }

        public void setTotalDuration(int totalDuration) {
            this.totalDuration = totalDuration;
        }

        public boolean isHighQuality() {
            return highQuality;
        }

        public void setHighQuality(boolean highQuality) {
            this.highQuality = highQuality;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public long getTrackUpdateTime() {
            return trackUpdateTime;
        }

        public void setTrackUpdateTime(long trackUpdateTime) {
            this.trackUpdateTime = trackUpdateTime;
        }

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
        }

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

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public List<?> getSubscribers() {
            return subscribers;
        }

        public void setSubscribers(List<?> subscribers) {
            this.subscribers = subscribers;
        }

        public List<?> getTracks() {
            return tracks;
        }

        public void setTracks(List<?> tracks) {
            this.tracks = tracks;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }

        public static class CreatorBean {
        }
    }

    @Override
    public String toString() {
        return "MusicModel{" +
                "result=" + result +
                ", code=" + code +
                '}';
    }
}
