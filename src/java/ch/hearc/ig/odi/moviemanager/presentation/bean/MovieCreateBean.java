/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.buisness.Movie;
import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Bean lié à la page createMovie.xhtml, qui permet de créer un nouveau
 * film ou le modifie
 *
 * @author DeillonM
 */
@Named(value = "movieCreateBean")
@SessionScoped
public class MovieCreateBean implements Serializable{
    
    //Injection de la classe Services
    @Inject Services services;
    
    private Movie movie;
    private Boolean isUpdate;
    
    public MovieCreateBean(){
        
    }
    
    public String editMovie(Boolean isCreate,Movie mov){
        if(isCreate){
            this.movie=new Movie();
            isUpdate=false;
            return "createMovie";
        }else{
            this.movie=mov;
            isUpdate=true;
            return "edit";
        }
    }
    
    public String saveMovie() throws UniqueException{
        if (isUpdate){
            services.updateMovie(movie.getId(), movie);
            return "success";
        }else{
            services.saveMovie(movie.getId(), movie.getName(), movie.getProducer());
            return "success";
        }
    }
    
    public String updateMovie() {
        services.updateMovie(movie.getId(), movie);
        return "success";
    }
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Boolean getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Boolean isUpdate) {
        this.isUpdate = isUpdate;
    }

}
