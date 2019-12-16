package sowicki;

import java.io.FileNotFoundException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            new Day2().adventOfCodeDay2Part2();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
