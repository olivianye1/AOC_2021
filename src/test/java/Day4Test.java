import Day4.Day4;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class Day4Test {
    Day4 day4 = new Day4();

    @Test
    void testDetermineWinningScoreTestData() throws FileNotFoundException {
        int expectedScore = 4512;
        assertThat(day4.getWinningScore("/Users/olivianye/Projects/AOC_2021/src/main/java/Day4/Day4TestInput"))
                .isEqualTo(expectedScore);
    }

    @Test
    void testDetermineWinningScoreAocData() throws FileNotFoundException {
        int expectedScore = 32844;
        assertThat(day4.getWinningScore("/Users/olivianye/Projects/AOC_2021/src/main/java/Day4/Day4AocInput"))
                .isEqualTo(expectedScore);
    }
}
