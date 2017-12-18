package edu.upc.eetac.dsa.examenminim2.model;

/**
 * Created by usuario on 30/11/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Usuario implements Serializable
{

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("password")
    @Expose
    private String password;


    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
