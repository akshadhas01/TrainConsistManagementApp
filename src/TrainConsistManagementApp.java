import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

// ===== Custom Exception (UC14) =====
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// ===== Custom Runtime Exception (UC15) =====
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// ===== Bogie Class =====
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.name = name;
        this.capacity = capacity;
    }

    public String toString() {
        return name + " -> " + capacity;
    }
}

// ===== Goods Bogie Class =====
class GoodsBogie {
    String shape;
    String cargo;

    GoodsBogie(String shape) {
        this.shape = shape;
    }

    void assignCargo(String cargo) {
        try {
            if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Unsafe cargo assignment!");
            }

            this.cargo = cargo;
            System.out.println("Cargo assigned successfully -> " + cargo);

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Cargo validation completed for " + shape + " bogie");
        }
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        try {

            // ===== UC1 =====
            System.out.println("=== Train Consist Management App ===");
            List<String> trainConsist = new ArrayList<>();
            System.out.println("Initial Bogie Count: " + trainConsist.size());

            // ===== UC7 sample data =====
            List<Bogie> bogieList = new ArrayList<>();
            bogieList.add(new Bogie("Sleeper", 72));
            bogieList.add(new Bogie("AC Chair", 56));
            bogieList.add(new Bogie("First Class", 24));

            // ===== UC10 =====
            int total = bogieList.stream()
                    .map(b -> b.capacity)
                    .reduce(0, Integer::sum);

            System.out.println("Total Capacity: " + total);

            // ===== UC11 =====
            if (Pattern.matches("TRN-\\d{4}", "TRN-1234")) {
                System.out.println("Valid Train ID");
            }

            // ===== UC15 =====
            System.out.println("\n=== UC15: Safe Cargo Assignment ===");

            GoodsBogie g1 = new GoodsBogie("Cylindrical");
            g1.assignCargo("Petroleum");

            GoodsBogie g2 = new GoodsBogie("Rectangular");
            g2.assignCargo("Petroleum");

            // ===== UC16 =====
            System.out.println("\n=== UC16: Manual Sorting using Bubble Sort ===");

            int[] capacities = {72, 56, 24, 70, 60};

            // Display original
            System.out.println("Original Capacities:");
            for (int c : capacities) {
                System.out.print(c + " ");
            }

            // ---- BUBBLE SORT ----
            for (int i = 0; i < capacities.length - 1; i++) {
                for (int j = 0; j < capacities.length - 1 - i; j++) {

                    if (capacities[j] > capacities[j + 1]) {
                        // swap
                        int temp = capacities[j];
                        capacities[j] = capacities[j + 1];
                        capacities[j + 1] = temp;
                    }
                }
            }

            // Display sorted
            System.out.println("\n\nSorted Capacities (Ascending):");
            for (int c : capacities) {
                System.out.print(c + " ");
            }

            System.out.println("\n\nUC16 sorting completed...");

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}