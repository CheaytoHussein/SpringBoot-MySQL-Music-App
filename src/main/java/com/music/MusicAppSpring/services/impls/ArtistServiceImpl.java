package com.music.MusicAppSpring.services.impls;

import com.music.MusicAppSpring.entities.Artist;
import com.music.MusicAppSpring.repositories.ArtistRepo;
import com.music.MusicAppSpring.services.CRUDService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArtistServiceImpl implements CRUDService<Artist, Integer> {
    ArtistRepo artistRepo;
    public ArtistServiceImpl(ArtistRepo artistRepo){
        this.artistRepo = artistRepo;
    }
    @Override
    public List<Artist> getAllElements() {
        return artistRepo.findAll();
    }

    @Override
    public Artist saveElement(Artist artist) {
        return artistRepo.save(artist);
    }

    @Override
    public Artist getElementById(Integer id) {
        return artistRepo.findByArtistId(id);
    }

    @Override
    public Artist updateElement(Artist artist, Integer id) {
        Artist oldArtist =  artistRepo.findByArtistId(id);

        oldArtist.setArtistName(artist.getArtistName());
        oldArtist.setSongs(artist.getSongs());
        oldArtist.setCover(artist.getCover());
        oldArtist.setGenre(artist.getGenre());
        oldArtist.setDescription(artist.getDescription());
        oldArtist.setAlbums(artist.getAlbums());

        return artistRepo.save(oldArtist);
    }

    @Override
    public void deleteElement(Integer id) {
        artistRepo.deleteById(id);
    }
}
