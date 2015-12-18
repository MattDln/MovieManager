/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.buisness.Movie;
import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Bean lié à la page createMovie.xhtml, qui permet de créer un nouveau
 * film ou le modifie
 *
 * @author DeillonM
 */
@Named(value = "movieCreateBean")
@SessionScoped
public class MovieCreateBean implements Serializable{
    
    @Inject Services services;
    private Movie movie =new Movie();
    
    public MovieCreateBean(){
        
    }
    
    public String editMovie(Movie mov){
        this.movie = mov;
        return "edit";
    }
    
    public String saveMovie(){
        try {
            services.saveMovie(movie.getId(), movie.getName(), movie.getProducer());
            return "success";
        } catch (UniqueException Ue) {
           return "errorDuplicate";
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
