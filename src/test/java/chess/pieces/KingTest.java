package chess.pieces;

import boardgame.Board;
import chess.ChessMatch;
import chess.Color;
import chess.pieces.King;
import org.junit.Assert;
import org.junit.Test;

public class KingTest {
    @Test
    public void givenAKingWhenCallToStringThenReturnK(){
        ChessMatch chessMatch = new ChessMatch();
        King king = new King(chessMatch.getBoard(), Color.BLACK);

        Assert.assertEquals(king.toString(), "K");
    }
}
