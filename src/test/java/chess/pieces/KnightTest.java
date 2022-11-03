package chess.pieces;

import boardgame.Board;
import chess.Color;
import org.junit.Assert;
import org.junit.Test;

public class KnightTest {
    @Test
    public void givenAKnightWhenCallToStringThenReturnN(){
        Board board = new Board(8,8);
        King king = new King(board, Color.BLACK);

        Assert.assertEquals(king.toString(), "N");
    }
}
