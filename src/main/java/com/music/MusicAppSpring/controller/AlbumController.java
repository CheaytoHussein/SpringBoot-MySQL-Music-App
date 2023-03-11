package com.music.MusicAppSpring.controller;


import com.music.MusicAppSpring.entities.Album;
import com.music.MusicAppSpring.services.impls.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
@CrossOrigin
public class AlbumController {
    @Autowired
    private final AlbumServiceImpl albumService;

    public AlbumController(AlbumServiceImpl albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> getAllAlbums(){
        return albumService.getAllElements();
    }
    @GetMapping("/{id}")
    public Album getAlbumById(@PathVariable(value = "id") Integer id){
        return albumService.getElementById(id);
    }
    @PostMapping("/post")
    public Album createAlbum(@RequestBody Album album){
        return albumService.saveElement(album);
    }
    @PutMapping("/{id}")
    public Album updateAlbum(@RequestBody Album album, @PathVariable(value = "id") Integer id){
        return albumService.updateElement(album, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Album> deleteAlbum(@PathVariable(value = "id") Integer id){
        albumService.deleteElement(id);
        return ResponseEntity.ok().build();
    }
}
