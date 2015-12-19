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
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Bean lié à la page createPerson.xhtml, qui permet de créer une nouvelle
 * personne ou de la modifier
 *
 * @author DeillonM
 */
@Named(value = "personCreateBean")
@SessionScoped
public class PersonCreateBean implements Serializable {

    //Injection de la classe Services
    @Inject Services services;
    private Person person;
    private Boolean isUpdate;

    public PersonCreateBean() {

    }

    public String editPerson(Boolean isCreate, Person pers) {
        if (isCreate) {
            this.person = new Person();
            isUpdate = false;
            return "createPerson";
        } else {
            this.person = pers;
            isUpdate = true;
            return "edit";
        }
    }

    /**
     * Méthode qui permet de sauvegarder une personne saisi.
     *
     * @return "success" si l'enregistrement se passe bien, "errorDuplicate" si
     * le numéro de la personne est déjà utilisé.
     */
    public String savePerson() throws UniqueException {
        if (isUpdate) {
            services.updatePerson(person.getId(), person);
            return "success";
        } else {
            services.savePerson(person.getId(), person.getFirstName(), person.getLastName());
            return "success";
        }
    }

    public String updatePerson() {
        services.updatePerson(person.getId(), person);
        return "success";
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person pers) {
        this.person = pers;
    }

    public Boolean getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Boolean isUpdate) {
        this.isUpdate = isUpdate;
    }
}
