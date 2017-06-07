package ubiquitouscomputing.pat2math_app.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

import ubiquitouscomputing.pat2math_app.R;
import ubiquitouscomputing.pat2math_app.controller.Preferencias;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        Preferencias p = new Preferencias(this);
//        p.salvarDificuldade(3);


        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(Splash.this, PAT2MathApp.class));
                finish();
            }
        }, secondsDelayed * 3000);
    }
}

