package ubiquitouscomputing.pat2math_app.model;


import android.support.annotation.NonNull;

public class Score implements Comparable {

    private int points;
    private String player;

    public Score(String player, int points){
        this.player = player;
        this.points = points;
    }

    public void setPlayer(String player){
        this.player = player;
    }

    public String getPlayer(){
        return this.player;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public int getPoints(){
        return this.points;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        int comparePoint = ((Score)o).getPoints();
        return comparePoint-this.points;
    }
}