package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*Crieting class Music and Table Music in database*/
/*implement the Serializable interface when you need to store a copy of the object,
 send them to another process which runs on the same system or over the network.
 It makes storing and sending objects easy. It has nothing to do with security.*/
@Entity
@Table(name = "music")
public class Music extends Category implements Serializable {

     /*@Id auto increment in database*/
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idMusic;
    private String band;
    private String genreMusic;

    /*Default constructor*/
    public Music(){
        super();
    }

    /*Parametrized Constructor iniciating variables*/

    public Music(Long idMusic, String band, String genreMusic, Category category) {
        this.idMusic = idMusic;
        this.band = band;
        this.genreMusic = genreMusic;
    }

    /*Getter and setter*/
    public Long getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(Long idMusic) {
        this.idMusic = idMusic;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getGenreMusic() {
        return genreMusic;
    }

    public void setGenreMusic(String genreMusic) {
        this.genreMusic = genreMusic;
    }
}
