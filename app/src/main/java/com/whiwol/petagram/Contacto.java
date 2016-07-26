package com.whiwol.petagram;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity{

    Session session = null;
    ProgressDialog dprogreso = null;
    Context context = null;
    EditText receptor, asunto, msg;
    String rec, subject, mensajetexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.petagram);
        getSupportActionBar().setTitle(R.string.correo_title);
    }

    //Enviando Correo
    public void mandarCorreo(View view){

        context = this;

        receptor        = (EditText) findViewById(R.id.tietPara);
        asunto          = (EditText) findViewById(R.id.tietAsunto);
        msg             = (EditText) findViewById(R.id.tietMensaje);

        rec = receptor.getText().toString();
        subject = asunto.getText().toString();
        mensajetexto = msg.getText().toString();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("testwhiwol@gmail.com", "testwhiwol2016");
            }
        });

        dprogreso = ProgressDialog.show(context, "", "Mandando Correo...", true);

        RetrieveFeedTask task = new RetrieveFeedTask();
        task.execute();
    }

    class RetrieveFeedTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {
            try{
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(rec));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress("testwhiwol@gmail.com"));
                message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(rec));
                message.setSubject("Comentario de Petagram Whiwol");
                message.setContent(mensajetexto + " Enviado por: " + subject + " con Correo: " +rec, "text/html; charset=utf-8");

                Transport.send(message);

            }catch (MessagingException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String aVoid) {
            dprogreso.dismiss();
            receptor.setText("");
            asunto.setText("");
            msg.setText("");
            Toast.makeText(getApplicationContext(), "Mensaje Enviado", Toast.LENGTH_SHORT).show();
        }
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
                break;
            case R.id.action_about:
                //Crear el Intent para Activity de Datos de Desarrollador
                Toast.makeText(this, R.string.about_toolbar, Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(Contacto.this, About.class);
                startActivity(intent3);
                break;
            case R.id.action_account:
                //Crear el Intent para Activity de Datos de Desarrollador
                Toast.makeText(this, R.string.account_toolbar, Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(Contacto.this, Cuenta.class);
                startActivity(intent4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
