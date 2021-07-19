package com.example.demo;
import com.example.demo.data.Album;
import com.example.demo.data.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class SongController {
    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepositry;

    @GetMapping("/songs")
    public String getAllSongs(Model m){
        List<Song> songs = songRepository.findAll();
        m.addAttribute("songs",songs);
        return "songs";
    }

    @GetMapping("/addSong")
    public String getAddSong(){
        return "addSongs";
    }

    @PostMapping("/songs")
    public String addSong(@RequestParam(value = "title") String title ,
                          @RequestParam(value="length") double length,
                          @RequestParam(value= "trackNumber") int trackNumber,
                          @RequestParam(value="albumID") Long albumID, Model m){
        Album album = albumRepositry.findById(albumID).get();
        Song song = new Song(title,length,trackNumber,album);
        songRepository.save(song);
        Album newAlbum = albumRepositry.findById(album.getId()).get();
        m.addAttribute("songs", newAlbum.getSongs());
        return "/songs";
    }
}
