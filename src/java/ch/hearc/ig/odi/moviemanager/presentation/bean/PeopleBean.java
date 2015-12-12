package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.buisness.Person;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Bean lié à la page pepoleList.xhtml, qui affiche la liste des personnes
 * @author DeillonM
 */
@Named(value = "peopleBean")
@RequestScoped
public class PeopleBean implements Serializable{
    
    @Inject Services services;
    
    public PeopleBean(){
        
    }
    
    /**
     * Retourne une liste de personnes
     * @return Une liste de personnes
     */    
    public List<Person> getPeople(){
        return services.getPeopleList();
    }
}
