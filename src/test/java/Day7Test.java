import Day6.Day6;
import Day7.Day7;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class Day7Test {

    Day7 day7 = new Day7();

    @Test
    void testGetCheapestPositionTestInput() throws FileNotFoundException {
        int expectedCount = 37;
        assertThat(day7.getCheapestPositionFuelCost("/Users/olivianye/Projects/AOC_2021/src/main/java/Day7/Day7TestInput"))
                .isEqualTo(expectedCount);
    }

    @Test
    void testGetCheapestPositionAocInput() throws FileNotFoundException {
        int expectedCount = 352997;
        assertThat(day7.getCheapestPositionFuelCost("/Users/olivianye/Projects/AOC_2021/src/main/java/Day7/Day7AocInput"))
                .isEqualTo(expectedCount);
    }
}
