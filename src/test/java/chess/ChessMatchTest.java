package chess;

import chess.pieces.Bishop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatchTest {

    private ChessMatch chessMatch;
    @Before
    public void initEach(){
        chessMatch = new ChessMatch();
    }
    @Test
    public void givenAChessMatchWhenStartsThenPlaceThePiecesCorretly(){
        Assert.assertTrue(chessMatch.getPieces()[0][4] instanceof King);
        Assert.assertTrue(chessMatch.getPieces()[7][4] instanceof King);
    }

    @Test
    public void givenAChessPieceWhenPerformAMoveThenPlaceThePieceCorretly(){
        ChessPosition sourcePosition = new ChessPosition('e', 2);
        ChessPosition targetPosition = new ChessPosition('e', 3);

        chessMatch.performChessMove(sourcePosition, targetPosition);
        
        Assert.assertTrue(chessMatch.getBoard().thereIsAPiece(targetPosition.toPosition()));
    }

    @Test
    public void givenAPieceMovementWhenCaptureOponentPieceThenUpdatePiecesLists(){
        ChessPosition sourcePosition = new ChessPosition('h', 4);
        ChessPosition targetPosition = new ChessPosition('h', 7);
        Rook oponentRook = new Rook(chessMatch.getBoard(), Color.WHITE);

        chessMatch.getBoard().placePiece(oponentRook, sourcePosition.toPosition());
        chessMatch.performChessMove(sourcePosition, targetPosition);
        chessMatch.getBoard().removePiece(targetPosition.toPosition());

        Assert.assertEquals(chessMatch.getPiecesOnTheBoard().size(), 31);
        Assert.assertEquals(chessMatch.getCapturedPieces().size(), 1);
    }

    @Test
    public void givenAChessMovePieceWhenTargetPositionHasAnOponentPieceThenReturnThisPiece(){
        ChessPosition sourcePosition = new ChessPosition('a', 4);
        ChessPosition targetPosition = new ChessPosition('a', 7);
        Rook oponentRook = new Rook(chessMatch.getBoard(), Color.WHITE);
        chessMatch.getBoard().placePiece(oponentRook, sourcePosition.toPosition());

        ChessPiece capturedPiece = chessMatch.performChessMove(sourcePosition, targetPosition);

        Assert.assertNotNull(capturedPiece);
    }

    @Test
    public void givenAChosenPieceWhenItsNotOfTheCurrentPlayerThenThrowsException(){
        ChessPosition sourcePosition = new ChessPosition('e', 8);
        ChessPosition targetPosition = new ChessPosition('e', 1);

        Assert.assertThrows(ChessException.class, () -> chessMatch.performChessMove(sourcePosition, targetPosition));
    }

    @Test
    public void givenAValidMoveWhenDoneThenSwitchTurn(){
        ChessPosition sourcePosition = new ChessPosition('e', 2);
        ChessPosition targetPosition = new ChessPosition('e', 3);

        Assert.assertEquals(chessMatch.getTurn(), 1);
        Assert.assertEquals(chessMatch.getCurrentPlayer(), Color.WHITE);

        chessMatch.performChessMove(sourcePosition, targetPosition);

        Assert.assertEquals(chessMatch.getTurn(), 2);
        Assert.assertEquals(chessMatch.getCurrentPlayer(), Color.BLACK);
    }

    @Test
    public void givenAPieceMoveWhenThePlayerPutHimselfInCheckThenTheMoveShouldThrowAnException(){
        ChessPosition pawnPosition = new ChessPosition('e', 2);
        chessMatch.getBoard().removePiece(pawnPosition.toPosition());
        Bishop bishop = new Bishop(chessMatch.getBoard(), Color.BLACK);
        ChessPosition bishopPosition = new ChessPosition('f', 3);
        chessMatch.getBoard().placePiece(bishop, bishopPosition.toPosition());
        ChessPosition sourcePosition = new ChessPosition('e', 1);
        ChessPosition targetPosition = new ChessPosition('e', 2);

        Assert.assertThrows(ChessException.class, () -> chessMatch.performChessMove(sourcePosition, targetPosition));
    }
}
