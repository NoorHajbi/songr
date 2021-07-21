package com.example.demo;

import com.example.demo.data.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AlbumController {
    @GetMapping("/albums")
    public String albums(Model model) {
//        ArrayList<Album> albums = new ArrayList<>();
//        Album adeleAlbum = new Album("25", "Adele", 4, 60.12, "https://images.complex.com/complex/image/upload/c_fill,dpr_auto,f_auto,q_auto,w_1400/fl_lossy,pg_1/Screen_Shot_2015-10-22_at_10.24.49_AM_q21mmk_b9evmv_f7uy9z.jpg?fimg-ssr-default");
//        Album theWeekndAlbum = new Album("After Hours", "The Weeknd", 14, 56.19, "https://upload.wikimedia.org/wikipedia/en/c/c1/The_Weeknd_-_After_Hours.png");
//        Album herAlbum = new Album("Back Of My Mind", "H.E.R", 21, 79.18, "https://images.complex.com/complex/images/c_fill,dpr_auto,f_auto,q_auto,w_1400/fl_lossy,pg_1/pdijoqu4rj26xfj3yhev/her?fimg-ssr-default");
//
//        albums.add(adeleAlbum);
//        albums.add(theWeekndAlbum);
//        albums.add(herAlbum);
//        model.addAttribute("album", albums);
//        return "album";
        model.addAttribute("album", albumRepository.findAll());
        return "album";
    }

 
    @GetMapping("/addAlbum")
    public String addAlbums(){
        return "addAlbums";
    }

    @PostMapping("/albums")
    public RedirectView albumSubmit(@RequestParam(value = "title") String title ,
                                    @RequestParam(value= "artist") String artist,
                                    @RequestParam(value="songCount") int songCount,
                                    @RequestParam(value="length") double length,
                                    @RequestParam(value="imageUrl") String imageUrl){
        Album album = new Album(title,artist,songCount,length,imageUrl);
        albumRepository.save(album);
        return  new RedirectView("/albums");
//        return new ResponseEntity<> (albumRepository, HttpStatus.CREATED);
    }
}
