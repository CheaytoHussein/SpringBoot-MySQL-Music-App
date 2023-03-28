package com.music.MusicAppSpring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @RequiredArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer albumId;
    @NonNull
    private String albumName;
    @NonNull
    private String genre;
    @NonNull
    private String releaseDate;
    @NonNull
    private String cover;
    private int tracks = 0;
    private long albumPlays = 0;
    private int duration = 0;
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
        this.duration += song.getDuration();
        this.tracks = albumSongs.size();
    }
    public List<Song> getAlbumSongs(){
        return albumSongs;
    }

    public void incrementPlays(){
        albumPlays++;
    }
}
