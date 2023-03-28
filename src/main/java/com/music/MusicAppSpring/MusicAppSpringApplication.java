package com.music.MusicAppSpring;

import com.music.MusicAppSpring.entities.Album;
import com.music.MusicAppSpring.entities.Artist;
import com.music.MusicAppSpring.entities.Song;
import com.music.MusicAppSpring.repositories.AlbumRepo;
import com.music.MusicAppSpring.repositories.ArtistRepo;
import com.music.MusicAppSpring.repositories.SongRepo;
import com.music.MusicAppSpring.services.impls.AlbumServiceImpl;
import com.music.MusicAppSpring.services.impls.ArtistServiceImpl;
import com.music.MusicAppSpring.services.impls.SongServiceImpl;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MusicAppSpringApplication{
	public static void main(String[] args) {
		SpringApplication.run(MusicAppSpringApplication.class, args);
	}
//	@Autowired
//	SongServiceImpl songService;
//	@Autowired
//	AlbumServiceImpl albumService;
//	@Autowired
//	ArtistServiceImpl artistService;
//	@Override
//	public void run(String... args){
//
//	}
}
