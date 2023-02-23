package com.music.MusicAppSpring.controller;

import com.music.MusicAppSpring.entities.Song;
import com.music.MusicAppSpring.repositories.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(
        origins = "http://localhost:8080"
)
@RestController
@RequestMapping("/api/songs")
public class SongController{
    @Autowired
    private SongRepo songRepo;
    @GetMapping
    public Iterable<Song> getAllSongs(){
        return this.songRepo.findAll();
    }
    @GetMapping("/{id}")
    public Song getSongById( @PathVariable(value = "id") Integer id){
        return this.songRepo.findBySongId(id);
    }
    @PostMapping("/post")
    public Song createSong(@RequestBody Song song){
        return this.songRepo.save(song);
    }
    @PutMapping("/{id}")
    public Song updateSong(@RequestBody Song song, @PathVariable( value = "id" ) Integer id){

        Song oldSong = this.songRepo.findBySongId(id);

        oldSong.setSongArtists(song.getArtists());
        oldSong.setSongName(song.getSongName());
        oldSong.setReleaseDate(song.getReleaseDate());
        oldSong.setAlbum(song.getAlbum());
        oldSong.setDuration(song.getDuration());
        oldSong.setCover(song.getCover());
        oldSong.setPlays(song.getPlays());
        oldSong.setGenre(song.getGenre());

        return this.songRepo.save(oldSong);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Song> deleteSong( @PathVariable("id") Integer id){
        Song song = this.songRepo.findBySongId(id);
        this.songRepo.delete(song);
        return ResponseEntity.ok().build();
    }
//======================================================================================================================
//    ARTIST API METHODS : GET | POST | PUT | DELETE
//======================================================================================================================

//    @GetMapping("/artists/{id}")
//    public Artist getArtistById( @PathVariable(value = "id") Integer id){
//        return this.artistRepo.findByArtistId(id);
//    }
//    @GetMapping("/artists/{id}")
//    public List<Artist> getArtistByName(String name){
//        return this.artistRepo.findByArtistName(name);
//    }
//
//    @PostMapping
//    public Artist createArtist(@RequestBody Artist artist){
//        return this.artistRepo.save(artist);
//    }
//    @PutMapping("/artists/{id}")
//    public Artist updateArtist(@RequestBody Artist artist, @PathVariable( value = "id" ) Integer id){
//
//        Artist oldArtist = this.artistRepo.findByArtistId(id);
//
//        oldArtist.setArtistName(artist.getArtistName());
//        oldArtist.setAlbums(artist.getAlbums());
//        oldArtist.setDescription(artist.getDescription());
//        oldArtist.setCover(artist.getCover());
//        oldArtist.setGenre(artist.getGenre());
//        oldArtist.setPlays(artist.getPlays());
//        oldArtist.setAlbumCount(artist.getAlbumCount());
//        oldArtist.setSongs(artist.getSongs());
//        oldArtist.setSongCount(artist.getSongCount());
//
//        return this.artistRepo.save(oldArtist);
//    }
//    @DeleteMapping("/artists/{id}")
//    public ResponseEntity<Artist> deleteArtist( @PathVariable("id") Integer id){
//        Artist artist = this.artistRepo.findByArtistId(id);
//        this.artistRepo.delete(artist);
//        return ResponseEntity.ok().build();
//    }

//======================================================================================================================
//======================================================================================================================
//======================================================================================================================

}
