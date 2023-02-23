package com.music.MusicAppSpring.controller;


import com.music.MusicAppSpring.entities.Album;
import com.music.MusicAppSpring.repositories.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "http://localhost:8080"
)
@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    @Autowired
    private AlbumRepo albumRepo;

    @GetMapping
    public Iterable<Album> getAllAlbums(){
        return this.albumRepo.findAll();
    }
    @GetMapping("/{id}")
    public Album getAlbumById(@PathVariable(value = "id") Integer id){
        return this.albumRepo.findByAlbumId(id);
    }
    @PostMapping("/post")
    public Album createAlbum(@RequestBody Album album){
        return this.albumRepo.save(album);
    }
    @PutMapping("/{id}")
    public Album updateAlbum(@RequestBody Album album, @PathVariable(value = "id") Integer id){
        Album oldAlbum = this.albumRepo.findByAlbumId(id);

        oldAlbum.setAlbumName(album.getAlbumName());
        oldAlbum.setAlbumPlays(album.getAlbumPlays());
        oldAlbum.setAlbumArtists(album.getAlbumArtists());
        oldAlbum.setAlbumSongs(album.getAlbumSongs());
        oldAlbum.setGenre(album.getGenre());
        oldAlbum.setDuration(album.getDuration());
        oldAlbum.setTracks(album.getTracks());
        oldAlbum.setCover(album.getCover());

        return this.albumRepo.save(oldAlbum);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Album> deleteAlbum(@PathVariable(value = "id") Integer id){
        this.albumRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
