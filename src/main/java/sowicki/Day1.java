package sowicki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

    public static int adventOfCode1Part2() throws FileNotFoundException {
        File file = new File("src\\main\\resources\\advent1.txt");

        Scanner scanner = new Scanner(file);
        int result = 0;
        while (scanner.hasNext()) {
            int moduleMass = scanner.nextInt();
            double fuelForModule = Math.floor(moduleMass / 3) - 2;
            result += fuelForModule;

            while (fuelForModule > 0) {
                fuelForModule = Math.floor(fuelForModule / 3) - 2;
                if (fuelForModule > 0)
                    result += fuelForModule;
            }
        }
        return result;
    }
}
