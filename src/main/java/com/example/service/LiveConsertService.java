package com.example.service;

import com.example.DAO.LiveConsertDAO;
import com.example.model.LiveConsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*Controller is going to call for  Service and Service is going to call DAO*/

@Service
public class LiveConsertService {

    /*Dependence Injection*/
    @Autowired
    private LiveConsertDAO liveConsertDAO;

    public void save(LiveConsert liveConsert){
        liveConsert.setIdLiveConsert(null);
        liveConsertDAO.save(liveConsert);
    }

    public LiveConsert findBy(Long id){
        LiveConsert l = liveConsertDAO.findById(id).orElse(null);
        return l;
    }

    public void updateLiveConsert(LiveConsert liveConsert){
        liveConsertDAO.save(liveConsert);
    }



}
