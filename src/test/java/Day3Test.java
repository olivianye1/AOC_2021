import Day3.Day3;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class Day3Test {

    Day3 day3 = new Day3();

    @Test
    void testGetPowerConsumptionOnTestInput() throws FileNotFoundException {
        int expectedPowerConsumption = 198;

        assertThat(day3.getPowerConsumption("/Users/olivianye/Projects/AOC_2021/src/main/java/Day3/Day3TestInput"))
                .isEqualTo(expectedPowerConsumption);
    }

    @Test
    void testGetPowerConsumptionOnAocInput() throws FileNotFoundException {
        int expectedPowerConsumption = 693486;
        assertThat(day3.getPowerConsumption("/Users/olivianye/Projects/AOC_2021/src/main/java/Day3/Day3AocInput"))
                .isEqualTo(expectedPowerConsumption);
    }
}
