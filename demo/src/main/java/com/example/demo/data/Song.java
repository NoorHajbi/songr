package com.example.demo.data;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private double length;
    private int trackNumber;

    @ManyToOne
    @JoinColumn(name="album_id", nullable=false)
    private Album album;

    public Song() {
    }

    public Song(String title, double length, int trackNumber) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.album = this.getAlbum();
    }
    public Song(String title, double length, int trackNumber, Album album) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.album = album;
    }

    public long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
