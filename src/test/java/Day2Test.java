import Day2.Day2;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class Day2Test {
    private Day2 day2 = new Day2();

    @Test
    void calculateFinalPositionTestData() throws FileNotFoundException {
        int expectedHorizontalPosition = 15;
        int expectedDepth = 12;

        assertThat(day2.calculateFinalPosition("/Users/olivianye/Projects/AOC_2021/src/main/java/Day2/Day2TestInput"))
                .isEqualTo(expectedHorizontalPosition * expectedDepth);
    }

    @Test
    void calculateFinalPositionAOCData() throws FileNotFoundException {
        int expectedPosition = 1727835;
        assertThat(day2.calculateFinalPosition("/Users/olivianye/Projects/AOC_2021/src/main/java/Day2/Day2AocInput"))
                .isEqualTo(expectedPosition);
    }
}
