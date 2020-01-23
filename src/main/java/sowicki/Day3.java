package sowicki;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day3 {
    private List<String> pathOne = new ArrayList<String>();
    private List<String> pathTwo = new ArrayList<String>();

    public void adventOfCodeDay3Part1() throws FileNotFoundException {
        // call private method to load custom input
        loadInput();
        List<Point> crossedByFirstPath = calculatePathPoints(pathOne);

        // Get intersection of 2 sets of Points
//        List<String> commonPoints = new ArrayList<>(pathOne);
//        commonPoints.retainAll(pathTwo);

    }

    private List<Point> calculatePathPoints(List<String> path) {
        List<Point> pointsCrossed = new ArrayList<Point>();
        pointsCrossed.set(0, new Point(0, 0));

        // calculate further crossed points starting from Origin point
        for (int i = 0; i < pointsCrossed.size(); i++) {
            Point p = nextPointCrossed(path.get(i), pointsCrossed.get(i));
            pointsCrossed.add(p);
        }

        return pointsCrossed;
    }

    /**
     * Calculates next point crossed by path. Requires previous point and current instruction.
     *
     * @param instruction   from puzzle input
     * @param previousPoint
     * @return Point crossed.
     */
    private Point nextPointCrossed(String instruction, Point previousPoint) {
        char direction;
        int distance;
        direction = instruction.charAt(0);
        distance = Integer.parseInt(instruction.substring(1));
        return new Point(0, 0);
        // TODO implement reset of this method
    }

    /**
     * In List of Points, find which one is closes to Origin point (0, 0) in manhattan distance.
     *
     * @return Point which is closest to (0, 0) using manhattan distance.
     */
    private Point calculateManhattanClosestToOrigin(List<String> pointsList) {
        // TODO: IMPLEMENT this shit
        return new Point(0, 0);
    }

    private void loadInput() throws FileNotFoundException {
        File file = new File("src\\main\\resources\\advent3.txt");

        Scanner scanner = new Scanner(file);
        String s = scanner.nextLine();
        pathOne = Arrays.asList(new String[]{"R8", "U5", "L5", "D3"});
//        pathOne = Arrays.asList(s.split(","));
        s = scanner.nextLine();
        pathTwo = Arrays.asList(s.split(","));
    }
}
