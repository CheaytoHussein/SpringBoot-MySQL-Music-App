package com.music.MusicAppSpring.entity;

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
    private Integer Id;
    private String artistName;
    private int songCount;
    private int albumCount;
    private long plays;
    @Lob
    private String description;
    private String cover;

    public Artist() {

    }

    public Artist(
            String artistName, String description, String cover,
            int songCount, int albumCount, long plays
    ) {
        this.artistName = artistName;
        this.songCount = songCount;
        this.albumCount = albumCount;
        this.plays = plays;
        this.description = description;
        this.cover = cover;
    }

    @ManyToMany(mappedBy = "albumArtists")
    private List<Album> albums = new ArrayList<>();
    public void addAlbum(Album album) {
        albums.add(album);
    }
    public String getAlbums() {
        return albums.toString();
    }

    @ManyToMany(mappedBy = "songArtists")
    private List<Song> songs = new ArrayList<>();
    public void addSong(Song song) {
        songs.add(song);
    }
    public String getSongs() {
        return songs.toString();
    }

}
