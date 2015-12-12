/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.buisness;

import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author DeillonM
 */
public class Person implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private Map<Long, Movie> moviesWatch;

    /**
     * Constructeur par defaut
     */
    public Person() {
    }

    /**
     * Constructeur paramétré pour la classe Person.
     *
     * @param id Le numéro unique d'identification de la personne
     * @param firstName Le prénom de la personne
     * @param lastName Le nom de famille de la personne
     */
    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.moviesWatch = new LinkedHashMap<>();
    }

    /**
     * Ajoute un film à la liste des films.
     *
     * @param movie Le film a ajouter
     * @return Le film qui a été ajouté
     */
    public Movie addMovie(Movie movie) throws UniqueException {
        if (!moviesWatch.containsKey(movie.getId())) {
            this.moviesWatch.put(movie.getId(), movie.addPerson(this));
        } else {
            throw new UniqueException("A movie with this ID already exist.");
        }

        return movie;
    }

    //Getter et Assesseur
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<Long, Movie> getMovies() {
        return moviesWatch;
    }

    public void setMovies(Map<Long, Movie> movies) {
        this.moviesWatch = movies;
    }

}
