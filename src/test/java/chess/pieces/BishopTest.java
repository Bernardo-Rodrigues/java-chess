package chess.pieces;

import boardgame.Board;
import chess.Color;
import chess.pieces.King;
import org.junit.Assert;
import org.junit.Test;

public class BishopTest {
    @Test
    public void givenABishopWhenCallToStringThenReturnB(){
        Board board = new Board(8,8);
        King king = new King(board, Color.BLACK);

        Assert.assertEquals(king.toString(), "B");
    }
}
