package boardgame;

import chess.Color;
import org.junit.Assert;
import org.junit.Test;
import pieces.Rook;

public class BoardTest {
    @Test
    public void givenAPlacedPieceWhenVerifyItsPositionThenReturnIt(){
        Board board = new Board(8,8);
        Rook rook = new Rook(board, Color.BLACK);
        Position position = new Position(0,0);

        board.placePiece(rook, position);

        Assert.assertEquals(board.piece(position), rook);
    }
}
