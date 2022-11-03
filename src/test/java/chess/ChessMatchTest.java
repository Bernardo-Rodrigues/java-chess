package chess;

import application.UI;
import boardgame.Piece;
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
    public void givenAPieceMovementWhenCaptureOponentPieceThenUpdatePiecesLists(){
        ChessMatch chessMatch = new ChessMatch();
        ChessPosition sourcePosition = new ChessPosition('e', 7);
        ChessPosition targetPosition = new ChessPosition('e', 8);
        Rook oponentRook = new Rook(chessMatch.getBoard(), Color.WHITE);
        chessMatch.getBoard().placePiece(oponentRook, sourcePosition.toPosition());

        chessMatch.performChessMove(sourcePosition, targetPosition);

        Assert.assertEquals(chessMatch.getPiecesOnTheBoard().size(), 2);
        Assert.assertEquals(chessMatch.getCapturedPieces().size(), 1);
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

    @Test
    public void givenAPieceMoveWhenThePlayerPutHimselfInCheckThenTheMoveShouldBeUndone(){
        ChessMatch chessMatch = new ChessMatch();
        ChessPosition sourcePosition = new ChessPosition('b', 6);
        ChessPosition targetPosition = new ChessPosition('d', 6);

        chessMatch.performChessMove(sourcePosition, targetPosition);

        ChessPosition checkSourcePosition = new ChessPosition('e', 8);
        ChessPosition checkTargetPosition = new ChessPosition('d', 8);

        Assert.assertThrows(ChessException.class, () -> chessMatch.performChessMove(checkSourcePosition, checkTargetPosition));
        Assert.assertTrue(chessMatch.getBoard().thereIsAPiece(checkSourcePosition.toPosition()));
    }
}
