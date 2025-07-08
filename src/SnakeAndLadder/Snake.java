package SnakeAndLadder;

public class Snake {
    private final int snakeHead ;
    private final int snakeTail ;
    Snake(int snakeHead, int snakeTail) {
        this.snakeHead = snakeHead;
        this.snakeTail = snakeTail;
    }
    public int getSnakeHead() {
        return snakeHead;
    }
    public int getSnakeTail() {
        return snakeTail;
    }

}
