import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

// ===== Custom Exception (UC14) =====
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
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
    String type;
    String cargo;

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String toString() {
        return type + " -> " + cargo;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        try {

            // ===== UC1 =====
            System.out.println("=== Train Consist Management App ===");
            List<String> trainConsist = new ArrayList<>();
            System.out.println("Train initialized successfully...");
            System.out.println("Initial Bogie Count: " + trainConsist.size());


            // ===== UC2 =====
            List<String> passengerBogies = new ArrayList<>();
            passengerBogies.add("Sleeper");
            passengerBogies.add("AC Chair");


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
            bogieList.add(new Bogie("First Class", 24));


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
            goods.add(new GoodsBogie("Cylindrical", "Petroleum"));
            goods.add(new GoodsBogie("Open", "Coal"));

            boolean safe = goods.stream()
                    .allMatch(g -> !g.type.equals("Cylindrical") || g.cargo.equals("Petroleum"));

            System.out.println("Safety: " + safe);


            // ===== UC13 =====
            List<Bogie> bigList = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                bigList.add(new Bogie("Sleeper", i % 100));
            }

            long start = System.nanoTime();
            for (Bogie b : bigList) {
                if (b.capacity > 60) {}
            }
            long end = System.nanoTime();

            System.out.println("Loop Time: " + (end - start));


            // ===== UC14 =====
            System.out.println("\n=== UC14: Custom Exception Demo ===");

            // VALID CASE
            Bogie valid = new Bogie("Sleeper", 72);
            System.out.println("Created: " + valid);

            // INVALID CASE (will throw exception)
            Bogie invalid = new Bogie("AC Chair", -10);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}