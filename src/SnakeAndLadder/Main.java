package SnakeAndLadder;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dice d = new Dice(1,6);
        // Start game 1
        List<Snake> snakes = List.of(
                new Snake(17, 7), new Snake(54, 34),
                new Snake(62, 19), new Snake(98, 79)
        );

        List<Ladder> ladders = List.of(
                new Ladder(3, 38), new Ladder(24, 33),
                new Ladder(42, 93), new Ladder(72, 84)
        );

        Board board = new Board(100, snakes, ladders);
        List<Player> players = Arrays.asList(new Player("Mayank "),new Player("Aman 1"));

        Game g = new Game(board,players,d);
        g.play();
    }
}
