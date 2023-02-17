package com.music.MusicAppSpring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString
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

    public void addArtist(Artist artist){
        songArtists.add(artist);
    }
    public String getArtists(){
        return songArtists.toString();
    }
    @ManyToOne
    private Album album;
    public void setAlbum(Album album){
        this.album = album;
    }

}
