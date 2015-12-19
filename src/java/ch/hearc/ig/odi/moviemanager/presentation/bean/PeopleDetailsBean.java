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
@Named(value = "peopleDetailsBean")
@SessionScoped
public class PeopleDetailsBean implements Serializable{
    
    //Injection de la classe Services
    @Inject Services services;
    private Person person;
    
    public PeopleDetailsBean(){
        
    }
    
    /**
     * Méthode qui reçoit une personne à afficher sur la page.
     * @param pers La personne à afficher
     * @return "show" si la personne est valide, "error" si le paramètre est null
     */
    public String showPeople (Person pers){
        if(pers !=null){
            person = pers;
            return "show";
        }else{
            person=null;
            return "error";
        }
    }
    
    /**
     * Retourne les films de la personne, ou un ArrayList vide si la personne n'est pas valide
     * @return Les films de la personne
     */    
    public List<Movie> getMovies(){
        if(person == null){
            return new ArrayList();
        }
        
        return new ArrayList(person.getMovies().values());
    }
    
    public Person getPerson(){
        return person;
    }
    
    public void setPerson(Person pers){
        this.person = pers;
    }
}
