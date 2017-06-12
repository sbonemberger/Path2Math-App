package ubiquitouscomputing.pat2math_app.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import ubiquitouscomputing.pat2math_app.R;

/**
 * A login screen that offers login via email/password.
 */
public class PlayerName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);

        addListenerOnStartButton();

    }

    public void addListenerOnStartButton() {

        Button b = (Button) findViewById(R.id.btLogin);

        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                EditText e = (EditText) findViewById(R.id.etPlayerName);

                if (e.getText().toString().equals("")){
                    return;
                }

                Intent i =  new Intent(PlayerName.this, Questionnaire.class);
                i.putExtra("PlayerName", e.getText().toString());
                startActivity(i);
                finish();

            }

        });

    }

}

