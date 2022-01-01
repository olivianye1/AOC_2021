package Day6;

import Utils.InputParser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day6 {

    private InputParser inputParser = new InputParser();

    public int countFish(String fishInfoFilePath, int daysLater) throws FileNotFoundException {
        List<Integer> fishList = inputParser.parseInputForInts(fishInfoFilePath);

        if (fishList.size() > 0) {
            Map<Integer, Integer> fishAgeCountMap = new HashMap<>();
            fishAgeCountMap.put(0, 0);
            fishAgeCountMap.put(1, 0);
            fishAgeCountMap.put(2, 0);
            fishAgeCountMap.put(3, 0);
            fishAgeCountMap.put(4, 0);
            fishAgeCountMap.put(5, 0);
            fishAgeCountMap.put(6, 0);
            fishAgeCountMap.put(7, 0);
            fishAgeCountMap.put(8, 0);

            fishList.forEach(f -> fishAgeCountMap.put(f, fishAgeCountMap.get(f) + 1));

            int daysPassed = 0;
            while (daysPassed < daysLater) {
                int birthsToday = fishAgeCountMap.get(0);

                int tempX = fishAgeCountMap.get(8);
                fishAgeCountMap.put(8, birthsToday);

                int tempY = fishAgeCountMap.get(7);
                fishAgeCountMap.put(7, tempX);
                tempX = fishAgeCountMap.get(6);
                fishAgeCountMap.put(6, tempY + birthsToday);
                tempY = fishAgeCountMap.get(5);
                fishAgeCountMap.put(5, tempX);
                tempX = fishAgeCountMap.get(4);
                fishAgeCountMap.put(4, tempY);
                tempY = fishAgeCountMap.get(3);
                fishAgeCountMap.put(3, tempX);
                tempX = fishAgeCountMap.get(2);
                fishAgeCountMap.put(2, tempY);
                tempY = fishAgeCountMap.get(1);
                fishAgeCountMap.put(1, tempX);
                fishAgeCountMap.put(0, tempY);

                daysPassed += 1;
            }
            return fishAgeCountMap.values().stream().reduce(0, Integer::sum);
        } else {
            return 0;
        }
    }
}
