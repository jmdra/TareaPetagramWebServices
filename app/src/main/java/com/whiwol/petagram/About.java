package com.whiwol.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar3);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.petagram);
        getSupportActionBar().setTitle(R.string.about_title);
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
                Intent intent2 = new Intent(About.this, Contacto.class);
                startActivity(intent2);
                Toast.makeText(this, R.string.contacto_toolbar, Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about:
                //Crear el Intent para Activity de Datos de Desarrollador
                Toast.makeText(this, R.string.about_toolbar, Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_account:
                //Crear el Intent para Activity de Datos de Desarrollador
                Toast.makeText(this, R.string.account_toolbar, Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(About.this, Cuenta.class);
                startActivity(intent4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
