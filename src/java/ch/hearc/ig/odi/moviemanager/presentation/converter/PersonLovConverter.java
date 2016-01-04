/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.converter;

import ch.hearc.ig.odi.moviemanager.buisness.Person;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author DeillonM
 */
@Named (value = "personLovConverter")
public class PersonLovConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
