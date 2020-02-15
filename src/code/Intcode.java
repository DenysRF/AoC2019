package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Intcode {

    public int[] readInput(String path) {
        int[] instructions = null;
        try {
            File input = new File(path);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                instructions = new int[data.length];
                for (int i = 0; i < data.length; i ++) {
                    instructions[i] = (Integer.parseInt(data[i]));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return instructions;
    }

    public int[] executeIntcode(int[] instructions) {
        for (int i = 0; i < instructions.length && instructions[i] != 99; i += 4) {
            switch(instructions[i]) {
                case 1:
                    int add1 = instructions[instructions[i + 1]];
                    int add2 = instructions[instructions[i + 2]];
                    int addDest = instructions[i + 3];
                    instructions[addDest] = add1 + add2;
                    break;
                case 2:
                    int mult1 = instructions[instructions[i + 1]];
                    int mult2 = instructions[instructions[i + 2]];
                    int multDest = instructions[i + 3];
                    instructions[multDest] = mult1 * mult2;
                    break;
                default:
                    throw new IllegalArgumentException("Illegal opcode.");
            }
        }
        return instructions;
    }

    public int[] findOutput(int target, int[] instructions) {
        int[] instructionsClone = instructions.clone();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++ ) {
                instructionsClone[1] = i;
                instructionsClone[2] = j;
                if (executeIntcode(instructionsClone)[0] == target) {
                    return new int[]{i, j};
                }
                instructionsClone = instructions.clone();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Intcode ic = new Intcode();
        int[] x = ic.findOutput(19690720, ic.readInput("inputs/intcode.txt"));
        System.out.println(x[0] * 100 + x[1]);
    }

}
