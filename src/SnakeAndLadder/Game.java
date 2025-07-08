package SnakeAndLadder;

import java.util.List;

public class Game {
    private final Dice d ;
    private final Board board ;
    private final List<Player> players ;
    int currInd ;
    Game(Board board, List<Player> players, Dice d) {
        this.board = board ;
        this.players = players ;
        this.d = d ;
        this.currInd = 0 ;
    }

    void play() {
        while(!isGameOver()) {
            Player currentPlayer = this.players.get(currInd) ;
            int currPosition = currentPlayer.getPosition();
            int diceRoll = d.roll();

            if(currPosition+diceRoll <= this.board.getBoardSize()){
                int newPosition = board.getNextPosition(currPosition + diceRoll); //check for snake and ladder
                System.out.println(currentPlayer.getName() + " rolled a " + diceRoll +
                        " and moved to position " + newPosition);
                currentPlayer.setPosition(newPosition);
            }
            if (currentPlayer.getPosition() == board.getBoardSize()) {
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }
            currInd++;
            currInd = currInd%players.size();
        }
    }
    boolean isGameOver(){
        return this.board.getBoardSize() == players.get(currInd).getPosition() ;
    }
}
