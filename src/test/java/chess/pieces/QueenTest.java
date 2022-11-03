package chess.pieces;

import boardgame.Board;
import chess.ChessMatch;
import chess.Color;
import org.junit.Assert;
import org.junit.Test;

public class QueenTest {
    @Test
    public void givenAQueenWhenCallToStringThenReturnQ(){
        ChessMatch chessMatch = new ChessMatch();
        Queen queen = new Queen(chessMatch.getBoard(), Color.BLACK);

        Assert.assertEquals(queen.toString(), "Q");
    }
}
