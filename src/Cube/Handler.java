package Cube;

public class Handler {
    private Game game;

    Handler(Game game){
        this.game = game;
    }

    public int getWidth(){
        return game.getWidth();
    }
    public int getHeight(){
        return game.getHeight();
    }
    public Game getGame(){
        return this.game;
    }

}
