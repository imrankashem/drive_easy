package com.example.hemanth.youtube;

/**
 * Created by hemanth on 26/10/16.
 */
public class YouTubeHolder {

    private String id;
    private String video;

    public YouTubeHolder(String id, String video) {
        this.video = video;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
