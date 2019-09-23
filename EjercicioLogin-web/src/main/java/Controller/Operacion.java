/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Ejb.PersonaFacadeLocal;
import Entity.Persona;
import Modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *Metodo que contiene las operaciones propias de la vusta login
 * @author Jonathan
 */
@Named(value = "operacion")
@SessionScoped
public class Operacion implements Serializable {


    /**
     * Objeto que hace referencia a la clase Usuario
     */
    private Usuario usuario;
    
    /**
     * Objeto que hace referencia a la interfaz de Persona para manejar datos mediante persistencia
     */
    @EJB
    private PersonaFacadeLocal personaEjb;
     /**
      * constructor de la clase
      */
    public Operacion() {
        usuario = new Usuario();
        
    }
    
    /**
     * metodo que trae datos de la base de datos recorre los mismos y valida que los dats ingresados por el usuario esten registrados en la misma
     * @return 
     */
    public String validar(){
        
        List<Persona> user = personaEjb.findAll();
        for (Persona user1 : user) {
            if(user1.getCorreo().equals(usuario.getCorreo()) && user1.getContrasena().equals(usuario.getContrasena())){
                FacesContext context = FacesContext.getCurrentInstance();
                //FacesContext faceContext = FacesContext.getCurrentInstance();
                HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
                HttpSession httpSession = request.getSession(false);
                if(user1.getRol() == 1){                   
                    httpSession.setAttribute("usuario", user1);
                    usuario = new Usuario();
                    return "administrador.xhtml";
                }else if(user1.getRol() == 2){
                        httpSession.setAttribute("usuario", user1);
                        usuario = new Usuario();
                        return "usuario.xhtml";
                } 

            }
        }
        FacesMessage message = new FacesMessage("Usuario o Contraseña Invalido");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return null;
    }
    
    /**
     * metodo que muestra mensaje de error al no cumplir con parametros estrablecidos del correo
     */
    public void error() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Correo no valido"));
    }
    /**
     * metodo que retorna atributos del objeto usuario
     * @return Usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }
    /**
     * metodo que modifica atrbutos del objeo usuario
     * @param usuario 
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
