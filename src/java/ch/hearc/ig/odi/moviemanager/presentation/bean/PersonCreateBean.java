/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.buisness.Person;
import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Bean lié à la page createPerson.xhtml, qui permet de créer une nouvelle
 * personne ou de la modifier
 *
 * @author DeillonM
 */
@Named(value = "personCreateBean")
@RequestScoped
public class PersonCreateBean implements Serializable {

    @Inject
    Services services;
    private Person person;

    public PersonCreateBean() {

    }

    public String editPerson(Person pers) {
        person = pers;
        return "edit";
    }

    /**
     * Méthode qui permet de sauvegarder une personne saisi.
     *
     * @return "success" si l'enregistrement se passe bien, "errorDuplicate" si
     * le numéro de la personne est déjà utilisé.
     */
    public String savePerson() {
        if(person!=null){
            person = new Person();
        }
        try {
            services.savePerson(person.getId(), person.getFirstName(), person.getLastName());
            return "success";
        } catch (UniqueException Ue) {
            return "errorDuplicate";
        }

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person pers) {
        this.person = pers;
    }
}
