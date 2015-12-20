/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.buisness;

import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author DeillonM
 */
public class Movie {

    private Long id;
    private String name;
    private String producer;
    private Map<Long, Person> watchers;

    //Constructeur par defaut
    public Movie() {
    }

    public Movie(Long id, String name, String producer) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.watchers = new LinkedHashMap<>();
    }

    /**
     * Ajoute une personne à la liste des personnes.
     *
     * @param person La personne à ajouter
     * @return Le film auquel la personne à été ajouté.
     */
    public Movie addPerson(Person person) throws UniqueException {
        if (!watchers.containsKey(person.getId())) {
            this.watchers.put(person.getId(), person);
        } else {
            throw new UniqueException("A person with this ID already exist.");
        }
        return this;
    }
    
    public Movie removePerson(Person person) throws UniqueException {
        if (watchers.containsKey(person.getId())) {
            this.watchers.remove(person.getId(), person);
        } else {
            throw new UniqueException("The person does not exist in the list.");
        }
        return this;
    }
    
    public int countPeople(){
        return watchers.size();
    }
    
    
    //Getter et Assesseur

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Map<Long, Person> getWatchers() {
        return watchers;
    }

    public void setWatchers(Map<Long, Person> watchers) {
        this.watchers = watchers;
    }
}
