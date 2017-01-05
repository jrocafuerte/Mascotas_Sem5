package com.prueba.mascotas;

import android.net.Uri;
import android.os.StrictMode;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class FormularioCorreo extends AppCompatActivity {

    private Session session;
    String correo;
    String contrasena;
    TextInputLayout tiNombre;
    TextInputLayout tiCorreo;
    TextInputLayout tiMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_correo);

        tiNombre = (TextInputLayout) findViewById(R.id.tiNombre);
        tiCorreo = (TextInputLayout) findViewById(R.id.tiCorreo);
        tiMensaje = (TextInputLayout) findViewById(R.id.tiMensaje);
        Button btEnviar = (Button) findViewById(R.id.btEnviar);

        correo = "XXXXXXXXX@gmail.com";
        contrasena = "XXXXXXX";

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrictMode.ThreadPolicy policity = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policity);
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.googlemail.com"
                );
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");
                // props.setProperty("mail.user", "myuser");
                // props.setProperty("mail.password", "mypwd");

                try {
                    session = Session.getDefaultInstance(props, new Authenticator() {

                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, contrasena);
                        }
                    });

                    if(session != null){
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("Prueba Correo");
                        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(tiCorreo.getEditText().getText().toString()));
                        message.setContent(tiMensaje.getEditText().getText().toString()+"\n Saludos, "+tiNombre.getEditText().getText().toString(),"text/html; charset=utf-8");
                        Transport.send(message);
                    }

                } catch (Exception e) {
                    Toast.makeText(FormularioCorreo.this, "Error en Envio de Correo", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

                Toast.makeText(FormularioCorreo.this, "Correo Enviado de manera Exitosa", Toast.LENGTH_SHORT).show();

            }
        });


    }


}
