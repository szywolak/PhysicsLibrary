package HorizontalAndVerticalThrows;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Michal on 16.05.2016.
 */
public class HorizontalThrowTest {

    @Test
    public void timeUntilColisionWithGroundTest() {
        //given
        HorizontalThrow horizontalThrow = new HorizontalThrow();
        //when
        double sa = horizontalThrow.timeUntilColisionWithGround(19.62);
        //then
        assertEquals(2.0, sa);
    }
}
