package com.music.MusicAppSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private long plays = 0;
    private String genre;
    private int duration;
    private String songName;
    public Song(){

    }
    public Song(String songName, long plays, String genre, int duration) {
        this.songName = songName;
        this.plays = plays;
        this.genre = genre;
        this.duration = duration;
    }
    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", plays=" + plays +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                '}';
    }
    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
    public long getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
