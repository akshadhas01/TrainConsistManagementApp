import java.util.*;
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

// ===== Main Application =====
public class TrainConsistManagementApp {

    // ===== UC18: Linear Search =====
    public static boolean linearSearch(String[] bogieIds, String key) {
        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    // ===== UC19: Binary Search =====
    public static boolean binarySearch(String[] bogieIds, String key) {

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // safer mid calculation

            int cmp = key.compareTo(bogieIds[mid]);

            if (cmp == 0) {
                return true; // found
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            // ===== UC1 =====
            System.out.println("=== Train Consist Management App ===");
            List<String> trainConsist = new ArrayList<>();
            System.out.println("Initial Bogie Count: " + trainConsist.size());

            // ===== UC7 =====
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
            System.out.println("\n=== UC16: Bubble Sort ===");

            int[] capacities = {72, 56, 24, 70, 60};

            for (int i = 0; i < capacities.length - 1; i++) {
                for (int j = 0; j < capacities.length - 1 - i; j++) {
                    if (capacities[j] > capacities[j + 1]) {
                        int temp = capacities[j];
                        capacities[j] = capacities[j + 1];
                        capacities[j + 1] = temp;
                    }
                }
            }

            System.out.println("Sorted Capacities: " + Arrays.toString(capacities));

            // ===== UC17 =====
            System.out.println("\n=== UC17: Built-in Sorting ===");

            String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
            System.out.println("Before Sorting: " + Arrays.toString(bogieTypes));

            Arrays.sort(bogieTypes);

            System.out.println("After Sorting: " + Arrays.toString(bogieTypes));

            // ===== UC18 =====
            System.out.println("\n=== UC18: Linear Search ===");

            String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
            System.out.println("Bogie IDs: " + Arrays.toString(bogieIds));

            System.out.print("Enter Bogie ID to search (Linear): ");
            String searchKey = sc.nextLine();

            if (linearSearch(bogieIds, searchKey)) {
                System.out.println("FOUND using Linear Search");
            } else {
                System.out.println("NOT FOUND using Linear Search");
            }

            // ===== UC19 =====
            System.out.println("\n=== UC19: Binary Search ===");

            String[] bogieIdsBinary = {"BG309", "BG101", "BG550", "BG205", "BG412"};

            // IMPORTANT: sort first
            Arrays.sort(bogieIdsBinary);

            System.out.println("Sorted Bogie IDs: " + Arrays.toString(bogieIdsBinary));

            System.out.print("Enter Bogie ID to search (Binary): ");
            String key = sc.nextLine();

            if (binarySearch(bogieIdsBinary, key)) {
                System.out.println("FOUND using Binary Search");
            } else {
                System.out.println("NOT FOUND using Binary Search");
            }

            sc.close();

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}