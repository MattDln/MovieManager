/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.buisness.Person;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Bean li� � la page createPerson.xhtml, qui permet de cr�er une nouvelle personne ou de la modifier
 * @author DeillonM
 */
@Named(value="personCreateBean")
@RequestScoped
public class PersonCreateBean implements Serializable{
    
    @Inject Services services;
    private Person person;
    
    public PersonCreateBean(){
        
    }
    
    public String editPerson (Person pers){
        if(pers !=null){
            person = pers;
        }else{
            person=new Person();
        }
        return "edit";
    } 

    /**
     * M�thode qui permet de sauvegarder une personne saisi.
     * @return "success" si l'enregistrement se passe bien, "errorDuplicate" si le num�ro de la personne est d�j� utilis�.
     */
    public String saveCustomer(){
        try{
            services.sa(person.getId(), person.getFirstName(), person.getLastName());
            return "success";
        }catch(DuplicateElementException dee){
            return "errorDuplicate";
        }
        
    }
    
    public Person getPerson(){
        return person;
    }
    
    public void setPerson(Person pers){
        this.person = pers;
    }   
}
