package edu.upc.eetac.dsa.examenminim2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.upc.eetac.dsa.examenminim2.R;
import edu.upc.eetac.dsa.examenminim2.model.Usuario;
import edu.upc.eetac.dsa.examenminim2.rest.Rest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, password;
    private Button login;
    private String usu, pass;
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String BASE_URL = "?????????";
    private static Retrofit retrofit = null;
    private boolean resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.button);
        usuario = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usuario.getText().toString().isEmpty() || password.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "S'han d'omplir els dos camps...", Toast.LENGTH_SHORT).show();
                else {
                    usu = usuario.getText().toString();
                    pass = password.getText().toString();
                    connectApiService();
                    //Intent in = new Intent(MainActivity.this, Main2Activity.class);
                    //startActivity(in);
                }
            }
        });

    }

    public void connectApiService() {
        if (this.retrofit == null) {
            this.retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        Rest service = retrofit.create(Rest.class);

        Call<Boolean> call = service.loginUser(usu,pass);
        call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    resposta = response.body().booleanValue();

                    if(resposta)
                        Toast.makeText(getApplicationContext(), "Usuari no trobat", Toast.LENGTH_LONG).show();
                    else{
                        Intent in = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(in);
                    }

                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }

        });

    }


}

