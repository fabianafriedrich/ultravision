package com.example.service;

import com.example.DAO.MovieDAO;
import com.example.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*Controller is going to call for  Service and Service is going to call DAO*/

@Service
public class MovieService{

    /*Dependence Injection*/
    @Autowired
    private MovieDAO movieDAO;

    public void save(Movie movie){
        movie.setIdMovie(null);
        movieDAO.save(movie);
    }

    public Movie findBy(Long id){
        Movie muvie = movieDAO.findById(id).orElse(null);
        return muvie;
    }

    public void updateMovie (Movie movie){
        movieDAO.save(movie);
    }



}
