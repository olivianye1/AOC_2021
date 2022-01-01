import Day6.Day6;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class Day6Test {
    Day6 day6 = new Day6();

    @Test
    void testCountFishTestInput() throws FileNotFoundException {
        int expectedCount = 5934;
        assertThat(day6.countFish("/Users/olivianye/Projects/AOC_2021/src/main/java/Day6/Day6TestInput", 80))
                .isEqualTo(expectedCount);
    }

    @Test
    void testCountFishAocInput() throws FileNotFoundException {
        int expectedCount = 376194;
        assertThat(day6.countFish("/Users/olivianye/Projects/AOC_2021/src/main/java/Day6/Day6AocInput", 80))
                .isEqualTo(expectedCount);
    }
}
