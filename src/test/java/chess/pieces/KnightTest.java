package chess.pieces;

import boardgame.Board;
import chess.ChessMatch;
import chess.Color;
import org.junit.Assert;
import org.junit.Test;

public class KnightTest {
    @Test
    public void givenAKnightWhenCallToStringThenReturnN(){
        ChessMatch chessMatch = new ChessMatch();
        Knight knight = new Knight(chessMatch.getBoard(), Color.BLACK);

        Assert.assertEquals(knight.toString(), "N");
    }
}
