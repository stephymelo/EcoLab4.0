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

        textRecibe.setText(" ");
        
        new Thread(
                ()-> {
                    try {
                        for(int i=0;i<7;i++) {

                            InetAddress inetAddress = InetAddress.getByName(ip);
                            conectado = inetAddress.isReachable(500);
                            Log.e("contectado", "" + conectado);
                            texto();
                            Thread.sleep(2000);
                            i++;
                        }

                    } catch (
                            UnknownHostException e) {
                        e.printStackTrace();
                    } catch (
                            IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException l) {
                      l.printStackTrace();
                    }



                }
        ).start();

    }


   public void texto(){
        if(conectado==true){
            runOnUiThread(
                    ()-> {
                        textRecibe.append("\nConectado\n"+ip+textRecibe.getText().toString());
                    }
            );
        }else{
            runOnUiThread(
                    ()-> {
                        textRecibe.append("\nPerdido\n"+ip+textRecibe.getText().toString());
                    }
            );
        }

}




}