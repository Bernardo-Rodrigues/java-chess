package chess;

import boardgame.Position;
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

    @Test
    public void givenAChessPieceWhenPerformAMoveThenPlaceThePieceCorretly(){
        ChessMatch chessMatch = new ChessMatch();
        ChessPosition sourcePosition = new ChessPosition('e', 8);
        ChessPosition targetPosition = new ChessPosition('e', 5);

        chessMatch.performChessMove(sourcePosition, targetPosition);

        Assert.assertTrue(chessMatch.getBoard().thereIsAPiece(targetPosition.toPosition()));
    }

    @Test
    public void givenAChessMovePieceWhenTargetPositionHasAPieceThenReturnThisPiece(){
        ChessMatch chessMatch = new ChessMatch();
        ChessPosition sourcePosition = new ChessPosition('e', 8);
        ChessPosition targetPosition = new ChessPosition('e', 1);

        ChessPiece capturedPiece = chessMatch.performChessMove(sourcePosition, targetPosition);

        Assert.assertNotNull(capturedPiece);
    }
}
