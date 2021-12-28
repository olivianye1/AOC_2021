import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day1 {
    // Part 1
    public int countIncreasingPairs(List<Integer> depths) {
        if (depths.size() < 2) {
            return 0;
        } else {
            return (int) IntStream.range(0, depths.size() - 1).filter(i -> depths.get(i) < depths.get(i + 1)).count();
        }
    }

    // Part 2
    public int countIncreasingWindowSums(List<Integer> depths) {
        if (depths.size() < 3) {
            return 0;
        } else {
            List<Integer> windowSums = new ArrayList<>();
            IntStream.range(0, depths.size() - 2).forEach(i -> windowSums.add(depths.get(i) + depths.get(i + 1) + depths.get(i + 2)));
            return countIncreasingPairs(windowSums);
        }
    }
}
