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
        this.watchers=new LinkedHashMap<>();
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
    
}
