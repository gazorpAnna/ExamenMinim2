package edu.upc.eetac.dsa.examenminim2.rest;

import edu.upc.eetac.dsa.examenminim2.model.ListaProductos2;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by annag on 18/12/2017.
 */

public interface Rest {

    @GET("listaProductos")
    Call<ListaProductos2> getListaProductos();

    @GET("usuario/{nomPlayer}/{password}")
    Call<Boolean> loginUser(@Path("nomPlayer") String nomPlayer, @Path("password") String password);
}
