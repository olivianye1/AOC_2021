import Day2.Day2;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class Day2Test {
    private Day2 day2 = new Day2();

    // Part 1 Tests
    @Test
    void calculateFinalPositionTestData() throws FileNotFoundException {
        int expectedPosition = 150;

        assertThat(day2.calculateFinalPosition("/Users/olivianye/Projects/AOC_2021/src/main/java/Day2/Day2TestInput"))
                .isEqualTo(expectedPosition);
    }

    @Test
    void calculateFinalPositionAOCData() throws FileNotFoundException {
        int expectedPosition = 1727835;
        assertThat(day2.calculateFinalPosition("/Users/olivianye/Projects/AOC_2021/src/main/java/Day2/Day2AocInput"))
                .isEqualTo(expectedPosition);
    }

    // Part 2 Tests
    @Test
    void calculateFinalPositionWithAimTestData() throws FileNotFoundException {
        int expectedPosition = 900;

        assertThat(day2.calculateFinalPositionWithAim("/Users/olivianye/Projects/AOC_2021/src/main/java/Day2/Day2TestInput"))
                .isEqualTo(expectedPosition);
    }

    @Test
    void calculateFinalPositionWithAimAocData() throws FileNotFoundException {
        int expectedPosition = 1544000595;
        assertThat(day2.calculateFinalPositionWithAim("/Users/olivianye/Projects/AOC_2021/src/main/java/Day2/Day2AocInput"))
                .isEqualTo(expectedPosition);
    }
}
