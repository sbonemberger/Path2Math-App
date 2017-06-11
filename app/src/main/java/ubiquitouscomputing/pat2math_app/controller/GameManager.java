package ubiquitouscomputing.pat2math_app.controller;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import ubiquitouscomputing.pat2math_app.model.Player;
import ubiquitouscomputing.pat2math_app.model.Score;

public class GameManager {
    private Score currentScore;
    private ArrayList<Score> scores;
    private Player currentPlayer;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    private Context context;
    private Gson gson;
    private int skipNumber, maxSkipNumber, correctAnswersInARow, correcAnswersForLevelUp;

    public GameManager(Context context){
        this.context = context;
        this.preferences = context.getSharedPreferences("", Context.MODE_PRIVATE);
        this.editor = this.preferences.edit();
        this.gson = new Gson();
        this.skipNumber = 0;
        this.maxSkipNumber = 3;
        this.correctAnswersInARow = 0;
        this.correcAnswersForLevelUp = 3;
    }

    public void newGame(String playerName){

        ArrayList<Player> playerBase = getPlayerBase();
        this.scores = getScoreBase();

        if (playerBase!= null && !playerBase.isEmpty()){
            for (int i = 0; i<playerBase.size(); i++){
                if (playerName.equals(playerBase.get(i).getName())){
                    currentPlayer = playerBase.get(i);
                    return;
                }
            }
        }

        currentPlayer = new Player(playerName);

        playerBase = new ArrayList<Player>();
        playerBase.add(currentPlayer);

        updatePlayerBase(playerBase);
    }

    public void updatePlayerBase(ArrayList<Player> playerBase){
        String json = this.gson.toJson(playerBase);
        editor.putString("PlayerBase", json);
        editor.commit();
    }

    public void updateScoreBase(){
        String json = this.gson.toJson(this.scores);
        editor.putString("ScoreBase", json);
        editor.commit();
    }

    public ArrayList<Player> getPlayerBase(){
        String json = preferences.getString("PlayerBase", "");
        ArrayList<Player> playerBase = this.gson.fromJson(json, new TypeToken<List<Player>>(){}.getType());

        return playerBase;
    }

    public ArrayList<Score> getScoreBase(){
        String json = preferences.getString("ScoreBase", "");
        ArrayList<Score> scoreBase = this.gson.fromJson(json, new TypeToken<List<Score>>(){}.getType());

        return scoreBase;
    }

    public void levelUp(){

        this.correctAnswersInARow = 0;
        this.currentPlayer.setPlayerLevel(this.currentPlayer.getPlayerLevel()+1);
    }

    public void levelDown(){
        if (this.currentPlayer.getPlayerLevel()>0){
            this.currentPlayer.setPlayerLevel(this.currentPlayer.getPlayerLevel()-1);
        }
    }

    public void endGame(){
        //updatePlayerBase();
        updateScoreBase();
    }

    public void updateSkipNumber(){

        this.skipNumber ++;

    }

    public int getSkipNumber(){
        return this.skipNumber;
    }

    public int getMaxSkipNumber(){
        return this.maxSkipNumber;
    }
}