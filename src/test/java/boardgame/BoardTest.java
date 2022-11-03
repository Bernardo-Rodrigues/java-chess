package boardgame;

import chess.Color;
import org.junit.Assert;
import org.junit.Test;
import chess.pieces.Rook;

public class BoardTest {
    @Test
    public void givenAPlacedPieceWhenVerifyItsPositionThenReturnIt(){
        Board board = new Board(8,8);
        Rook rook = new Rook(board, Color.BLACK);
        Position position = new Position(0,0);

        board.placePiece(rook, position);

        Assert.assertEquals(board.piece(position), rook);
    }

    @Test
    public void givenARemovedPieceWhenVerifyThatThereIsAPiecePositionThenReturnFalse(){
        Board board = new Board(8,8);
        Rook rook = new Rook(board, Color.BLACK);
        Position position = new Position(0,0);

        board.placePiece(rook, position);
        board.removePiece(position);

        Assert.assertEquals(board.thereIsAPiece(position), false);
    }

    @Test
    public void givenANonexistingPositionWhenVerifyIfItExistsThenReturnFalse(){
        Board board = new Board(8,8);
        Position position = new Position(9,9);

        Assert.assertEquals(board.positionExists(position), false);
    }
}
