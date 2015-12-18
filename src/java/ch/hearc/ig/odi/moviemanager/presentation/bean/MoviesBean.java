/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.buisness.Movie;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author DeillonM
 */
@Named (value = "movieBean")
@SessionScoped
public class MoviesBean implements Serializable{
    
    //Injection de la classe Services
    @Inject Services services;
    
    public MoviesBean(){
        
    }
    
    public List<Movie> getMovies(){
        return services.getMoviesList();
    }
    
}
