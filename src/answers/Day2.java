package answers;

import code.Intcode;

public class Day2 {
    public static void main(String[] args) {
        Intcode ic = new Intcode();
        System.out.println("Day 2 part 1, value at position 0: " + ic.executeIntcode("inputs/intcode.txt")[0]);
    }
}
