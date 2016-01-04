/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.buisness.Movie;
import ch.hearc.ig.odi.moviemanager.buisness.Person;
import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @Inject Services services;

    private Person person=null;
    private List<Movie> moviesWatchedAdd;
    private List<Movie> moviesWatchedRemove;

    public personAddMovies() {
    }

    public Person getPerson() {
        return person;
    }

    public String setPerson(Person pers) {
        if(pers !=null){
            person = pers;
            return "addMovies";
        }else{
            person=null;
            return "error";
        }
    }
    
    /**
     * A List of movies the person has not watched yet.
     *
     * @return A List of the movies the person has not watched yet
     */
    public List<Movie> getMoviesNotWatched() {
        List<Movie> moviesNotWatched = services.getMoviesList();
        moviesNotWatched.removeAll(this.person.getMovies().values());
        return moviesNotWatched;
    }

    public List<Movie> getPersonMovie() {
        return new ArrayList(person.getMovies().values());
    }

    public List<Movie> getMoviesWatchedAdd() {
        return moviesWatchedAdd;
    }

    public void setMoviesWatchedAdd(List<Movie> moviesWatchedAdd) {
        this.moviesWatchedAdd = moviesWatchedAdd;
    }

    public List<Movie> getMoviesWatchedRemove() {
        return moviesWatchedRemove;
    }

    public void setMoviesWatchedRemove(List<Movie> moviesWatchedRemove) {
        this.moviesWatchedRemove = moviesWatchedRemove;
    }
    
    public String Save(){
        for (Movie movRemove : moviesWatchedRemove) {
            try {
                this.person.removeMovie(movRemove);
            } catch (UniqueException ex) {
            }
        }
        for (Movie movAdd : moviesWatchedAdd) {
            try {
                this.person.addMovie(movAdd);
            } catch (UniqueException ex) {
            }
        }
        return "ok";

    }

}
