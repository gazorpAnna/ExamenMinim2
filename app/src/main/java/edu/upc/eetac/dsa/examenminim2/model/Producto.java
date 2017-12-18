package edu.upc.eetac.dsa.examenminim2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Producto implements Serializable {

    @SerializedName("nombreProd")
    @Expose
    private String nombreProd;

    @SerializedName("precio")
    @Expose
    private int precio;

    public Producto(String nombreProd, int precio) {
        this.nombreProd = nombreProd;
        this.precio = precio;
    }

    public Producto(Producto p){
        this.nombreProd = p.getNombreProd();
        this.precio = p.getPrecio();
    }


    public String getNombreProd() {
        return nombreProd;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombreProd='" + nombreProd + '\'' +
                ", precio=" + precio +
                '}';
    }
}
