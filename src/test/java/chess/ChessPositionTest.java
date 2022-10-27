package chess;

import boardgame.Position;
import org.junit.Assert;
import org.junit.Test;

public class ChessPositionTest {
    @Test
    public void givenAPositionWhenCallToStringThenReturnRowAndColumn(){
        ChessPosition position = new ChessPosition('a',6);

        Assert.assertEquals(position.toString(), "a6");
    }
}
