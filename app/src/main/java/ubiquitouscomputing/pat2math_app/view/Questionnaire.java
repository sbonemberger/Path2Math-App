package ubiquitouscomputing.pat2math_app.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;

import ubiquitouscomputing.pat2math_app.R;
import ubiquitouscomputing.pat2math_app.controller.GameManager;
import ubiquitouscomputing.pat2math_app.controller.Generator;
import ubiquitouscomputing.pat2math_app.controller.HintBank;
import ubiquitouscomputing.pat2math_app.model.Exercise;
import ubiquitouscomputing.pat2math_app.controller.Feedback;
import ubiquitouscomputing.pat2math_app.controller.GameManager;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Questionnaire extends AppCompatActivity {

    TextView txNumerator, txDenominator, txNumerator2, txDenominator2, txTimer;
    EditText etNumerator, etDenominator, etNumerator2, etDenominator2;
    Button btOK, btOK2, btSkip;
    ImageView imgCorrect, imgIncorrect;
    String currentPlayerName;
    GameManager gm;
    long startTime;
    int timeLeft = 50000;

    Handler timerHandler = new Handler();

    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            long millis = startTime - System.currentTimeMillis();
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            txTimer.setText(String.format("%d:%02d", minutes, seconds));

            timerHandler.postDelayed(this, 500);

            if (seconds <= 0 && minutes <= 0){
                timeOut();
            }
        }
    };

    Generator gen;
    Exercise ex;
    Feedback fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        init();
        addListenerOnStep1Button();
        addListenerOnStep2Button();
        addListenerOnSkipButton();
        loadNewExercise();

    }

    public void init(){

        txNumerator = (TextView) findViewById(R.id.txNumerator);
        txDenominator = (TextView) findViewById(R.id.txDenominator);
        etNumerator = (EditText) findViewById(R.id.etNumerator);
        etDenominator = (EditText) findViewById(R.id.etDenominator);
        btOK = (Button) findViewById(R.id.btOK);
        imgCorrect = (ImageView) findViewById(R.id.imgCorrect);
        imgIncorrect = (ImageView) findViewById(R.id.imgIncorrect);

        txNumerator2 = (TextView) findViewById(R.id.txNumeratorStep2);
        txDenominator2 = (TextView) findViewById(R.id.txDenominatorStep2);
        etNumerator2 = (EditText) findViewById(R.id.etNumeratorStep2);
        etDenominator2 = (EditText) findViewById(R.id.etDenominatorStep2);
        btOK2 = (Button) findViewById(R.id.btOK2);

        btSkip = (Button) findViewById(R.id.btSkip);

        currentPlayerName = getIntent().getStringExtra("PlayerName");

        gen = new Generator ();
        gen.generateLists();

        txTimer = (TextView) findViewById(R.id.txTimer);
        txTimer.setText(Integer.toString(timeLeft/1000));

        startTime = timeLeft + System.currentTimeMillis();

        timerHandler.postDelayed(timerRunnable, 0);

        gm = new GameManager(this);
        gm.newGame(currentPlayerName);
    }

    public void timeOut(){

        timerHandler.removeCallbacks(timerRunnable);
        endGame();
    }

    public void endGame() {

        gm.endGame();

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(Questionnaire.this, ResultTable.class));
                finish();
            }
        }, secondsDelayed * 500);
    }

    public void loadNewExercise(){

        ex = gen.generateExercise(gm.getCurrentPlayer().getPlayerLevel());
        HintBank.createHintBank();

        hideStep2();

        btOK.setVisibility(View.VISIBLE);
        imgCorrect.setVisibility(View.INVISIBLE);
        imgIncorrect.setVisibility(View.INVISIBLE);

        txNumerator.setText(Integer.toString(ex.getInitialFraction().getNumerator()));
        txDenominator.setText(Integer.toString(ex.getInitialFraction().getDenominator()));
        etNumerator.setText("");
        etDenominator.setText("");
        etNumerator.setVisibility(View.VISIBLE);
        etDenominator.setVisibility(View.VISIBLE);
        etNumerator.setEnabled(true);
        etDenominator.setEnabled(true);
    }

    public void hideStep2() {

        imgCorrect.setVisibility(View.INVISIBLE);
        imgIncorrect.setVisibility(View.INVISIBLE);

        txNumerator2.setVisibility(View.INVISIBLE);
        txDenominator2.setVisibility(View.INVISIBLE);
        etNumerator2.setVisibility(View.INVISIBLE);
        etDenominator2.setVisibility(View.INVISIBLE);
        btOK2.setVisibility(View.INVISIBLE);

    }

    public void updateImage (boolean correctAnswer){
        if (correctAnswer){
            imgCorrect.setVisibility(View.VISIBLE);
            imgIncorrect.setVisibility(View.INVISIBLE);
        }
        else{
            imgIncorrect.setVisibility(View.VISIBLE);
            imgCorrect.setVisibility(View.INVISIBLE);
        }

    }

    public void showStep2() {

        btOK.setVisibility(View.INVISIBLE);

        etNumerator.setEnabled(false);
        etDenominator.setEnabled(false);

        txNumerator2.setVisibility(View.VISIBLE);
        txDenominator2.setVisibility(View.VISIBLE);
        etNumerator2.setVisibility(View.VISIBLE);
        etDenominator2.setVisibility(View.VISIBLE);
        btOK2.setVisibility(View.VISIBLE);

    }

    public void updateStep1() {

        txNumerator.setText(txNumerator2.getText());
        txDenominator.setText(txDenominator2.getText());
        etNumerator.setText(etNumerator2.getText());
        etDenominator.setText(etDenominator2.getText());
    }

    public void updateStep2(boolean correctAnswer) {

        if (correctAnswer){
            txNumerator2.setText(etNumerator.getText());
            txDenominator2.setText(etDenominator.getText());
        }
        else{
            txNumerator2.setText(txNumerator.getText());
            txDenominator2.setText(txDenominator.getText());
        }
        etNumerator2.setText("");
        etDenominator2.setText("");

    }

    public void answer(double numerator, double denominator ){

         fb = ex.answer(numerator,denominator);

    }

    public void addPointsToScore(){

        int calculatedPoints = gm.getCorrectAnswerPoints() * (gm.getCurrentPlayer().getPlayerLevel()+1);

        gm.updateScore(calculatedPoints);

    }

    public boolean checkFieldsStep1 (){

        if (!etNumerator.getText().toString().equals("") && !etDenominator.getText().toString().equals("")){
            return true;
        }

        return false;
    }

    public boolean checkFieldsStep2 (){

        if (!etNumerator2.getText().toString().equals("") && !etDenominator2.getText().toString().equals("")){
            return true;
        }

        return false;
    }

    public void addListenerOnStep1Button() {

        findViewById(R.id.btOK).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (checkFieldsStep1()){
                    answer(Double.parseDouble(etNumerator.getText().toString()),Double.parseDouble(etDenominator.getText().toString()));


                    if (fb.isFinalAnswer() && fb.isCorrectAnswer()){
                        addPointsToScore();
                        gm.updateCorrectAnswerSeries(1);

                        if (gm.getCorrectAnswersInARow() == gm.getCorrecAnswersForLevelUp()){
                            gm.levelUp();
                            startTime  = startTime + gm.getLevelUpMiliSeconds();
                        }

                        loadNewExercise();
                    }
                    else{
                        if (!fb.isCorrectAnswer()){
                            gm.updateCorrectAnswerSeries(-1);
                        }

                        updateImage(fb.isCorrectAnswer());
                        showStep2();
                        updateStep2(fb.isCorrectAnswer());

                    }
                }

            }

        });

    }

    public void addListenerOnStep2Button() {

        Button b = (Button) findViewById(R.id.btOK2);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (checkFieldsStep2()){
                    answer(Double.parseDouble(etNumerator2.getText().toString()),Double.parseDouble(etDenominator2.getText().toString()));

                    if (fb.isFinalAnswer() && fb.isCorrectAnswer()){
                        addPointsToScore();
                        gm.updateCorrectAnswerSeries(1);

                        if (gm.getCorrectAnswersInARow() == gm.getCorrecAnswersForLevelUp()){
                            gm.levelUp();
                        }

                        loadNewExercise();
                    }
                    else{
                        if (!fb.isCorrectAnswer()){
                            gm.updateCorrectAnswerSeries(-1);
                        }

                        updateImage(fb.isCorrectAnswer());
                        updateStep1();
                        updateStep2(fb.isCorrectAnswer());
                    }

                }

            }

        });

    }

    public void addListenerOnSkipButton() {

        //Button b = (Button) findViewById(R.id.btSkip);

        btSkip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (gm.getSkipNumber() < gm.getMaxSkipNumber()){
                    gm.updateSkipNumber();
                    gm.updateScore(gm.getSkipLoosingPoints());
                    gm.levelDown();
                    loadNewExercise();
                }

                if (gm.getSkipNumber() >= gm.getMaxSkipNumber()){
                    btSkip.setEnabled(false);
                }

            }

        });

    }

}
