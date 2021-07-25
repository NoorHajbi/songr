package com.example.demo;
import com.example.demo.data.Album;
import com.example.demo.data.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

public class SongController {
    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/songs")
    public String getAllSongs(Model m){
        List<Song> songs = songRepository.findAll();
        m.addAttribute("songs",songs);
        return "songs";
    }

    @GetMapping("/addSong")
    public String getAddSong(){
        return "addSongs.html";
    }

    @PostMapping("/songs")
    public RedirectView addSong(@RequestParam(value = "title") String title ,
                                @RequestParam(value="length") double length,
                                @RequestParam(value= "trackNumber") int trackNumber,
                                @RequestParam(value="albumID") Long albumID, Model m){
        Album album = albumRepository.findById(albumID).get();
        Song song = new Song(title,length,trackNumber,album);
        songRepository.save(song);
        Album newAlbum = albumRepository.findById(album.getId()).get();
        m.addAttribute("songs", newAlbum.getSongs());
        return new RedirectView("/songs");
    }
}
