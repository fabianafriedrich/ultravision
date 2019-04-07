package com.example.service;

import com.example.DAO.MusicDAO;
import com.example.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*Controller is going to call for  Service and Service is going to call DAO*/

@Service
public class MusicService {

    /*Dependence Injection*/
    @Autowired
    private MusicDAO musicDAO;

    public void save(Music music){
        musicDAO.save(music);
    }

    public Music findBy(Long id){
        Music music = musicDAO.findById(id).orElse(null);
        return music;
    }

    public void updateMusic (Music music){
        musicDAO.save(music);
    }



}
