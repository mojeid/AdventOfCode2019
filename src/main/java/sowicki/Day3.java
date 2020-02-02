package sowicki;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.*;

public class Day3 {
    private List<String> pathOne = new ArrayList<String>();
    private List<String> pathTwo = new ArrayList<String>();

    public void adventOfCodeDay3Part1() throws FileNotFoundException {
        // call private method to load custom input
        loadInput();
        List<Point> crossedByFirstPath = calculatePathPoints(pathOne);
        List<Point> crossedBySecondPath = calculatePathPoints(pathTwo);

        // Get intersection of 2 sets of Points
        List<Point> commonPoints = new ArrayList<>(crossedByFirstPath);
        // find common points
        commonPoints.retainAll(crossedBySecondPath);
        // remove all origin point occurences
        commonPoints.removeIf(point -> point.x == 0 && point.y == 0);

        System.out.println("Result is: " + shortestManhattanDistanceToOrigin(commonPoints));

    }

    private List<Point> calculatePathPoints(List<String> path) {
        List<Point> pathPointsCrossed = new ArrayList<Point>();
        pathPointsCrossed.add(0, new Point(0, 0));

        // calculate further crossed points starting from Origin point
        for (int i = 0; i < path.size(); i++) {
            Point recentPointCrossed = pathPointsCrossed.get(pathPointsCrossed.size() - 1);
            List<Point> points = pointsCrossedDuringInstruction(path.get(i), recentPointCrossed);
            pathPointsCrossed.addAll(points);
        }

        return pathPointsCrossed;
    }

    /**
     * Calculates next point crossed by path. Requires previous point and current instruction.
     *
     * @param instruction   from puzzle input
     * @param startingPoint
     * @return Point crossed.
     */
    private List<Point> pointsCrossedDuringInstruction(String instruction, Point startingPoint) {
        List<Point> result = new ArrayList<>();
        String direction = instruction.substring(0, 1);
        int distance = Integer.parseInt(instruction.substring(1));
        int finishX, finishY;

        switch (direction) {
            case "R":
                finishX = startingPoint.x + distance;
                finishY = startingPoint.y;
                result.addAll(allPointsBetween(startingPoint, new Point(finishX, finishY)));
                break;
            case "L":
                finishX = startingPoint.x - distance;
                finishY = startingPoint.y;
                result.addAll(allPointsBetween(startingPoint, new Point(finishX, finishY)));
                break;
            case "U":
                finishX = startingPoint.x;
                finishY = startingPoint.y + distance;
                result.addAll(allPointsBetween(startingPoint, new Point(finishX, finishY)));
                break;
            case "D":
                finishX = startingPoint.x;
                finishY = startingPoint.y - distance;
                result.addAll(allPointsBetween(startingPoint, new Point(finishX, finishY)));
                break;
        }

        return result;
    }

    /**
     * Retuns list of all points between point A and point B
     *
     * @param pointA
     * @param pointB
     * @return
     */
    private List<Point> allPointsBetween(Point pointA, Point pointB) {
        List<Point> result = new ArrayList<>();

        if (pointA.x > pointB.x) {
            for (int i = 0; i <= Math.abs(pointA.x - pointB.x); i++) {
                result.add(new Point(pointA.x - i, pointA.y));
            }
        }

        if (pointA.x < pointB.x) {
            for (int i = 0; i <= Math.abs(pointA.x - pointB.x); i++) {
                result.add(new Point(pointA.x + i, pointA.y));
            }
        }

        // y maths
        if (pointA.y > pointB.y) {
            for (int i = 0; i <= Math.abs(pointA.y - pointB.y); i++) {
                result.add(new Point(pointA.x, pointA.y - i));
            }
        }

        if (pointA.y < pointB.y) {
            for (int i = 0; i <= Math.abs(pointA.y - pointB.y); i++) {
                result.add(new Point(pointA.x, pointA.y + i));
            }
        }

        if (pointA.x == pointB.x && pointA.y == pointB.y) {
            System.out.println("CHEATING, 2 points are the same!!");
        }

        return result;
    }

    /**
     * In List of Points, find which one is closes to Origin point (0, 0) in manhattan distance.
     *
     * @return Point which is closest to (0, 0) using manhattan distance.
     */
    private int shortestManhattanDistanceToOrigin(List<Point> pointsList) {
        OptionalInt shortestDistance = pointsList
                .stream()
                .mapToInt(this::manhattanDistance)
                .min();
        return shortestDistance.getAsInt();
    }

    public int manhattanDistance(Point p) {
        return Math.abs(p.x) + Math.abs(p.y);
    }

    private void loadInput() throws FileNotFoundException {
        File file = new File("src\\main\\resources\\advent3.txt");

        Scanner scanner = new Scanner(file);
        String s = scanner.nextLine();
        pathOne = Arrays.asList(s.split(","));
        s = scanner.nextLine();
        pathTwo = Arrays.asList(s.split(","));
    }

}
