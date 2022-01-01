package Day6;

import Utils.InputParser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Day6 {

    private InputParser inputParser = new InputParser();

    public int countFish(String fishInfoFilePath, int daysLater) throws FileNotFoundException {
        List<Integer> fishList = inputParser.parseInputForInts(fishInfoFilePath);

        if (fishList.size() > 0) {

            int daysPassed = 0;
            while (daysPassed < daysLater) {
                List<Integer> updatedFishList = new ArrayList<>();
                fishList.forEach(f -> {
                    if (f == 0) {
                        updatedFishList.add(6);
                        updatedFishList.add(8);
                    } else {
                        updatedFishList.add(f - 1);
                    }
                });

                fishList = updatedFishList;
                daysPassed += 1;
            }
            return fishList.size();
        } else {
            return 0;
        }
    }
}
