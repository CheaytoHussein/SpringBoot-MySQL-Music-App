package com.music.MusicAppSpring.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String albumName;
    private String genre;
    private String releaseDate;
    private String cover;
    private int tracks;
    private long albumPlays = 0;
    private int duration;
    @Override
    public String toString() {
        return "Album{" +
                "id=" + Id +
                ", albumName='" + albumName + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", cover='" + cover + '\'' +
                ", tracks=" + tracks +
                ", albumPlays=" + albumPlays +
                ", duration=" + duration +
                '}';
    }

    public Album(){

    }
    @ManyToMany
    @JoinTable(
            name = "ArtistToAlbum",
            joinColumns = @JoinColumn(name = "album_Id"),
            inverseJoinColumns = @JoinColumn(name = "artist_Id")
    )
    private List<Artist> albumArtists = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private List<Song> albumSongs = new ArrayList<>();

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

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

    public long getAlbumPlays() {
        return albumPlays;
    }

    public void setAlbumPlays(long albumPlays) {
        this.albumPlays = albumPlays;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
