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

    // UC15: Safe cargo assignment
    void assignCargo(String cargo) {
        try {
            // RULE: Rectangular cannot carry Petroleum
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

    public String toString() {
        return shape + " -> " + cargo;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        try {

            // ===== UC1 =====
            System.out.println("=== Train Consist Management App ===");
            List<String> trainConsist = new ArrayList<>();
            System.out.println("Initial Bogie Count: " + trainConsist.size());

            // ===== UC2 =====
            List<String> passenger = new ArrayList<>();
            passenger.add("Sleeper");
            passenger.add("AC Chair");

            // ===== UC3 =====
            Set<String> ids = new HashSet<>();
            ids.add("BG101");
            ids.add("BG101");

            // ===== UC4 =====
            List<String> list = new LinkedList<>();
            list.add("Engine");
            list.add("Sleeper");

            // ===== UC5 =====
            Set<String> set = new LinkedHashSet<>();
            set.add("Engine");
            set.add("Engine");

            // ===== UC6 =====
            Map<String, Integer> map = new HashMap<>();
            map.put("Sleeper", 72);

            // ===== UC7 =====
            List<Bogie> bogieList = new ArrayList<>();
            bogieList.add(new Bogie("Sleeper", 72));
            bogieList.add(new Bogie("AC Chair", 56));

            // ===== UC8 =====
            List<Bogie> filtered = bogieList.stream()
                    .filter(b -> b.capacity > 50)
                    .collect(Collectors.toList());

            // ===== UC9 =====
            Map<String, List<Bogie>> grouped =
                    bogieList.stream().collect(Collectors.groupingBy(b -> b.name));

            // ===== UC10 =====
            int total = bogieList.stream()
                    .map(b -> b.capacity)
                    .reduce(0, Integer::sum);

            // ===== UC11 =====
            if (Pattern.matches("TRN-\\d{4}", "TRN-1234")) {
                System.out.println("Valid Train ID");
            }

            // ===== UC12 =====
            List<GoodsBogie> goods = new ArrayList<>();
            goods.add(new GoodsBogie("Cylindrical"));
            goods.add(new GoodsBogie("Rectangular"));

            // ===== UC13 =====
            long start = System.nanoTime();
            for (Bogie b : bogieList) {
                if (b.capacity > 50) {}
            }
            long end = System.nanoTime();

            // ===== UC14 =====
            Bogie valid = new Bogie("First Class", 24);
            System.out.println("Created: " + valid);

            // ===== UC15 =====
            System.out.println("\n=== UC15: Safe Cargo Assignment ===");

            GoodsBogie g1 = new GoodsBogie("Cylindrical");
            g1.assignCargo("Petroleum");   // SAFE

            GoodsBogie g2 = new GoodsBogie("Rectangular");
            g2.assignCargo("Petroleum");   // UNSAFE

            System.out.println("\nUC15 runtime handling completed...");

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}