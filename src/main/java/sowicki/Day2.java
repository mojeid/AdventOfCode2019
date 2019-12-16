package sowicki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {
    private List<Integer> oppcodesList;

    public void adventOfCodeDay2Part2() throws FileNotFoundException {
        File file = new File("src\\main\\resources\\advent2.txt");

        // Load the custom user input
        List<Integer> originalOppcodesList = new ArrayList<Integer>();
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            originalOppcodesList.add(scanner.nextInt());
        }

        for (int j = 0; j < 100; j++) {
            for (int z = 0; z < 100; z++) {
                oppcodesList = new ArrayList<>(originalOppcodesList);
                oppcodesList.set(1, j);
                oppcodesList.set(2, z);

                System.out.println("Results for: " + j + " " + z);

                // go through list, apply instructions
                for (int i = 0; i < oppcodesList.size(); i = i + 4) {
                    int result;
                    try {
                        result = executeInstruction(i);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Caught error");
                        break;
                    }
                    if (result == 99)
                        break;
                }
            }
        }


    }

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
        for (int i = 0; i < oppcodesList.size(); i = i + 4) {
            if (executeInstruction(i) > 0) {
                return;
            }
        }
    }

    private int executeInstruction(int i) {
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
                if (oppcodesList.get(0) == 19690720) {
                    System.out.println("DUPA");
                }
                System.out.println("Exit as planned.");
                return 99;
            default:
                System.out.println(oppcodesList.get(0));
                System.out.println("Error in oppcodes! Exit!");
                return -1;
        }
        return -1;
    }
}
