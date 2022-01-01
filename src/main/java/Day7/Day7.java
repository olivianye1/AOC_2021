package Day7;

import Utils.InputParser;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

import static java.lang.Math.abs;
import static java.util.Collections.max;
import static java.util.Collections.min;

public class Day7 {
    InputParser inputParser = new InputParser();
    public int getCheapestPositionFuelCost(String filePath) throws FileNotFoundException {
        List<Integer> positions = inputParser.parseInputForInts(filePath);

        AtomicInteger minTotalFuelPosition = new AtomicInteger();
        AtomicReference<Integer> minTotalFuel = new AtomicReference<>((int) Double.POSITIVE_INFINITY);
        IntStream.range( min(positions), max(positions) + 1).forEach(p -> {
            int totalFuel = positions.stream().map(initialPosition -> getFuelNeeded(initialPosition, p)).reduce(0, Integer::sum);
            if (totalFuel < minTotalFuel.get()) {
                minTotalFuel.set(totalFuel);
                minTotalFuelPosition.set(p);
            }
        });
        return minTotalFuel.get();
    }

    private int getFuelNeeded(int initialPosition, int targetPosition) {
        return abs(initialPosition - targetPosition);
    }
}


