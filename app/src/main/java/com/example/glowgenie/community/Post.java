package com.example.glowgenie.community;

public class Post {

    private String title;
    private String content;
    private int image;

    private boolean isMember;


    public Post(String title, String content, int image){
        this.title = title;
        this.content = content;
        this.image = image;
        this.isMember = false;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }


    public String getContent(){
        return content;
    }

    public void setContent(String description){
        this.content = content;
    }
    public void setImage(int image){
        this.image = image;
    }

    public int getImage(){
        return image;
    }

    public void setIsMember(boolean isMember){
        this.isMember = isMember;
    }

    public boolean isMember(){
        return isMember;
    }


}
