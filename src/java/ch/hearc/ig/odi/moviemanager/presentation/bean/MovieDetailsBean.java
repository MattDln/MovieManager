/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.buisness.Movie;
import ch.hearc.ig.odi.moviemanager.buisness.Person;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author DeillonM
 */
@Named (value = "movieDetailsBean")
@SessionScoped
public class MovieDetailsBean implements Serializable{
    
    //Injection de la classe Services
    @Inject Services services;
    
    private Movie movie;
    
    public MovieDetailsBean(){
        
    }
    
    /**
     * Méthode qui reçoit le film à afficher sur la page.
     * @param mov Le film à afficher
     * @return "show" si le film est valide, "error" si le paramètre est null
     */
    public String showMovie(Movie mov){
        if(mov != null){
            movie = mov;
            return "show";
        }else{
            movie = null;
            return "error";
        }
    }
    
    /**
     * Retourne les personnes du film, ou un ArrayList vide si le film n'est pas valide
     * @return Les personnes d'un film
     */
    public List<Person> getPeople(){
        if(movie == null){
            return new ArrayList();
        }
        
        return new ArrayList(movie.getWatchers().values());
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
