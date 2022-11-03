package chess.pieces;

import boardgame.Board;
import chess.ChessMatch;
import chess.Color;
import org.junit.Assert;
import org.junit.Test;

public class BishopTest {
    @Test
    public void givenABishopWhenCallToStringThenReturnB(){
        ChessMatch chessMatch = new ChessMatch();
        Bishop bishop = new Bishop(chessMatch.getBoard(), Color.BLACK);

        Assert.assertEquals(bishop.toString(), "B");
    }
}
