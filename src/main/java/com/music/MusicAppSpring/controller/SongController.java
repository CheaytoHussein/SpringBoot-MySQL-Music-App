package com.music.MusicAppSpring.controller;

import com.music.MusicAppSpring.entities.Song;
import com.music.MusicAppSpring.repositories.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/songs")
@CrossOrigin
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
        oldSong.setYoutubeLink(song.getYoutubeLink());
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
}
