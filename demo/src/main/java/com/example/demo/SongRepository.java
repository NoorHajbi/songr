package com.example.demo;

import com.example.demo.data.Album;
import com.example.demo.data.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

}