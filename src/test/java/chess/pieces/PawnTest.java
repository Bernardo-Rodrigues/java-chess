package chess.pieces;

import boardgame.Board;
import chess.Color;
import org.junit.Assert;
import org.junit.Test;

public class PawnTest {
    @Test
    public void givenAPawnWhenCallToStringThenReturnP(){
        Board board = new Board(8,8);
        Pawn pawn = new Pawn(board, Color.BLACK);

        Assert.assertEquals(pawn.toString(), "P");
    }
}
