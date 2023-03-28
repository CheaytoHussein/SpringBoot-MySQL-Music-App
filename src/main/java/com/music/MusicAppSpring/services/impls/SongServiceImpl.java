package com.music.MusicAppSpring.services.impls;

import com.music.MusicAppSpring.repositories.SongRepo;
import com.music.MusicAppSpring.services.CRUDService;
import com.music.MusicAppSpring.entities.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements CRUDService<Song, Integer> {
    @Autowired
    private final SongRepo songRepo;
    public void incrementPlays(Integer id){
        songRepo.findBySongId(id).incrementPlays();
        songRepo.save(songRepo.findBySongId(id));
    }
    public SongServiceImpl(SongRepo songRepo){
        this.songRepo = songRepo;
    }
    @Override
    public List<Song> getAllElements(){
        return songRepo.findAll();
    }

    @Override
    public Song saveElement(Song element) {
        return songRepo.save(element);
    }

    @Override
    public Song getElementById(Integer id) {
        return songRepo.findBySongId(id);
    }

    @Override
    public Song updateElement(Song song, Integer id) {
        Song oldSong = songRepo.findBySongId(id);

        oldSong.setSongArtists(song.getArtists());
        oldSong.setSongName(song.getSongName());
        oldSong.setReleaseDate(song.getReleaseDate());
        oldSong.setAlbum(song.getAlbum());
        oldSong.setDuration(song.getDuration());
        oldSong.setCover(song.getCover());
        oldSong.setYoutubeLink(song.getYoutubeLink());
        oldSong.setPlays(song.getPlays());
        oldSong.setGenre(song.getGenre());

        return songRepo.save(oldSong);
    }

    @Override
    public void deleteElement(Integer id) {
        songRepo.deleteById(id);
    }

}
