package com.example.demo;

import com.example.demo.data.Album;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AlbumClassTest {
    @Test
    void testConstructorSettersGetters() {
        Album album = new Album("After Hours", "The Weeknd", 14, 56.19, "https://upload.wikimedia.org/wikipedia/en/c/c1/The_Weeknd_-_After_Hours.png");
        assertThat(album.getSongCount()).isEqualTo(14);
        assertThat(album.getLength()).isEqualTo(56.19);
        //Change some values in setters and test in getter
        album.setTitle("After Hours");
        album.setArtist("The Weeknd");
        album.setSongCount(10);
        album.setLength(60.60);
        assertThat(album.getTitle()).isEqualTo("After Hours");
        assertThat(album.getArtist()).isEqualTo("The Weeknd");
        assertThat(album.getSongCount()).isEqualTo(10);
        assertThat(album.getLength()).isEqualTo(60.60);
        assertThat(album.getImageUrl()).isEqualTo("https://upload.wikimedia.org/wikipedia/en/c/c1/The_Weeknd_-_After_Hours.png");
    }


}
