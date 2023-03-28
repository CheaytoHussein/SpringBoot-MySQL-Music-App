package com.music.MusicAppSpring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @RequiredArgsConstructor
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer artistId;
    @NonNull
    private String artistName;
    private int songCount = 0;
    private int albumCount = 0;
    private long plays = 0;
    @NonNull
    @Lob
    @Column(length = 512)
    private String description;
    @NonNull
    private String cover;
    @NonNull
    private String genre;

    @ManyToMany(mappedBy = "albumArtists")
    private List<Album> albums = new ArrayList<>();
    public void addAlbum(Album album) {
        albums.add(album);
        this.albumCount = albums.size();
    }
    public List<Album> getAlbums() {
        return albums;
    }

    @ManyToMany(mappedBy = "songArtists")
    private List<Song> songs = new ArrayList<>();
    public void addSong(Song song) {
        songs.add(song);
        this.songCount = songs.size();
    }
    public List<Song> getSongs() {
        return songs;
    }
    public void incrementPlays(){
        plays++;
    }

}
