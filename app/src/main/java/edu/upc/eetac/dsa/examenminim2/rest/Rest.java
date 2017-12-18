package edu.upc.eetac.dsa.examenminim2.rest;

import java.util.List;

import edu.upc.eetac.dsa.examenminim2.model.ListaProductos;
import edu.upc.eetac.dsa.examenminim2.model.Producto;
import edu.upc.eetac.dsa.examenminim2.model.Usuario;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by annag on 18/12/2017.
 */

public interface Rest {

    @GET("listaProductos")
    Call<ListaProductos> getListaProductos();

    @GET("player/{nomPlayer}/{password}")
    Call<Boolean> loginUser(@Path("nomPlayer") String nomPlayer, @Path("password") String password);
}
