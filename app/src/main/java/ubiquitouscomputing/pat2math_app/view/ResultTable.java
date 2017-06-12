package ubiquitouscomputing.pat2math_app.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ubiquitouscomputing.pat2math_app.R;
import ubiquitouscomputing.pat2math_app.controller.AdapterResultado;
import ubiquitouscomputing.pat2math_app.model.Score;

public class ResultTable extends AppCompatActivity {

    private ListView listView;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    private Context context;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_result_table);


        listView = (ListView) findViewById(R.id.listResultado);
        AdapterResultado adapter = new AdapterResultado(this, R.layout.row_result);
        listView.setAdapter( adapter );

        this.context = this;
        this.preferences = PreferenceManager.getDefaultSharedPreferences(this);

        //context.getSharedPreferences("", Context.MODE_PRIVATE);

        this.editor = this.preferences.edit();
        this.gson = new Gson();

        String json = preferences.getString("ScoreBase", "");
        ArrayList<Score> scoreList = this.gson.fromJson(json, new TypeToken<List<Score>>(){}.getType());

        Collections.sort(scoreList);
        adapter.addAll( scoreList );

    }

    public void tryClick(View v){
        Intent i = new Intent(ResultTable.this, PlayerName.class);
        startActivity(i);
        finish();
    }
}

