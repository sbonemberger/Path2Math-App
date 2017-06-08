package ubiquitouscomputing.pat2math_app.model;

import ubiquitouscomputing.pat2math_app.controller.Feedback;
import ubiquitouscomputing.pat2math_app.controller.Fraction;
import ubiquitouscomputing.pat2math_app.controller.HintBank;

public class Player {

    private String name;
    private int playerLevel;

    public Player (String name){
        this.name = name;
        this.playerLevel = 0;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPlayerLevel(int level){
        this.playerLevel = level;
    }

    public int getPlayerLevel(){
        return this.playerLevel;
    }
}