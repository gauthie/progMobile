package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnQuitter = (Button) findViewById(R.id.btnQuitter);
        btnQuitter.setOnClickListener(btnQuitterOnClickListener);
        Button btnEnvoyer = (Button) findViewById(R.id.btnEnvoyer);
        btnEnvoyer.setOnClickListener(btnEnvoyerOnClickListener);
        Button btnActivite= (Button) findViewById(R.id.btnAct2);
        btnActivite.setOnClickListener(btnActiviteOnClickListener);
        popUp("onCreate()");
    }

    protected void onRestart() {
        super.onRestart();
        popUp("onRestart()");
    }

    protected void onStart(){
        super.onStart();
        SharedPreferences settings = getSharedPreferences("cycle_de_vie,", Context.MODE_PRIVATE);
        setTxtValeur(settings.getString("cle", ""));
        popUp("onStart()");
    }

    protected void onResume(){
        super.onResume();
        SharedPreferences settings = getSharedPreferences("cycle_de_vie,", Context.MODE_PRIVATE);
        setTxtValeur(settings.getString("cle", ""));
        popUp("onResume()");
    }

    protected void onPause(){
        super.onPause();
        SharedPreferences settings = getSharedPreferences("cycle_vie_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("cle", getTxtValeur());
        editor.commit();
        if(isFinishing()){
            popUp("onPause, l'utilisateur a demandé la fermeture via finish()");
        }
        else{
            popUp("onPause, l'utilisateur n'a pas demandé la fermeture via un finish()");
        }
    }

    protected void onStop(){
        super.onStop();
        popUp("onStop()");
    }

    protected void onDestroy(){
        super.onDestroy();
        popUp("onDestroy()");
    }

    View.OnClickListener btnQuitterOnClickListener = new View.OnClickListener(){
        public void onClick(View v){
            finish();
        }
    };

    View.OnClickListener btnEnvoyerOnClickListener = new View.OnClickListener(){
        public void onClick(View v){
            popUp("valeur saisie = "+getTxtValeur());
        }
    };

    View.OnClickListener btnActiviteOnClickListener = new View.OnClickListener(){
        public void onClick(View v){
            Intent intent = new Intent(v.getContext(), MainActivity2.class);
            startActivity(intent);
        }
    };
    public void popUp(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
    public String getTxtValeur() {
        EditText zoneValeur = (EditText) findViewById(R.id.editTxtValeur);
        return zoneValeur.getText().toString();
    }

    public void setTxtValeur(String valeur){
        EditText zoneValeur = (EditText) findViewById(R.id.editTxtValeur);
        zoneValeur.setText(valeur);
    }


}