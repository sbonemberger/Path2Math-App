package ubiquitouscomputing.pat2math_app.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import ubiquitouscomputing.pat2math_app.R;


public class PAT2MathApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path2_math_app);

        addListenerOnStartButton();

    }

    public void addListenerOnStartButton() {

        Button b = (Button) findViewById(R.id.button);

        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i =  new Intent(PAT2MathApp.this, Questionnaire.class);
                startActivity(i);
                finish();

            }

        });

    }
}
