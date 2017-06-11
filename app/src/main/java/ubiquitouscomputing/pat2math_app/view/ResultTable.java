package ubiquitouscomputing.pat2math_app.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

import ubiquitouscomputing.pat2math_app.R;
import ubiquitouscomputing.pat2math_app.controller.AdapterResultado;
import ubiquitouscomputing.pat2math_app.controller.GameManager;
import ubiquitouscomputing.pat2math_app.model.Score;

public class ResultTable extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_result_table);
        listView = (ListView) findViewById(R.id.listResultado);
        AdapterResultado adapter = new AdapterResultado(this, R.layout.row_result);
        listView.setAdapter( adapter );

        ArrayList<Score> scoreList = new ArrayList<Score>();
        GameManager gm = new GameManager(this);
        gm.endGame();
        scoreList = gm.getScoreBase();
        Collections.sort(scoreList);
        adapter.addAll( scoreList );
//        Preferencias p = new Preferencias(this);
//        p.salvarDificuldade(3);
    }

    public void tryClick(View v){
        Intent i = new Intent(ResultTable.this, PlayerName.class);
        startActivity(i);
        finish();
    }
}

