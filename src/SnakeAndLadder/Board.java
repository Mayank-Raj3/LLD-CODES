package SnakeAndLadder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final int boad_size ;
    Map<Integer,Integer> snake;
    Map<Integer,Integer> ladder;
    public Board(int size , List<Snake> snakes , List<Ladder> ladder){
        this.boad_size = size;
        this.snake = new HashMap<>();
        this.ladder = new HashMap<>();
        for(Snake s : snakes){
            this.snake.put(s.getSnakeHead(), s.getSnakeTail());
        }
        for(Ladder l : ladder){
            this.ladder.put(l.getLadderTail(), l.getLadderHead());
        }
    }
    public int getBoardSize(){
        return this.boad_size;
    }
    public int getNextPosition(int currentPosition) {
        int newPosition = currentPosition;

        if (this.snake.containsKey(currentPosition)) {
            System.out.println("Oops! Bitten by snake 🐍");
            newPosition =  this.snake.get(currentPosition);
        } else if (this.ladder.containsKey(currentPosition)) {
            System.out.println("Yay! Climbed a ladder 🪜");
            newPosition = this.ladder.get(currentPosition);
        }

        return newPosition;
    }

}
