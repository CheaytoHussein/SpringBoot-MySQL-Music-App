package com.music.MusicAppSpring.controller;

import com.music.MusicAppSpring.entities.Song;
import com.music.MusicAppSpring.services.impls.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/songs")
@CrossOrigin
public class SongController{
    @Autowired
    private final SongServiceImpl songService;

    public SongController(SongServiceImpl songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> getAllSongs(){
        return songService.getAllElements();
    }
    @GetMapping("/{id}")
    public Song getSongById( @PathVariable(value = "id") Integer id){
        return songService.getElementById(id);
    }
    @PostMapping("/post")
    public Song createSong(@RequestBody Song song){
        return songService.saveElement(song);
    }
    @PutMapping("/update/{id}")
    public Song updateSong(@RequestBody Song song, @PathVariable( value = "id" ) Integer id){
        return songService.updateElement(song, id);
    }
    @PutMapping("/play/{id}")
    public void incrementSongPlays(@PathVariable(value = "id") Integer id){
        songService.incrementPlays(id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Song> deleteSong( @PathVariable( value = "id") Integer id){
        songService.deleteElement(id);
        return ResponseEntity.ok().build();
    }
}
