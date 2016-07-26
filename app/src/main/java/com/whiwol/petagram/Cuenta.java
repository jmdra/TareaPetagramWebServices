package com.whiwol.petagram;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Cuenta extends AppCompatActivity {
    private TextInputEditText tiedtUsuario;
    private Button btnGuardarCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.petagram);
        getSupportActionBar().setTitle(R.string.account_title);

        tiedtUsuario = (TextInputEditText) findViewById(R.id.tietCuenta);
        btnGuardarCuenta = (Button) findViewById(R.id.btnEnviar2);

        btnGuardarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarUsuarioInstagram();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.fav_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_contacto:
                //Crear el Intent para Actvity que enviara Email
                Toast.makeText(this, R.string.contacto_toolbar, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Cuenta.this, Contacto.class);
                startActivity(intent);
                break;
            case R.id.action_about:
                //Crear el Intent para Activity de Datos de Desarrollador
                Toast.makeText(this, R.string.about_toolbar, Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Cuenta.this, About.class);
                startActivity(intent2);
                break;
            case R.id.action_account:
                //Crear el Intent para Activity de Datos de Desarrollador
                Toast.makeText(this, R.string.account_toolbar, Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void guardarUsuarioInstagram(){
        String usuario = tiedtUsuario.getText().toString().trim();
        if (validarCampoInstagram(usuario)){
            SharedPreferences perfilInstagram = getSharedPreferences("shared", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = perfilInstagram.edit();
            editor.putString("perfilInstagram", usuario);
            editor.commit();

            Toast.makeText(this, R.string.account_saved, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, R.string.account_savedreturn, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validarCampoInstagram(String usuario){
        if(usuario.isEmpty() || usuario == null || usuario.length() == 0)
            return false;
        else
            return true;
    }
}
