package com.music.MusicAppSpring;

import com.music.MusicAppSpring.entities.Artist;
import com.music.MusicAppSpring.entities.Song;
import com.music.MusicAppSpring.repositories.AlbumRepo;
import com.music.MusicAppSpring.repositories.ArtistRepo;
import com.music.MusicAppSpring.repositories.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class MusicAppSpringApplication{
	public static void main(String[] args) {
		SpringApplication.run(MusicAppSpringApplication.class, args);
	}
//	@Override
//	public void run(String... args){
//
//	}
}
