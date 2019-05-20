package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*Crieting class Movie and Table Movie in database*/
/*implement the Serializable interface when you need to store a copy of the object,
 send them to another process which runs on the same system or over the network.
 It makes storing and sending objects easy. It has nothing to do with security.*/
@Entity
@Table(name = "movie")
public class Movie extends Category implements Serializable {

    /*@Id auto increment in database*/
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idMovie;
    private String director;
    private String genreMovie;


    /*Default constructor*/
    public Movie(){
        super();
    }

    /*Parametrized Constructor iniciating variables*/

    public Movie(Long idMovie, String director, String genreMovie, Category category) {
        this.idMovie = idMovie;
        this.director = director;
        this.genreMovie = genreMovie;
    }

    /*Getter and setter*/
    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenreMovie() {
        return genreMovie;
    }

    public void setGenreMovie(String genreMovie) {
        this.genreMovie = genreMovie;
    }

}
