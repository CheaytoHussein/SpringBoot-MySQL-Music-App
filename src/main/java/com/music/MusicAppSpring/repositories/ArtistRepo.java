package com.music.MusicAppSpring.repositories;

import com.music.MusicAppSpring.entities.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepo extends CrudRepository<Artist, Integer> {
    List<Artist> findByArtistName(String artistName);
    Artist findByArtistId(Integer id);
}
