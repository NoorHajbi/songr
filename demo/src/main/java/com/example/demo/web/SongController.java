package com.example.demo.web;


import com.example.demo.infrastructure.AlbumRepository;
import com.example.demo.infrastructure.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public class SongController {
    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/songs")
    public String getAllSongs(Model m) {
        m.addAttribute("songs", songRepository.findAll());
        return "song";
    }

}
