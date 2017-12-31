package com.team3990.techportail.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Démarrer l'activité principale
        startActivity(new Intent(this, MainActivity.class));

        // Fermer l'activité du Splash Screen
        finish();
    }
}
