package com.music.MusicAppSpring;

import com.music.MusicAppSpring.entity.Song;
import com.music.MusicAppSpring.repository.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicAppSpringApplication implements CommandLineRunner {
	@Autowired
	SongRepo songRepo;
	public static void main(String[] args) {
		SpringApplication.run(MusicAppSpringApplication.class, args);
	}
	@Override
	public void run(String... args){
		Song lady = new Song("lady",1000, "pop", 145);
		songRepo.save(lady);

		songRepo.findBySongName("lady").forEach(
				val -> System.out.println(val)
		);
	}
}
