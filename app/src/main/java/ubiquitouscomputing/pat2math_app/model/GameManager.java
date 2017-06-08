package ubiquitouscomputing.pat2math_app.model;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import ubiquitouscomputing.pat2math_app.controller.Feedback;
import ubiquitouscomputing.pat2math_app.controller.Fraction;
import ubiquitouscomputing.pat2math_app.controller.HintBank;

public class GameManager {
    private Score currentScore;
    private ArrayList<Score> scores;
    private Player currentPlayer;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    private Context context;
    private Gson gson;

    public GameManager(Context context){
        this.context = context;
        this.preferences = context.getSharedPreferences("", Context.MODE_PRIVATE);
        this.editor = this.preferences.edit();
        this.gson = new Gson();
    }

    public void NewGame(Player player){

        ArrayList<Player> playerBase = getPlayerBase();
        this.scores = getScoreBase();

        if (!playerBase.isEmpty()){
            for (int i = 0; i<playerBase.size(); i++){
                if (player.getName() == playerBase.get(i).getName()){
                    currentPlayer = playerBase.get(i);
                    return;
                }
            }
        }

        // aqui temos que recuperar o nome informado no app
        currentPlayer = new Player("joaozinho");
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
        this.currentPlayer.setPlayerLevel(this.currentPlayer.getPlayerLevel()+1);
    }

    public void levelDown(){
        this.currentPlayer.setPlayerLevel(this.currentPlayer.getPlayerLevel()-1);
    }

    public void endGame(){
        //updatePlayerBase();
        updateScoreBase();
    }

}