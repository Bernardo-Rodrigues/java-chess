package chess;

import boardgame.Position;
import org.junit.Assert;
import org.junit.Test;
import pieces.King;
import pieces.Rook;

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
        ChessPosition sourcePosition = new ChessPosition('e', 1);
        ChessPosition targetPosition = new ChessPosition('e', 2);

        chessMatch.performChessMove(sourcePosition, targetPosition);

        Assert.assertTrue(chessMatch.getBoard().thereIsAPiece(targetPosition.toPosition()));
    }

    @Test
    public void givenAChessMovePieceWhenTargetPositionHasAPieceThenReturnThisPiece(){
        ChessMatch chessMatch = new ChessMatch();
        ChessPosition sourcePosition = new ChessPosition('e', 1);
        ChessPosition targetPosition = new ChessPosition('e', 2);
        Rook oponentRook = new Rook(chessMatch.getBoard(), Color.BLACK);
        chessMatch.getBoard().placePiece(oponentRook, targetPosition.toPosition());

        ChessPiece capturedPiece = chessMatch.performChessMove(sourcePosition, targetPosition);

        Assert.assertNotNull(capturedPiece);
    }

    @Test
    public void givenAChosenPieceWhenItsNotOfTheCurrentPlayerThenThrowsException(){
        ChessMatch chessMatch = new ChessMatch();
        ChessPosition sourcePosition = new ChessPosition('e', 8);
        ChessPosition targetPosition = new ChessPosition('e', 1);

        Assert.assertThrows(ChessException.class, () -> chessMatch.performChessMove(sourcePosition, targetPosition));
    }

    @Test
    public void givenAValidMoveWhenDoneThenSwitchTurn(){
        ChessMatch chessMatch = new ChessMatch();
        ChessPosition sourcePosition = new ChessPosition('e', 1);
        ChessPosition targetPosition = new ChessPosition('e', 2);

        Assert.assertEquals(chessMatch.getTurn(), 1);
        Assert.assertEquals(chessMatch.getCurrentPlayer(), Color.WHITE);

        chessMatch.performChessMove(sourcePosition, targetPosition);

        Assert.assertEquals(chessMatch.getTurn(), 2);
        Assert.assertEquals(chessMatch.getCurrentPlayer(), Color.BLACK);
    }
}
