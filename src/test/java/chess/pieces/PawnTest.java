package chess.pieces;

import boardgame.Board;
import chess.ChessMatch;
import chess.Color;
import org.junit.Assert;
import org.junit.Test;

public class PawnTest {
    @Test
    public void givenAPawnWhenCallToStringThenReturnP(){
        ChessMatch chessMatch = new ChessMatch();
        Pawn pawn = new Pawn(chessMatch.getBoard(), Color.BLACK, chessMatch);

        Assert.assertEquals(pawn.toString(), "P");
    }
}
