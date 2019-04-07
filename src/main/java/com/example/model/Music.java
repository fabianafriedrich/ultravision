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

    /*Relation between the entitys*/
//    @ManyToOne
//    @JoinColumn(name = "category")
//    private Category category;

    @OneToMany(mappedBy = "music")
    private List<ItemRent> itemRents;

    /*Default constructor*/
    public Music(){
        super();
        itemRents = new ArrayList<ItemRent>();
    }

    /*Parametrized Constructor iniciating variables*/

    public Music(Long idMusic, String band, String genreMusic, Category category, List<ItemRent> itemRents) {
        this.idMusic = idMusic;
        this.band = band;
        this.genreMusic = genreMusic;
//        this.category = category;
        this.itemRents = itemRents;
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
