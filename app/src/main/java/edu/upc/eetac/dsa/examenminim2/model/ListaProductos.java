package edu.upc.eetac.dsa.examenminim2.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by annag on 18/12/2017.
 */

public class ListaProductos {

    @SerializedName("results")
    private List<Producto> listaProductos;



    public List<Producto> getListaProductos() {
        return listaProductos;
    }
    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
