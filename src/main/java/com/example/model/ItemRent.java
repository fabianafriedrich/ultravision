package com.example.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;

/*Crieting class ItemRent and Table ItemRent in database*/
/*implement the Serializable interface when you need to store a copy of the object,
 send them to another process which runs on the same system or over the network.
 It makes storing and sending objects easy. It has nothing to do with security.*/
@Entity
@Table(name = "itemRent")
public class ItemRent implements Serializable{

    /*@Id auto increment in database*/
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idItemRent;
    private Integer quantity;

    /*Relation between the entitys*/
    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Music music;

    @ManyToOne
    private LiveConsert liveConsert;

    @ManyToOne
    private BoxSet boxSet;

    @ManyToOne
    private Rent rent;


    /*Default constructor*/
    public ItemRent(){

    }

    /*Parametrized Constructor iniciating variables*/

    public ItemRent(Integer idItemRent, Integer quantity, Movie movie, Music music, LiveConsert liveConsert, BoxSet boxSet,
                    Rent rent) {
        this.idItemRent = idItemRent;
        this.quantity = quantity;
        this.movie = movie;
        this.music = music;
        this.liveConsert = liveConsert;
        this.boxSet = boxSet;
        this.rent = rent;
    }

    public Integer getIdItemRent() {
        return idItemRent;
    }

    public void setIdItemRent(Integer idItemRent) {
        this.idItemRent = idItemRent;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public LiveConsert getLiveConsert() {
        return liveConsert;
    }

    public void setLiveConsert(LiveConsert liveConsert) {
        this.liveConsert = liveConsert;
    }

    public BoxSet getBoxSet() {
        return boxSet;
    }

    public void setBoxSet(BoxSet boxSet) {
        this.boxSet = boxSet;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }
}
