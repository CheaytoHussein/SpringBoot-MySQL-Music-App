package com.music.MusicAppSpring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer artistId;
    private String artistName;
    private int songCount;
    private int albumCount;
    private long plays;
    @Lob
    @Column(length = 512)
    private String description;
    private String cover;
    private String genre;

    public Artist() {

    }

    public Artist(
            String artistName, String description, String cover, String genre,
            int songCount, int albumCount, long plays
    ){
        this.artistName = artistName;
        this.songCount = songCount;
        this.albumCount = albumCount;
        this.genre = genre;
        this.plays = plays;
        this.description = description;
        this.cover = cover;
    }

    @ManyToMany(mappedBy = "albumArtists")
    private List<Album> albums = new ArrayList<>();
    public void addAlbum(Album album) {
        albums.add(album);
    }
    public List<Album> getAlbums() {
        return albums;
    }

    @ManyToMany(mappedBy = "songArtists")
    private List<Song> songs = new ArrayList<>();
    public void addSong(Song song) {
        songs.add(song);
    }
    public List<Song> getSongs() {
        return songs;
    }

}
