package com.music.MusicAppSpring.repository;

import com.music.MusicAppSpring.entity.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepo extends CrudRepository<Album, Integer> {
    List<Album> findByAlbumName(String albumName);
}
