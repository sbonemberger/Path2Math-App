package ubiquitouscomputing.pat2math_app.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import ubiquitouscomputing.pat2math_app.model.Player;
import ubiquitouscomputing.pat2math_app.model.Score;

public class GameManager {
    private Score currentScore;
    private ArrayList<Score> scores;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    private Context context;
    private Gson gson;
    private int skipNumber, maxSkipNumber, correctAnswersInARow, correcAnswersForLevelUp, correctAnswerPoints, skipLoosingPoints, levelUpMiliSeconds;

    public GameManager(Context context){
        this.context = context;
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
//                context.getSharedPreferences("", Context.MODE_PRIVATE);

  //      SharedPreferences prefs =

        this.editor = this.preferences.edit();
        this.gson = new Gson();
        this.skipNumber = 0;
        this.maxSkipNumber = 3;
        this.correctAnswersInARow = 0;
        this.correcAnswersForLevelUp = 3;
        this.correctAnswerPoints = 10;
        this.skipLoosingPoints = -10;
        this.levelUpMiliSeconds = 30000;
    }

    public void newGame(String playerName){

        players = getPlayerBase();
        scores = getScoreBase();

        if (scores == null){
            scores = new ArrayList<Score>();
        }

        currentScore = new Score(playerName,0);
        scores.add(currentScore);

        if (players!= null && !players.isEmpty()){
            for (int i = 0; i<players.size(); i++){
                if (playerName.equals(players.get(i).getName())){
                    currentPlayer = players.get(i);
                    return;
                }
            }
        }

        currentPlayer = new Player(playerName);

        players = new ArrayList<Player>();
        players.add(currentPlayer);

        updatePlayerBase();
    }

    public void updateScore(int points){

        this.currentScore.setPoints(this.currentScore.getPoints() + points);

        if (this.currentScore.getPoints() < 0){
            this.currentScore.setPoints(0);
        }

    }

    public void updateCorrectAnswerSeries (int i){

        if (i < 0){
            this.correctAnswersInARow = 0;
            return;
        }

        this.correctAnswersInARow++;
    }

    public void updatePlayerBase(){
        String json = this.gson.toJson(players);
        editor.putString("PlayerBase", json);
        editor.commit();
    }

    public void updateScoreBase(){
        String json = this.gson.toJson(scores);
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
        updatePlayerBase();
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

    public int getCorrectAnswerPoints() {return this.correctAnswerPoints;}

    public int getCorrectAnswersInARow() {return this.correctAnswersInARow;}

    public int getCorrecAnswersForLevelUp() {return this.correcAnswersForLevelUp;}

    public Player getCurrentPlayer() {return this.currentPlayer;}

    public int getSkipLoosingPoints() {return this.skipLoosingPoints;}

    public int getLevelUpMiliSeconds() {return this.levelUpMiliSeconds;}
}