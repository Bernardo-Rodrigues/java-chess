package boardgame;

import chess.ChessMatch;
import chess.Color;
import org.junit.Assert;
import org.junit.Test;
import chess.pieces.Rook;

public class BoardTest {
    @Test
    public void givenAPlacedPieceWhenVerifyItsPositionThenReturnIt(){
        ChessMatch chessMatch = new ChessMatch();
        Rook rook = new Rook(chessMatch.getBoard(), Color.BLACK);
        Position position = new Position(4,4);

        chessMatch.getBoard().placePiece(rook, position);

        Assert.assertEquals(chessMatch.getBoard().piece(position), rook);
    }

    @Test
    public void givenARemovedPieceWhenVerifyThatThereIsAPiecePositionThenReturnFalse(){
        ChessMatch chessMatch = new ChessMatch();
        Position position = new Position(0,0);

        chessMatch.getBoard().removePiece(position);

        Assert.assertEquals(chessMatch.getBoard().thereIsAPiece(position), false);
    }

    @Test
    public void givenANonexistingPositionWhenVerifyIfItExistsThenReturnFalse(){
        ChessMatch chessMatch = new ChessMatch();
        Position position = new Position(9,9);

        Assert.assertEquals(chessMatch.getBoard().positionExists(position), false);
    }
}
