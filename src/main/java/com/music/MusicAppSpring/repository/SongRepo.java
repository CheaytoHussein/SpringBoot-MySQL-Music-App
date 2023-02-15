package com.music.MusicAppSpring.repository;

import com.music.MusicAppSpring.entity.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepo extends CrudRepository<Song, Integer> {
    List<Song> findBySongName(String songName);
}
