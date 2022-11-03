package chess.pieces;

import boardgame.Board;
import chess.Color;
import org.junit.Assert;
import org.junit.Test;

public class KnightTest {
    @Test
    public void givenAKnightWhenCallToStringThenReturnN(){
        Board board = new Board(8,8);
        Knight knight = new Knight(board, Color.BLACK);

        Assert.assertEquals(knight.toString(), "N");
    }
}
