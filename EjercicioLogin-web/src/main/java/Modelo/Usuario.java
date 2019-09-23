/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *clase que contiene atributos propios de un usuario
 * @author Jonathan
 */
public class Usuario implements Serializable{
    
    /**
     * atributo que hace referencia al id guardado en base de datos
     */
    private int id;
    /**
     * atributo que hace referencia al nombre del usuario
     */
    private String nombre;
    /**
     * atributo que hace referencia a la contraseña registrada en base de datos por el usuario
     */
    private String contrasena;
    /**
     * atributo que hace referencia al correo registrado en base de datos por el usuario
     */
    private String correo;
    /**
     * atributo que hace referencia al rol especifico del usuario
     */
    private int rol;
    /**
     * constructor de la clase
     */
    public Usuario() {
    }
    /**
     * metodo que retorna el id del usuario
     * @return int
     */
    public int getId() {
        return id;
    }
    /**
     * metodo que modifica el id del usuario
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * metodo que retorna el nombre del usuario
     * @return String
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * metodo que modifica el nombre del usuario
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * metodo que retorna la contraeña del usuario
     * @return String
     */
    public String getContrasena() {
        return contrasena;
    }
    /**
     * metodo que modifica la contraseña del usuario
     * @param contrasena 
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    /**
     * metodo que retorna el correo del usuario
     * @return String
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * metodo que modifica el correo del usuario
     * @param correo 
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * metodo que retorna el rol del usuario
     * @return int
     */
    public int getRol() {
        return rol;
    }
    /**
     * metodo que modifica el rol del usuario
     * @param rol 
     */
    public void setRol(int rol) {
        this.rol = rol;
    }
    
    
    
}
