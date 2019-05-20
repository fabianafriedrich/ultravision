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

    /*Relation between the entitys*/
//    @ManyToOne
//    @JoinColumn(name = "category")
//    private Category category;



    /*Default constructor*/
    public LiveConsert(){
        super();
    }

    /*Parametrized Constructor iniciating variables*/

    public LiveConsert(Long idLiveConsert, String bandLiveConsert, String genreLiveConsert,
                       Timestamp consertDuration, Category category) {
        this.idLiveConsert = idLiveConsert;
        this.bandLiveConsert = bandLiveConsert;
        this.genreLiveConsert = genreLiveConsert;
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

}
