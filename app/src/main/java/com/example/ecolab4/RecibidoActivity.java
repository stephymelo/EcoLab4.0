package com.example.ecolab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class RecibidoActivity extends AppCompatActivity {

    private Button regresarButton;
    private TextView textRecibe;
    private String ip;
    private boolean conectado;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibido);


        regresarButton=findViewById(R.id.regresarButton);
        textRecibe=findViewById(R.id.texto);

        String ipAdress=getIntent().getExtras().getString("ipAdress");

        ip=ipAdress;

        regresarButton.setOnClickListener(
                (v)-> finish()
                );


        new Thread(
                ()-> {
                    try {
                        InetAddress inetAddress = InetAddress.getByName(ip);
                        Log.e("hellou",ip);
                        conectado = inetAddress.isReachable(500);
                        Log.e("contectado",""+conectado);
                        texto();
                    } catch (
                            UnknownHostException e) {
                        e.printStackTrace();
                    } catch (
                            IOException e) {
                        e.printStackTrace();
                    }

                }
        ).start();
    }


   public void texto(){
        if(conectado==true){
            textRecibe.setText("Recibido");
        }else{
            textRecibe.setText("Perdido");
        }

}




}