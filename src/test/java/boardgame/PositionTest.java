package boardgame;

import org.junit.Assert;
import org.junit.Test;

public class PositionTest {
    @Test
    public void givenAPositionWhenCallToStringThenReturnRowAndColumn(){
        Position position = new Position(1,2);

        Assert.assertEquals(position.toString(), "1, 2");
    }
}
