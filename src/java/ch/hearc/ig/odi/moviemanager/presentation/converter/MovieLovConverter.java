/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.converter;

import ch.hearc.ig.odi.moviemanager.buisness.Movie;
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

@Named (value = "movieLovConverter")
@RequestScoped
public class MovieLovConverter implements Converter{
    
    //Injection de la classe Services
    @Inject Services services;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null){
            return null;
        }else{
            for (Movie mov : services.getMoviesList()) {
                if (mov.getId() == Integer.parseInt(value)){
                    return mov;
                }
            }
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      if(value == null){
            return "";
        }else if(value instanceof Movie){
            return String.valueOf(((Movie)value).getId());
        }else{
            return "";
        }
    }
    
}
