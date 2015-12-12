/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.buisness;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DeillonM
 */
public class Person {
    
    private Long id;
    private String firstName;
    private String lastName;
    private Map<Long, Movie> moviesWatch;
    
    //Constructeur par defaut
    public Person() {
    }

    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.moviesWatch = new LinkedHashMap<>();
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

    public void addMovie(Movie pMovie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
