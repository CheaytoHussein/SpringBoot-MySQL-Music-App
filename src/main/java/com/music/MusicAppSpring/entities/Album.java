package com.music.MusicAppSpring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer albumId;
    private String albumName;
    private String genre;
    private String releaseDate;
    private String cover;
    private int tracks;
    private long albumPlays = 0;
    private int duration;
    public Album(){

    }
        public Album(
                String albumName, String genre, String releaseDate,
                String cover, int tracks, long albumPlays, int duration
        ) {
        this.albumName = albumName;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.cover = cover;
        this.tracks = tracks;
        this.albumPlays = albumPlays;
        this.duration = duration;
    }

    @ManyToMany
    @JoinTable(
            name = "ArtistToAlbum",
            joinColumns = @JoinColumn(name = "album_Id"),
            inverseJoinColumns = @JoinColumn(name = "artist_Id")
    )
    private List<Artist> albumArtists = new ArrayList<>();
    public void addAlbumArtist(Artist artist){
        albumArtists.add(artist);
    }
    public List<Artist> getAlbumArtists(){
        return albumArtists;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private List<Song> albumSongs = new ArrayList<>();
    public void addAlbumSong(Song song){
        albumSongs.add(song);
    }
    public
    List<Song> getAlbumSongs(){
        return albumSongs;
    }

}
