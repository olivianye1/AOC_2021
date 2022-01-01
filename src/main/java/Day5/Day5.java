package Day5;

import Utils.InputParser;
import com.google.common.primitives.Ints;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.google.common.primitives.Ints.max;
import static java.lang.Integer.min;

public class Day5 {
    private InputParser inputParser = new InputParser();

    public int countDangerousPoints(String ventFilePath, boolean checkDiagonals) throws FileNotFoundException {
        List<String> lineList = inputParser.parseInputForStringList(ventFilePath);
        List<String> allPointsInALine = new ArrayList<>();
        lineList.forEach(l -> allPointsInALine.addAll(getPointsInLine(l, checkDiagonals)));

        Set<String> intersectedPoints = new HashSet<>();
        return (int) allPointsInALine.stream().filter(n -> !intersectedPoints.add(n)).distinct().count();
    }


    private List<String> getPointsInLine(String line, boolean checkDiagonals) {
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
            List<String> pointList = new ArrayList<>();
            if (checkDiagonals) {
                if (startPoint.getX() > endPoint.getX()) {
                    if (startPoint.getY() > endPoint.getY()) { // x decreasing, y decreasing diagonal
                        int x = startPoint.getX();
                        int y = startPoint.getY();
                        while (x >= endPoint.getX() && y >= endPoint.getY()) {
                            pointList.add(new Point(x, y).toString());
                            x -= 1;
                            y -= 1;
                        }
                    } else { // x decreasing, y increasing diagonal
                        int x = startPoint.getX();
                        int y = startPoint.getY();
                        while (x >= endPoint.getX() && y <= endPoint.getY()) {
                            pointList.add(new Point(x, y).toString());
                            x -= 1;
                            y += 1;
                        }
                    }
                } else {
                    if (startPoint.getY() > endPoint.getY()) { // x increasing, y decreasing
                        int x = startPoint.getX();
                        int y = startPoint.getY();
                        while (x <= endPoint.getX() && y >= endPoint.getY()) {
                            pointList.add(new Point(x, y).toString());
                            x += 1;
                            y -= 1;
                        }
                    } else { // x increasing, y increasing diagonal
                        int x = startPoint.getX();
                        int y = startPoint.getY();
                        while (x <= endPoint.getX() && y <= endPoint.getY()) {
                            pointList.add(new Point(x, y).toString());
                            x += 1;
                            y += 1;
                        }
                    }
                }
                return pointList;
            } else {
                return List.of();
            }
        }
    }
}
