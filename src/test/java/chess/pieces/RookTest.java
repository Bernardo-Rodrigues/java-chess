package chess.pieces;

import boardgame.Board;
import chess.Color;
import chess.pieces.Rook;
import org.junit.Assert;
import org.junit.Test;

public class RookTest {
    @Test
    public void givenARookWhenCallToStringThenReturnR(){
        Board board = new Board(8,8);
        Rook rook = new Rook(board, Color.BLACK);

        Assert.assertEquals(rook.toString(), "R");
    }
}
