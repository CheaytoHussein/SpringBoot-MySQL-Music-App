package com.music.MusicAppSpring.repositories;

import com.music.MusicAppSpring.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ArtistRepo extends JpaRepository<Artist, Integer> {
    List<Artist> findByArtistName(String artistName);
    Artist findByArtistId(Integer id);
}
