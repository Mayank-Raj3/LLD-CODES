package SnakeAndLadder;

public class Player {
    private final String Name ;
    private int position ;
    Player(String name){
        this.Name = name ;
        this.position = 0 ;
    }
    public String getName(){
        return Name ;
    }
    public int getPosition(){
        return position ;
    }
    public void setPosition(int position){
        this.position = position ;
    }
}
