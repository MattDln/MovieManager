/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

/**
 * Ce bean sert � changer la langue de l'application. Il permet notamment
 * d'utiliser une droplist sur la page html et de changer de language � la vol�e
 * gr�ce � la m�thode <code>localeChanged</code>.
 *
 * @author DeillonM
 */
@Named (value = "lanBean")
@SessionScoped
@Stateful
public class LanBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String language;
    private Locale locale;
    private static final Map<String, Object> languages;

    static {
        languages = new LinkedHashMap<>();
        languages.put("Fran�ais", Locale.FRENCH);
        languages.put("English", Locale.ENGLISH);
    }

    /**
     * Contient la liste des languages disponible. Il s'agit d'une liste static
     * et doit donc �tre modifi�e pour ajouter de nouvelles langues.
     *
     * @return Une Map des languages
     */
    public Map<String, Object> getLanguages() {
        return languages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * Cette m�thode s'initialise avant le chargement du Bean gr�ce �
     * l'annotation <code>@PostConstruct</code>. Son r�le est d'aller chercher
     * la Locale du navigateur et, si elle fait partie des langues support�es,
     * la met par d�faut. Dans le cas o� celle-ci n'est pas support�e, la langue
     * par d�faut de l'application, le fran�ais, est d�finie.
     *
     */
    @PostConstruct
    public void init() {
        Locale browserLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        if (languages.containsValue(browserLocale)) {
            FacesContext.getCurrentInstance().getViewRoot().setLocale(browserLocale);
            locale = browserLocale;
        } else {
            FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.FRENCH); //Default Locale
            locale = Locale.FRENCH;
        }
    }

    //value change event listener
    /**
     * Cette m�thode est appel�e lorsque la valeur du language est chang�e au
     * sein de l'application. Le but est que le changement de langue soit
     * dynamique.
     *
     * @param e
     */
    public void localeChanged(ValueChangeEvent e) {
        String newLocaleValue = e.getNewValue().toString();

        for (Map.Entry<String, Object> entry : languages.entrySet()) {
            if (entry.getValue().toString().equals(newLocaleValue)) {
                Locale newLocale = (Locale) entry.getValue();
                FacesContext.getCurrentInstance().getViewRoot().setLocale(newLocale);
                setLocale(newLocale);
            }
        }
    }
}
