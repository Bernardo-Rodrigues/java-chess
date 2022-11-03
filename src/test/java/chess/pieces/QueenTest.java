package chess.pieces;

import boardgame.Board;
import chess.Color;
import org.junit.Assert;
import org.junit.Test;

public class QueenTest {
    @Test
    public void givenAQueenWhenCallToStringThenReturnQ(){
        Board board = new Board(8,8);
        Queen queen = new Queen(board, Color.BLACK);

        Assert.assertEquals(queen.toString(), "Q");
    }
}
