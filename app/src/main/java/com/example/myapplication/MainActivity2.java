package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SharedPreferences settings = getSharedPreferences("cycle_de_vie,", Context.MODE_PRIVATE);
        setTxtValeur(settings.getString("cle", ""));
    }

    protected void onRestart() {
        super.onRestart();
        popUp("onRestart()");
    }

    protected void onStart(){
        super.onStart();
        popUp("onStart()");
    }

    protected void onResume(){
        super.onResume();
        popUp("onResume()");
    }

    protected void onPause(){
        super.onPause();
        popUp("onPause()");
    }

    protected void onStop(){
        super.onStop();
        popUp("onStop()");
    }

    protected void onDestroy(){
        super.onDestroy();
        popUp("onDestroy()");
    }

    public void popUp(String message){
        Toast.makeText(this, message + "2", Toast.LENGTH_LONG).show();
    }

    public void setTxtValeur(String valeur){
        popUp(valeur);
    }
}