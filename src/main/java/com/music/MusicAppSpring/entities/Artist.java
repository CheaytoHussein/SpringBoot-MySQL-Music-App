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
