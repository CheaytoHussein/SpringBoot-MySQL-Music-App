package com.music.MusicAppSpring.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
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
    @Override
    public String toString() {
        return "Artist{" +
                "id=" + Id +
                ", artistName='" + artistName + '\'' +
                ", songCount=" + songCount +
                ", albumCount=" + albumCount +
                ", plays=" + plays +
                ", description='" + description + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }
    public Artist(){

    }
    public Artist(
            String artistName, int songCount, int albumCount,
            long plays, String description, String cover
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
    @ManyToMany(mappedBy = "songArtists")
    private List<Song> songs = new ArrayList<>();
    public void addAlbum(Album album){
        albums.add(album);
    }
    public String getAlbums(){
        return albums.toString();
    }
    public void addSong(Song song){
        songs.add(song);
    }
    public String getSongs(){
        return songs.toString();
    }
    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public int getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(int albumCount) {
        this.albumCount = albumCount;
    }

    public long getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

}
