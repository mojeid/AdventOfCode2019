package sowicki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day2 {

    public void adventOfCodeDay2Part1() throws FileNotFoundException {
        File file = new File("src\\main\\resources\\advent2.txt");

        // Load the custom user input
        List<Integer> oppcodesList = new ArrayList<Integer>();
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            oppcodesList.add(scanner.nextInt());
        }

        // replacing position 1 and 2 as given in the puzzle description
        oppcodesList.set(1, 12);
        oppcodesList.set(2, 2);

        // go through list, apply instructions
        for (int i = 0; i < oppcodesList.size(); i = i+4) {
            Integer oppcode1 = i + 1;
            Integer oppcode2 = i + 2;
            Integer oppcode3 = i + 3;
            Integer result, target = 0;
            Integer element1, element2 = 0;
            switch (oppcodesList.get(i)) {
                case 1:
                    element1 = oppcodesList.get(oppcodesList.get(oppcode1));
                    element2 = oppcodesList.get(oppcodesList.get(oppcode2));
                    result = element1 + element2;
                    target = oppcodesList.get(oppcode3);
                    oppcodesList.set(target, result);
                    break;
                case 2:
                    element1 = oppcodesList.get(oppcodesList.get(oppcode1));
                    element2 = oppcodesList.get(oppcodesList.get(oppcode2));
                    result = element1 * element2;
                    target = oppcodesList.get(oppcode3);
                    oppcodesList.set(target, result);
                    break;
                case 99:
                    System.out.println("Oppcode 99 parsed.");
                    System.out.println("Value at positon 0 is: " + oppcodesList.get(0));
                    System.out.println("Exit as planned.");
                    return;
                default:
                    System.out.println("Error in oppcodes! Exit!");
                    return;
            }
        }


    }
}
