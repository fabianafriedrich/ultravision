package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/*Crieting class LiveConsert and Table LiveConsert in database*/
/*implement the Serializable interface when you need to store a copy of the object,
 send them to another process which runs on the same system or over the network.
 It makes storing and sending objects easy. It has nothing to do with security.*/
@Entity
@Table(name = "live_consert")
public class LiveConsert extends Category implements Serializable {

    /*@Id auto increment in database*/
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idLiveConsert;
    private String bandLiveConsert;
    private String genreLiveConsert;
    private Timestamp consertDuration;

    /*Relation between the entitys*/
//    @ManyToOne
//    @JoinColumn(name = "category")
//    private Category category;

    @OneToMany(mappedBy = "liveConsert")
    private List<ItemRent> itemRents;


    /*Default constructor*/
    public LiveConsert(){
        super();
        itemRents = new ArrayList<ItemRent>();
    }

    /*Parametrized Constructor iniciating variables*/

    public LiveConsert(Long idLiveConsert, String bandLiveConsert, String genreLiveConsert,
                       Timestamp consertDuration, Category category, List<ItemRent> itemRents) {
        this.idLiveConsert = idLiveConsert;
        this.bandLiveConsert = bandLiveConsert;
        this.genreLiveConsert = genreLiveConsert;
        this.consertDuration = consertDuration;
//        this.category = category;
        this.itemRents = itemRents;
    }

    /*Getter and setter*/
    public Long getIdLiveConsert() {
        return idLiveConsert;
    }

    public void setIdLiveConsert(Long idLiveConsert) {
        this.idLiveConsert = idLiveConsert;
    }

    public String getBandLiveConsert() {
        return bandLiveConsert;
    }

    public void setBandLiveConsert(String bandLiveConsert) {
        this.bandLiveConsert = bandLiveConsert;
    }

    public String getGenreLiveConsert() {
        return genreLiveConsert;
    }

    public void setGenreLiveConsert(String genreLiveConsert) {
        this.genreLiveConsert = genreLiveConsert;
    }

    public Timestamp getConsertDuration() {
        return consertDuration;
    }

    public void setConsertDuration(Timestamp consertDuration) {
        this.consertDuration = consertDuration;
    }

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
