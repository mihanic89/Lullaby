package com.yamilab.lullababy;

import java.io.Serializable;

/**
 * Created by Misha on 08.02.2017.
 */

public class Audio implements Serializable {

    private Integer data;
    private String album;
    private String artist;

    public Audio(Integer data, String album, String artist) {
        this.data = data;
        this.album = album;
        this.artist = artist;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


}

