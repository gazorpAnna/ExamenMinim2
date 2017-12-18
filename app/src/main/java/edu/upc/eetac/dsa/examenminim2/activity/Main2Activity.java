package edu.upc.eetac.dsa.examenminim2.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.upc.eetac.dsa.examenminim2.R;
import edu.upc.eetac.dsa.examenminim2.adapter.ProductAdapter;
import edu.upc.eetac.dsa.examenminim2.model.ListaProductos2;
import edu.upc.eetac.dsa.examenminim2.model.Producto;
import edu.upc.eetac.dsa.examenminim2.rest.Rest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {

    private TextView tx;
    private RecyclerView recyclerView = null;
    private static final String TAG = Main2Activity.class.getSimpleName();
    public static final String BASE_URL = "http://localhost:8088/examen/json/";
    private static Retrofit retrofit = null;

    List<Producto> productos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tx = (TextView) findViewById(R.id.textView);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if(!connectAndGetApiData()){
            tx.setText("Aqui hi haurien d'apareixer els productes...");
        }

    }

    public Boolean connectAndGetApiData() {
        Boolean funciona = false;
        final ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("Carregant...");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.show();


        try {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            progress.dismiss();
            return funciona;
        }

        Rest rest = retrofit.create(Rest.class);

        Call<ListaProductos2> call = rest.getListaProductos();
        call.enqueue(new Callback<ListaProductos2>() {
            @Override
            public void onResponse(Call<ListaProductos2> call, Response<ListaProductos2> response) {
                try {
                    productos = response.body().getListaProductos();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    Log.d(TAG,e.getMessage());
                }

                if(!productos.isEmpty()) {
                    progress.dismiss();
                    recyclerView.setAdapter(new ProductAdapter(productos, R.layout.list_item, getApplicationContext()));
                    Log.d(TAG, "Número de productes: " + productos.size());

                } else {
                    Toast.makeText(getApplicationContext(),"No s'ha pogut trobar res",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListaProductos2> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
        progress.dismiss();
        return funciona;
    }
}
