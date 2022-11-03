package chess.pieces;

import boardgame.Board;
import chess.ChessMatch;
import chess.Color;
import chess.pieces.Rook;
import org.junit.Assert;
import org.junit.Test;

public class RookTest {
    @Test
    public void givenARookWhenCallToStringThenReturnR(){
        ChessMatch chessMatch = new ChessMatch();
        Rook rook = new Rook(chessMatch.getBoard(), Color.BLACK);

        Assert.assertEquals(rook.toString(), "R");
    }
}
