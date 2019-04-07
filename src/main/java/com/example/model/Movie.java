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

    /*Relation between the entitys*/
//    @ManyToOne
//    @JoinColumn(name = "category")
//    private Category category;

    @OneToMany(mappedBy = "movie")
    private List<ItemRent> itemRents;

    /*Default constructor*/
    public Movie(){
        super();
        itemRents = new ArrayList<ItemRent>();
    }

    /*Parametrized Constructor iniciating variables*/

    public Movie(Long idMovie, String director, String genreMovie, Category category, List<ItemRent> itemRents) {
        this.idMovie = idMovie;
        this.director = director;
        this.genreMovie = genreMovie;
//        this.category = category;
        this.itemRents = itemRents;
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
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    public List<ItemRent> getItemRents() {
        return itemRents;
    }

    public void setItemRents(List<ItemRent> itemRents) {
        this.itemRents = itemRents;
    }
}
