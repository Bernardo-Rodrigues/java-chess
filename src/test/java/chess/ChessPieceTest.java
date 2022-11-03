package chess;

import org.junit.Assert;
import org.junit.Test;
import chess.pieces.Rook;

public class ChessPieceTest {
    @Test
    public void givenAPieceMovementWhenMovedCorrectlyThenUpdateItsMoveCount(){
        ChessMatch chessMatch = new ChessMatch();
        ChessPosition sourcePosition = new ChessPosition('e', 4);
        ChessPosition targetPosition = new ChessPosition('e', 5);
        Rook rook = new Rook(chessMatch.getBoard(), Color.WHITE);
        chessMatch.getBoard().placePiece(rook, sourcePosition.toPosition());

        chessMatch.performChessMove(sourcePosition, targetPosition);

        Assert.assertEquals(rook.getMoveCount(), 1);
    }
}
