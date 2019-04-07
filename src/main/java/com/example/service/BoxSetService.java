package com.example.service;

import com.example.DAO.BoxSetDAO;
import com.example.model.BoxSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/*Controller is going to call for  Service and Service is going to call DAO*/

@Service
public class BoxSetService{

    /*Dependence Injection*/
    @Autowired
    private BoxSetDAO boxSetDAO;

    public void save(BoxSet boxSet){
        boxSet.setIdBoxSet(null);
        boxSetDAO.save(boxSet);
    }

    public BoxSet findBy(Long id){
        BoxSet b = boxSetDAO.findById(id).orElse(null);
        return b;
    }

    public void updateBoxSet(BoxSet boxSet){
        boxSetDAO.save(boxSet);
    }



}
