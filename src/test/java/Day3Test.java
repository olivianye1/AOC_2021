import Day3.Day3;
import Utils.InputParser;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day3Test {

    Day3 day3 = new Day3();

    InputParser inputParser = new InputParser();

    private final List<String> TEST_BINARIES = inputParser.parseInputForStringList("/Users/olivianye/Projects/AOC_2021/src/main/java/Day3/Day3TestInput");

    private final List<String> AOC_BINARIES = inputParser.parseInputForStringList("/Users/olivianye/Projects/AOC_2021/src/main/java/Day3/Day3AocInput");

    public Day3Test() throws FileNotFoundException {
    }

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

    @Test
    void testGetOxygenGeneratorRatingOnTestInput() {
        int expectedOxygenGeneratorRating = 23;

        assertThat(day3.getOxygenGeneratorRating(TEST_BINARIES))
                .isEqualTo(expectedOxygenGeneratorRating);
    }

    @Test
    void testGetCo2ScrubberRatingOnTestInput() {
        int expectedCo2ScrubberRating = 10;

        assertThat(day3.getCo2ScrubberRating(TEST_BINARIES))
                .isEqualTo(expectedCo2ScrubberRating);
    }

    @Test
    void testGetLifeSupportRatingOnTestInput() throws FileNotFoundException {
        int expectedLifeSupportRating = 230;

        assertThat(day3.getLifeSupportRating("/Users/olivianye/Projects/AOC_2021/src/main/java/Day3/Day3TestInput"))
                .isEqualTo(expectedLifeSupportRating);
    }

    @Test
    void testGetLifeSupportRatingOnAocInput() throws FileNotFoundException {
        int expectedLifeSupportRating = 3379326;

        assertThat(day3.getLifeSupportRating("/Users/olivianye/Projects/AOC_2021/src/main/java/Day3/Day3AocInput"))
                .isEqualTo(expectedLifeSupportRating);
    }
}
