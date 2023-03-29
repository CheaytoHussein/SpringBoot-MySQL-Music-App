package com.music.MusicAppSpring.services.impls;

import com.music.MusicAppSpring.entities.Album;
import com.music.MusicAppSpring.repositories.AlbumRepo;
import com.music.MusicAppSpring.repositories.SongRepo;
import com.music.MusicAppSpring.services.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlbumServiceImpl implements CRUDService<Album,Integer> {
    @Autowired
    private final AlbumRepo albumRepo;
    public AlbumServiceImpl(AlbumRepo albumRepo){
        this.albumRepo = albumRepo;
    }
    @Override
    public List<Album> getAllElements() {
        return albumRepo.findAll();
    }

    @Override
    public Album saveElement(Album element) {
        return albumRepo.save(element);
    }

    @Override
    public Album getElementById(Integer id) {
        return albumRepo.findByAlbumId(id);
    }

    @Override
    public Album updateElement(Album album, Integer id) {

        Album oldAlbum = albumRepo.findByAlbumId(id);

        oldAlbum.setAlbumName(album.getAlbumName());
        oldAlbum.setAlbumArtists(album.getAlbumArtists());
        oldAlbum.setAlbumSongs(album.getAlbumSongs());
        oldAlbum.setGenre(album.getGenre());
        oldAlbum.setCover(album.getCover());

        return albumRepo.save(oldAlbum);
    }

    @Override
    public void deleteElement(Integer id) {
        albumRepo.deleteById(id);
    }
}
