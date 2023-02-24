package com.music.MusicAppSpring.controller;


import com.music.MusicAppSpring.entities.Artist;
import com.music.MusicAppSpring.repositories.ArtistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/artists")
@CrossOrigin
public class ArtistController {
    @Autowired
    private ArtistRepo artistRepo;

    @GetMapping
    public Iterable<Artist> getAllArtists(){
        return this.artistRepo.findAll();
    }
    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable(value = "id") Integer id){
        return this.artistRepo.findByArtistId(id);
    }
    @PostMapping("/post")
    public Artist createArtist(@RequestBody Artist artist){
        return this.artistRepo.save(artist);
    }
    @PutMapping("/{id}")
    public Artist updateArtist(@RequestBody Artist artist, @PathVariable(value = "id") Integer id){
        Artist oldArtist =  this.artistRepo.findByArtistId(id);

        oldArtist.setArtistName(artist.getArtistName());
        oldArtist.setSongs(artist.getSongs());
        oldArtist.setCover(artist.getCover());
        oldArtist.setPlays(artist.getPlays());
        oldArtist.setSongCount(artist.getSongCount());
        oldArtist.setGenre(artist.getGenre());
        oldArtist.setDescription(artist.getDescription());
        oldArtist.setAlbums(artist.getAlbums());
        oldArtist.setAlbumCount(artist.getAlbumCount());

        return this.artistRepo.save(oldArtist);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Artist> deleteArtist(@PathVariable(value = "id") Integer id){
        this.artistRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

