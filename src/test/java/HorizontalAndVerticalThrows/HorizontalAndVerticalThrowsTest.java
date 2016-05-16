package HorizontalAndVerticalThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;


/**
 * Created by Michal on 13.05.2016.
 */

@RunWith(Parameterized.class)
public class HorizontalAndVerticalThrowsTest {

    private double height;
    private double time;
    private double expected;

    public HorizontalAndVerticalThrowsTest(double height, double time, double expected) {
        this.height = height;
        this.time = time;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10, 1, 5.095},
                {100, 5.8, 0}
        });
    }

    @Test
    public void test() {
        //given
        VerticalThrow verticalThrow = new VerticalThrow();
        //when
        double sa = verticalThrow.positionAfterSomeTime(height, time);
        //then
        assertEquals(expected, sa);
    }
}
