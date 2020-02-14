package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fuel {

    private int CalculateFuel(int mass) {
        return (mass/3) - 2;
    }

    private int CalculateFuelOnFuel(int mass) {
        int total = 0;

        int fuel = (mass/3) - 2;
        if (fuel < 0) {
            return 0;
        } else {
            total += fuel;
            total += CalculateFuelOnFuel(fuel);
        }

        return total;
    }

    public int TotalFuel(String path) {
        int fuel = 0;
        try {
            File input = new File(path);
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                fuel += CalculateFuel(Integer.parseInt(scanner.nextLine()));
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fuel;
    }

    public int TotalFuelOnFuel(String path) {
        int fuel = 0;
        try {
            File input = new File(path);
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                fuel += CalculateFuelOnFuel(Integer.parseInt(scanner.nextLine()));
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fuel;
    }
}
