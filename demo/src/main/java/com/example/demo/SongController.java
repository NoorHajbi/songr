package com.example.demo;
import com.example.demo.data.Album;
import com.example.demo.data.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

public class SongController {
    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/songs")
    public String getAllSongs(Model m){
        m.addAttribute("songs",songRepository.findAll());
        return "song";
    }





}
