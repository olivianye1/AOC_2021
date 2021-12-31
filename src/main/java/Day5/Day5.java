package Day5;

import Utils.InputParser;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.google.common.primitives.Ints.max;
import static java.lang.Integer.min;

public class Day5 {
    private InputParser inputParser = new InputParser();

    public int countDangerousPoints(String ventFilePath) throws FileNotFoundException {
        List<String> lineList = inputParser.parseInputForStringList(ventFilePath);
        getPointsInLine(lineList.get(0));
        List<String> allPointsInALine = new ArrayList<>();
        lineList.forEach(l -> allPointsInALine.addAll(getPointsInLine(l)));

        Set<String> intersectedPoints = new HashSet<>();
        return (int) allPointsInALine.stream().filter(n -> !intersectedPoints.add(n)).distinct().count();
    }


    private List<String> getPointsInLine(String line) {
        int spacerIndex = line.indexOf(" -> ");
        String startPointString = line.substring(0, spacerIndex);
        String endPointString = line.substring(spacerIndex + 4);

        List<Integer> startPointCoords = Arrays.stream(startPointString.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> endPointCoords = Arrays.stream(endPointString.split(",")).map(Integer::parseInt).collect(Collectors.toList());

        Point startPoint = new Point(startPointCoords.get(0), startPointCoords.get(1));
        Point endPoint = new Point(endPointCoords.get(0), endPointCoords.get(1));

        if (startPoint.getX() == endPoint.getX()) { // get points in vertical line

            return IntStream.range(min(startPoint.getY(), endPoint.getY()), max(startPoint.getY(), endPoint.getY()) + 1).mapToObj(i -> new Point(startPoint.getX(), i).toString()).collect(Collectors.toList());
        } else if (startPoint.getY() == endPoint.getY()) { // get points in horizontal line
            return IntStream.range(min(startPoint.getX(), endPoint.getX()), max(startPoint.getX(), endPoint.getX()) + 1).mapToObj(i -> new Point(i, startPoint.getY()).toString()).collect(Collectors.toList());
        } else { // skip diagonal lines
            return List.of();
        }
    }
}
