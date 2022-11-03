package chess.pieces;

import boardgame.Board;
import chess.Color;
import org.junit.Assert;
import org.junit.Test;

public class BishopTest {
    @Test
    public void givenABishopWhenCallToStringThenReturnB(){
        Board board = new Board(8,8);
        Bishop bishop = new Bishop(board, Color.BLACK);

        Assert.assertEquals(bishop.toString(), "B");
    }
}
