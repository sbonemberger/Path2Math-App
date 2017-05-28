package ubiquitouscomputing.pat2math_app.view;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

        // Creating a new RelativeLayout
        RelativeLayout relativeLayout = new RelativeLayout(this);

        // Defining the RelativeLayout layout parameters with Fill_Parent
        RelativeLayout.LayoutParams relativeLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,
                                                                                           RelativeLayout.LayoutParams.FILL_PARENT);


        RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        titleParams.addRule(RelativeLayout.ALIGN_TOP);
        titleParams.addRule(RelativeLayout.TEXT_ALIGNMENT_CENTER);
        TextView txTitle = new TextView(this);
        txTitle.setText("PATToMath Challenge");
        txTitle.setLayoutParams(titleParams);
        txTitle.setTextSize(22);
        txTitle.setId(1);


       // RelativeLayout.LayoutParams leftSeparatorParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

       // leftSeparatorParams.addRule(RelativeLayout.ALIGN_LEFT);
       // leftSeparatorParams.addRule(RelativeLayout.TEXT_ALIGNMENT_CENTER);
       // View vLeftSeparator = new View(this);
       // vLeftSeparator.setBackgroundColor(0);
       // vLeftSeparator.

        RelativeLayout.LayoutParams formulaDividendParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        formulaDividendParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        formulaDividendParams.addRule(RelativeLayout.TEXT_ALIGNMENT_CENTER);
        formulaDividendParams.addRule(RelativeLayout.BELOW,txTitle.getId());

        TextView txDividend = new TextView(this);
        txDividend.setText("124");
        txDividend.setLayoutParams(formulaDividendParams);
        txDividend.setTextSize(18);
        txDividend.setId(2);

        RelativeLayout.LayoutParams formulaDivisorParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        formulaDivisorParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        formulaDivisorParams.addRule(RelativeLayout.TEXT_ALIGNMENT_CENTER);
        formulaDivisorParams.addRule(RelativeLayout.BELOW,txDividend.getId());

        TextView txDivisor = new TextView(this);
        txDivisor.setText("62");
        txDivisor.setLayoutParams(formulaDivisorParams);
        txDivisor.setTextSize(18);
        txDivisor.setId(3);

        RelativeLayout.LayoutParams formulaDividendAnswerParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        formulaDividendAnswerParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        formulaDividendAnswerParams.addRule(RelativeLayout.TEXT_ALIGNMENT_CENTER);
        formulaDividendAnswerParams.addRule(RelativeLayout.BELOW,txTitle.getId());

        EditText etDividend = new EditText(this);
        etDividend.setText("");
        etDividend.setLayoutParams(formulaDividendAnswerParams);
        etDividend.setTextSize(18);
        etDividend.setId(4);

        RelativeLayout.LayoutParams formulaDivisorAnswerParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        formulaDivisorAnswerParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        formulaDivisorAnswerParams.addRule(RelativeLayout.TEXT_ALIGNMENT_CENTER);
        formulaDivisorAnswerParams.addRule(RelativeLayout.BELOW,etDividend.getId());

        EditText etDivisor = new EditText(this);
        etDivisor.setText("");
        etDivisor.setLayoutParams(formulaDivisorAnswerParams);
        etDivisor.setTextSize(18);
        etDividend.setId(5);

        RelativeLayout.LayoutParams okButtonParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        okButtonParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        okButtonParams.addRule(RelativeLayout.TEXT_ALIGNMENT_CENTER);

        Button btOK = new Button(this);
        btOK.setText("OK");
        btOK.setLayoutParams(okButtonParams);

        RelativeLayout.LayoutParams skipButtonParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        skipButtonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        skipButtonParams.addRule(RelativeLayout.TEXT_ALIGNMENT_CENTER);

        Button btSkip = new Button(this);
        btSkip.setText("SKIP");
        btSkip.setLayoutParams(skipButtonParams);

        // Add the Buttons to the View
        relativeLayout.addView(txTitle);
        relativeLayout.addView(txDividend);
        relativeLayout.addView(txDivisor);
        relativeLayout.addView(etDividend);
        relativeLayout.addView(etDivisor);
        relativeLayout.addView(btOK);
        relativeLayout.addView(btSkip);

        // Setting the RelativeLayout as our content view
        setContentView(relativeLayout, relativeLayoutParams);


    }

}
