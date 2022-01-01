import Day5.Day5;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class Day5Test {
    Day5 day5 = new Day5();

    @Test
    void testCountDangerousPointsOnTestInputWithoutDiagonals() throws FileNotFoundException {
        int expectedCount = 5;
        assertThat(day5.countDangerousPoints("/Users/olivianye/Projects/AOC_2021/src/main/java/Day5/Day5TestInput", false))
                .isEqualTo(expectedCount);
    }

    @Test
    void testCountDangerousPointsOnAocInputWithoutDiagonals() throws FileNotFoundException {
        int expectedCount = 4993;
        assertThat(day5.countDangerousPoints("/Users/olivianye/Projects/AOC_2021/src/main/java/Day5/Day5AocInput", false))
                .isEqualTo(expectedCount);
    }

    @Test
    void testCountDangerousPointsOnTestInputWithDiagonals() throws FileNotFoundException {
        int expectedCount = 12;
        assertThat(day5.countDangerousPoints("/Users/olivianye/Projects/AOC_2021/src/main/java/Day5/Day5TestInput", true))
                .isEqualTo(expectedCount);
    }

    @Test
    void testCountDangerousPointsOnAocInputWithDiagonals() throws FileNotFoundException {
        int expectedCount = 21101;
        assertThat(day5.countDangerousPoints("/Users/olivianye/Projects/AOC_2021/src/main/java/Day5/Day5AocInput", true))
                .isEqualTo(expectedCount);
    }
}
