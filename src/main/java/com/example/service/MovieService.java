package com.example.service;

import com.example.DAO.MovieDAO;
import com.example.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*Controller is going to call for  Service and Service is going to call DAO*/

@Service
public class MovieService{

    /*Dependence Injection*/
    @Autowired
    private MovieDAO movieDAO;

    public void save(Movie movie){
        movieDAO.save(movie);
    }

    public List<Movie> findByName(String title){
        List<Movie> movie = movieDAO.findByName(title);
        return movie;
    }

    public void updateMovie (Movie movie){
        movieDAO.save(movie);
    }



}
