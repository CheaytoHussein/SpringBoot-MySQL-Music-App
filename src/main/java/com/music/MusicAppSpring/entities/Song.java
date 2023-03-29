package com.music.MusicAppSpring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @RequiredArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer songId;
    @NonNull
    private String songName;
    @NonNull
    private String releaseDate;
    @NonNull
    private String cover;
    @NonNull
    private String genre;
    @NonNull
    private String youtubeLink;
    @NonNull
    private int duration;
    private long plays = 0;
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
    public List<Artist> getArtists(){
        return songArtists;
    }
    @ManyToOne
    private Album album;
    public void setAlbum(Album album){
        this.album = album;
    }

    public void incrementPlays(){
        this.plays++;
    }
}
