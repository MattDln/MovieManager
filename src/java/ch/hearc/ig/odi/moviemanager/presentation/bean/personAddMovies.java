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
@Named(value = "personAddMovies")
@SessionScoped
public class personAddMovies implements Serializable {

    //Injection de la classe Services
    @Inject
    Services services;

    private Person person;

    public personAddMovies() {

    }

    public String editMovies(Person pers) {
        this.person = pers;
        return "addMovies";
    }

    
    public List<Movie> getMoviesNotWatched(){
        List<Movie> moviesNotWatched = services.getMoviesList();
        moviesNotWatched.removeAll(this.person.getMovies().values());
        return moviesNotWatched;
    }

    public List<Movie> converList(List<String> movies){
        Movie movieTmp;
        List<Movie> moviList = new ArrayList<>();
        for (String movieString:movies){
            movieTmp=services.getMoviesList().get(Integer.parseInt(movieString.split(",")[0]));
            moviList.add(movieTmp);
        }
        return moviList;
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }    
}
