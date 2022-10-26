package chess;

import org.junit.Assert;
import org.junit.Test;
import pieces.King;

public class ChessMatchTest {
    @Test
    public void givenAChessMatchWhenStartsThenPlaceThePiecesCorretly(){
        ChessMatch chessMatch = new ChessMatch();

        Assert.assertTrue(chessMatch.getPieces()[0][4] instanceof King);
        Assert.assertTrue(chessMatch.getPieces()[7][4] instanceof King);
    }
}
