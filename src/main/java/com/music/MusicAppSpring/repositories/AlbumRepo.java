package com.music.MusicAppSpring.repositories;

import com.music.MusicAppSpring.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepo extends JpaRepository<Album, Integer> {
    List<Album> findByAlbumName(String albumName);
    Album findByAlbumId(Integer id);
}
