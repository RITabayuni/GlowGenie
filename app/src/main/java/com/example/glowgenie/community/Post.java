package com.example.glowgenie.community;

public class Post {

    private String postId;
    private String title;
    private String desc;
    private String imageUrl;
    private String user;

    private String userProfileUrl;
    private long timestamp;
    private String userId;


    public Post(){

    }
    public Post(String postId, String title, String desc, String imageUrl, String user, String userProfileUrl,  long timestamp, String userId){
        this.postId = postId;
        this.title = title;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.user = user;
        this.userProfileUrl = userProfileUrl;
        this.timestamp = timestamp;
        this.userId = userId;
    }

    public String getPostId(){
        return postId;
    }

    public void setPostId(String postId){
        this.postId = postId;
    }
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }


    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public void setUser(String user){
        this.user = user;
    }

    public String getUser(){
        return user;
    }

    public void setUserProfileUrl(String userProfileUrl){
        this.userProfileUrl = userProfileUrl;
    }

    public String getUserProfileUrl(){
        return userProfileUrl;
    }

    public void setTimestamp(long timestamp){
        this.timestamp = timestamp;
    }

    public long getTimestamp(){
        return timestamp;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return userId;
    }

}
