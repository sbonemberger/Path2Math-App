package ubiquitouscomputing.pat2math_app.model;


public class Score {

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
}