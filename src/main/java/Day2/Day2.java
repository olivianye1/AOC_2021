package Day2;

import Utils.InputParser;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.parseInt;

public class Day2 {

    private InputParser inputParser = new InputParser();

    public int calculateFinalPosition(String plannedCourseFilePath) throws FileNotFoundException {
        List<String> courseList = inputParser.parseInputForStringList(plannedCourseFilePath);

        if (courseList.size() > 1) {
            AtomicInteger horizontalPosition = new AtomicInteger();
            AtomicInteger depth = new AtomicInteger();

            courseList.forEach(c -> {
                int spacerIndex = c.indexOf(' ');
                String direction = c.substring(0, spacerIndex);
                int steps = parseInt(c.substring(spacerIndex + 1));

                if ("forward".equals(direction)) {
                    horizontalPosition.addAndGet(steps);
                } else if ("down".equals(direction)) {
                    depth.addAndGet(steps);
                } else {
                    depth.addAndGet(-steps);
                }
            });
            return depth.get() * horizontalPosition.get();
        } else {
            return 0;
        }
    }
}
