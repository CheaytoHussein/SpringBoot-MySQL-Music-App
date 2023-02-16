package com.music.MusicAppSpring.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String songName;
    private String releaseDate;
    private String cover;
    private int duration;
    private long plays = 0;

    public Song(){

    }

    public Song(
        String songName,
        String releaseDate,
        String cover,
        int duration, long plays
    ) {
        this.songName = songName;
        this.releaseDate = releaseDate;
        this.cover = cover;
        this.duration = duration;
        this.plays = plays;
    }
    @ManyToMany
    @JoinTable(
            name = "ArtistToSong",
            joinColumns = @JoinColumn(name = "song_Id"),
            inverseJoinColumns = @JoinColumn(name = "artist_Id")
    )
    private List<Artist> songArtists = new ArrayList<>();

    @ManyToOne
//    @JoinColumn(name = "album_id", nullable = false)
    private Album album;
    public void addArtist(Artist artist){
        songArtists.add(artist);
    }
    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCover(){
        return cover;
    }

    public void setCover(String cover){
        this.cover = cover;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getPlays() {
        return plays;
    }

    public void setPlays(long plays) {
        this.plays = plays;
    }

}
