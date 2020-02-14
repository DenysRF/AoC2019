package answers;

import code.Fuel;

public class Day1 {
    public static void main(String[] args) {
        Fuel fuel = new Fuel();
        int totalFuel = fuel.TotalFuel("inputs/module_mass.txt");
        System.out.println("Day 1 part 1, sum of fuel requirements: " + totalFuel);

        int totalFuelOnFuel = fuel.TotalFuelOnFuel("inputs/module_mass.txt");
        System.out.println("Day 1 part 2, sum of fuel on fuel requirements: " + totalFuelOnFuel);
    }
}
