package answers;

        import code.Intcode;

public class Day2 {
    public static void main(String[] args) {
        Intcode ic = new Intcode();
        int[] instructions = ic.readInput("inputs/intcode.txt");
        System.out.println("Day 2 part 1, value at position 0: " + ic.executeIntcode(instructions)[0]);

        int target = 19690720;
        int[] nounVerb = ic.findOutput(target, ic.readInput("inputs/intcode.txt"));
        System.out.println("Day 2 part 2, noun and verb that result in " + target +
                ": noun=" + nounVerb[0] + " verb=" + nounVerb[1] + ", 100 * noun + verb = " +
                (100 * nounVerb[0] + nounVerb[1]));
    }
}
