package com.example.demo.services;

import com.example.demo.data.Album;
import com.example.demo.data.Song;

import java.util.List;

public interface AlbumService {
    void saveAlbum(Album album);
    List<Album> getAllAlbums();
    Album getAlbum(Long id);
    void deleteAlbum(Album album);
    void updateAlbum(Album album);

    void addSong(Long albumId, Song song);
    List<Song> getAllSongs();
}
