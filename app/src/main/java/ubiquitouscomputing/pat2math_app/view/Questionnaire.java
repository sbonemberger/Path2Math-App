package ubiquitouscomputing.pat2math_app.view;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ubiquitouscomputing.pat2math_app.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Questionnaire extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        addListenerOnRespondButton();

    }

    public void addListenerOnRespondButton() {

        Button b = (Button) findViewById(R.id.dummy_button);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(Questionnaire.this);
                builder1.setMessage("Teste");
                builder1.setCancelable(true);

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }

        });

    }
}
