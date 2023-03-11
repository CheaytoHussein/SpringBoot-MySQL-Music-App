package com.music.MusicAppSpring.controller;


import com.music.MusicAppSpring.entities.Artist;
import com.music.MusicAppSpring.services.impls.ArtistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/artists")
@CrossOrigin
public class ArtistController {
    @Autowired
    private final ArtistServiceImpl artistService;

    public ArtistController(ArtistServiceImpl artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public Iterable<Artist> getAllArtists(){
        return artistService.getAllElements();
    }
    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable(value = "id") Integer id){
        return artistService.getElementById(id);
    }
    @PostMapping("/post")
    public Artist createArtist(@RequestBody Artist artist){
        return artistService.saveElement(artist);
    }
    @PutMapping("/{id}")
    public Artist updateArtist(@RequestBody Artist artist, @PathVariable(value = "id") Integer id){
        return artistService.updateElement(artist, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Artist> deleteArtist(@PathVariable(value = "id") Integer id){
        artistService.deleteElement(id);
        return ResponseEntity.ok().build();
    }
}

