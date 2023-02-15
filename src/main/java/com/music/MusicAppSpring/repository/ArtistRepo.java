package com.music.MusicAppSpring.repository;

import com.music.MusicAppSpring.entity.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepo extends CrudRepository<Artist, Integer> {
    List<Artist> findByArtistName(String artistName);
}
