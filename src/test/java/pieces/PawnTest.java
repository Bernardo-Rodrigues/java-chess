package pieces;

import boardgame.Board;
import chess.Color;
import chess.pieces.King;
import org.junit.Assert;
import org.junit.Test;

public class PawnTest {
    @Test
    public void givenAPawnWhenCallToStringThenReturnP(){
        Board board = new Board(8,8);
        King king = new King(board, Color.BLACK);

        Assert.assertEquals(king.toString(), "P");
    }
}