package sowicki;

import java.io.FileNotFoundException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            new Day3().adventOfCodeDay3Part1();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
