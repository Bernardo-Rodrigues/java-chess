package pieces;

import boardgame.Board;
import chess.Color;
import org.junit.Assert;
import org.junit.Test;

public class KingTest {
    @Test
    public void givenAKingWhenCallToStringThenReturnK(){
        Board board = new Board(8,8);
        King king = new King(board, Color.BLACK);

        Assert.assertEquals(king.toString(), "K");
    }
}
