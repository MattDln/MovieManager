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
@Named(value = "movieAddPeople")
@SessionScoped
public class MovieAddPeople implements Serializable {

    //Injection de la classe Services
    @Inject Services services;

    private Movie movie=null;
    private List<Person> peopleWatchedAdd;
    private List<Person> peopleWatchedRemove;

    public MovieAddPeople() {
    }

    public Movie getMovie() {
        return movie;
    }

    public String setMovie(Movie mov) {
        if(mov !=null){
            movie = mov;
            return "addPeople";
        }else{
            movie=null;
            return "error";
        }
    }
    
    /**
     * A List of movies the person has not watched yet.
     *
     * @return A List of the movies the person has not watched yet
     */
    public List<Person> getPeopleNotWatched() {
        List<Person> peopleNotWatched = services.getPeopleList();
        peopleNotWatched.removeAll(this.movie.getWatchers().values());
        return peopleNotWatched;
    }

    public List<Person> getMoviePerson() {
        return new ArrayList(movie.getWatchers().values());
    }

    public List<Person> getPeopleWatchedAdd() {
        return peopleWatchedAdd;
    }

    public void setPeopleWatchedAdd(List<Person> peopleWatchedAdd) {
        this.peopleWatchedAdd = peopleWatchedAdd;
    }

    public List<Person> getPeopleWatchedRemove() {
        return peopleWatchedRemove;
    }

    public void setPeopleWatchedRemove(List<Person> peopleWatchedRemove) {
        this.peopleWatchedRemove = peopleWatchedRemove;
    }
    
    public String peopleSave(){
        for (Person persRemove : peopleWatchedRemove) {
            try {
                this.movie.removePerson(persRemove);
            } catch (UniqueException ex) {
                return "failure";
            }
        }

        for (Person persAdd : peopleWatchedAdd) {
            try {
                this.movie.addPerson(persAdd);
            } catch (UniqueException ex) {
                return "failure";
            }
            
        }
        return "success";

    }

}
