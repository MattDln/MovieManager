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
    private List<Movie> moviesWatchedAdd;
    private List<Movie> moviesWatchedRemove;

    public personAddMovies() {

    }

    public String editMovies(Person pers) {
        this.person = pers;
        return "addMovies";
    }

    public List<Movie> getMoviesNotWatched() {
        List<Movie> moviesNotWatched = services.getMoviesList();
        moviesNotWatched.removeAll(this.person.getMovies().values());
        return moviesNotWatched;
    }

    public String moviesSave() throws UniqueException {
        for (Movie watch : moviesWatchedAdd) {
            person.addMovie(watch);
        }
        for (Movie notWatch : moviesWatchedRemove) {
            person.removeMovie(notWatch);
        }
        return "edit";
    }

    public List<Movie> getMovies() {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
