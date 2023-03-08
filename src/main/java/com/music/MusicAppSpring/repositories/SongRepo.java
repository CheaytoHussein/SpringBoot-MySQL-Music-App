package com.music.MusicAppSpring.repositories;

import com.music.MusicAppSpring.entities.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepo extends CrudRepository<Song, Integer> {
    List<Song> findBySongName(String songName);
    Song findBySongId(Integer id);
    @Query("SELECT song FROM Song song WHERE " +
            "song.songName LIKE CONCAT('%',:query, '%')")
    List<Song> searchSongs(String query);
}
