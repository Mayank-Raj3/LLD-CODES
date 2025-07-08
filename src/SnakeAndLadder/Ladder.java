package SnakeAndLadder;

public class Ladder {
    private final int ladderHead ;
    private final int ladderTail ;
    Ladder(int ladderHead, int ladderTail) {
        this.ladderHead = ladderHead;
        this.ladderTail = ladderTail;
    }
    public int getLadderHead() {
        return ladderHead;
    }
    public int getLadderTail() {
        return ladderTail;
    }
}
