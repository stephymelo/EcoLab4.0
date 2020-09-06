package com.example.ecolab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener   {
    private Button buscarButton;
    private Button pingButton;
    private EditText first;
    private EditText second;
    private EditText third;
    private EditText fourth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first=findViewById(R.id.first);
        second=findViewById(R.id.second);
        third=findViewById(R.id.third);
        fourth=findViewById(R.id.fourth);
        buscarButton=findViewById(R.id.buscarButton);
        pingButton=findViewById(R.id.pingButton);

       pingButton.setOnClickListener(this);
       buscarButton.setOnClickListener(this);




    }






    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pingButton:
                String ipAdress=first.getText().toString()+"."+second.getText().toString()+"."+third.getText().toString()+"."+fourth.getText().toString();
                Intent i=new Intent(this,RecibidoActivity.class);
                i.putExtra("ipAdress",ipAdress);
                startActivity(i);



                break;
            case R.id.buscarButton:

                Intent b=new Intent(this,OtrosIP.class);
                startActivity(b);


                break;
        }


    }
}