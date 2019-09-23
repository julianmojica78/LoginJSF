/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Persona;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *ManagedBean que se utiliza para realizar operaciones propias de la vista usuario
 * @author Jonathan
 */
@ManagedBean
@SessionScoped
public class BeanUsuario implements Serializable {

    /**
     * Creates a new instance of BeanUsuario
     */
    /**
     * objeto de la clase persona que contiene atributos propios de persona
     */
    private Persona persona;
    /**
     * atributo utilizado en las variables de sesion
     */
    FacesContext context = FacesContext.getCurrentInstance();
    /**
     * atributo utilizado en las variables de sesion
     */
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    /**
     * atributo utilizado en las variables de sesion
     */
    HttpSession httpSession = request.getSession(false);
    
    
    /**
     * Metodo que se ejecuta al haberse constuido la clase
     * En este metodo se hace la validacion de datos de usuarios guardados en variables de sesion
     */
    @PostConstruct
    public void sesionAdmin(){
         
         this.setPersona((Persona)httpSession.getAttribute("usuario"));
         if(persona  == null){
             // Redirecciono:
            FacesContext facesContext = FacesContext.getCurrentInstance();
            try {
                request= null;
                facesContext.getExternalContext().redirect("login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(BeanUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         if(persona.getRol()!=2){
             FacesContext facesContext = FacesContext.getCurrentInstance();
            try {
                request= null;
                facesContext.getExternalContext().redirect("administrador.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(BeanUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         

         
    }
    /**
     * metodo que retorna el nombre del usuario logueado alojado en la variable de sesion
     * @return String
     */
    public String nombre(){
        if(persona == null){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            try {
                request= null;
                facesContext.getExternalContext().redirect("login.xhtml");
                
            } catch (IOException ex) {
                Logger.getLogger(BeanUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            return persona.getNombre();
        }
        return null;
    }
    
    /**
     * metodo utilizado para eliminar variables de sesion
     * @return String
     */
    public String cerrarSesion(){
        persona = null;
        httpSession.setAttribute("usuario", null);
        return "login.xhtml";
    }

    /**
     * Metodo que retorna los atributos de persona
     * @return Persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Metodo que modifica atributos propios de la clase persona
     * @param persona 
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    
    
    
}
