/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.converter;

import ch.hearc.ig.odi.moviemanager.buisness.Movie;
import ch.hearc.ig.odi.moviemanager.buisness.Person;
import ch.hearc.ig.odi.moviemanager.service.Services;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author DeillonM
 */
@Named (value = "personLovConverter")
@RequestScoped
public class PersonLovConverter implements Converter{
    
    //Injection de la classe Services
    @Inject Services services;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null){
            return null;
        }else{
            for (Person pers : services.getPeopleList()) {
                if (pers.getId() == Integer.parseInt(value)){
                    return pers;
                }
            }
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      if(value == null){
            return "";
        }else if(value instanceof Person){
            return String.valueOf(((Person)value).getId());
        }else{
            return "";
        }
    }
    
}
