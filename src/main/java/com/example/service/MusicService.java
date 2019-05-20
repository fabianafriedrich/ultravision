package com.example.service;

import com.example.DAO.MusicDAO;
import com.example.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*Controller is going to call for  Service and Service is going to call DAO*/

@Service
public class MusicService {

    /*Dependence Injection*/
    @Autowired
    private MusicDAO musicDAO;

    public void save(Music music){
        musicDAO.save(music);
    }

    public List<Music> findByName(String title){
        List<Music> musicList = musicDAO.findByName(title);
        return musicList;
    }

    public void updateMusic (Music music){
        musicDAO.save(music);
    }



}
