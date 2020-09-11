package com.example.ecolab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class OtrosIP extends AppCompatActivity {

    private Button regresarButton2;
    private TextView hostsText;
    private boolean conectado;
    private String ip;
    private int counter;
    private InetAddress inetAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otros_i_p_s);
        regresarButton2=findViewById(R.id.regresarButton2);
        hostsText=findViewById(R.id.hostsText);
        counter=0;

        regresarButton2.setOnClickListener(
                (v)-> finish()
        );

        new Thread(
                ()-> {
                    barrido();



                }
        ).start();

    }


    public void barrido() {


        for (int i = 0; i < 255; i++) {
                counter += 1;
//                Log.e("auida",""+counter);
            ip= String.valueOf(counter);
            try {
                 inetAddress= InetAddress.getByName("192.168.0."+ip);
                Log.e("hellou",ip);
                conectado = inetAddress.isReachable(100);
                Log.e("contectado",""+conectado);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }   catch (IOException e) {
            e.printStackTrace();
        }
            if(conectado==true) {
                hostsText.setText("192.168.0." + ip);
            }
        }


        }
    }


