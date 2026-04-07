import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

// ===== Bogie Class =====
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String toString() {
        return name + " -> " + capacity;
    }
}

// ===== Goods Bogie Class (UC12) =====
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

        // ===== UC1 =====
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count: " + trainConsist.size());
        System.out.println("Current Train Consist: " + trainConsist);
        System.out.println("System ready for operations....");


        // ===== UC2 =====
        System.out.println("\n=== UC2: Add Passenger Bogies ===");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        passengerBogies.remove("AC Chair");

        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Sleeper bogie exists");
        }


        // ===== UC3 =====
        System.out.println("\n=== UC3: Unique Bogie IDs ===");

        Set<String> bogies = new HashSet<>();

        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG101");

        System.out.println(bogies);


        // ===== UC4 =====
        System.out.println("\n=== UC4: Ordered Train ===");

        List<String> ordered = new LinkedList<>();

        ordered.add("Engine");
        ordered.add("Sleeper");
        ordered.add("Cargo");
        ordered.add("Guard");

        ordered.add(2, "Pantry");
        ordered.remove(0);
        ordered.remove(ordered.size() - 1);

        System.out.println(ordered);


        // ===== UC5 =====
        System.out.println("\n=== UC5: LinkedHashSet ===");

        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Sleeper");

        System.out.println(formation);


        // ===== UC6 =====
        System.out.println("\n=== UC6: HashMap ===");

        Map<String, Integer> map = new HashMap<>();
        map.put("Sleeper", 72);
        map.put("AC Chair", 56);

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }


        // ===== UC7 =====
        System.out.println("\n=== UC7: Sorting ===");

        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));

        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        for (Bogie b : bogieList) {
            System.out.println(b);
        }


        // ===== UC8 =====
        System.out.println("\n=== UC8: Filter ===");

        List<Bogie> filtered = bogieList.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());

        for (Bogie b : filtered) {
            System.out.println(b);
        }


        // ===== UC9 =====
        System.out.println("\n=== UC9: Grouping ===");

        Map<String, List<Bogie>> grouped =
                bogieList.stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        System.out.println(grouped);


        // ===== UC10 =====
        System.out.println("\n=== UC10: Total Capacity ===");

        int total = bogieList.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("Total: " + total);


        // ===== UC11 =====
        System.out.println("\n=== UC11: Regex Validation ===");

        String trainId = "TRN-1234";
        Pattern p = Pattern.compile("TRN-\\d{4}");

        if (p.matcher(trainId).matches()) {
            System.out.println("Valid Train ID");
        }


        // ===== UC12 =====
        System.out.println("\n=== UC12: Safety Compliance Check ===");

        List<GoodsBogie> goods = new ArrayList<>();

        goods.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goods.add(new GoodsBogie("Open", "Coal"));
        goods.add(new GoodsBogie("Box", "Grain"));
        goods.add(new GoodsBogie("Cylindrical", "Petroleum")); // valid

        System.out.println("Goods Bogies:");
        for (GoodsBogie g : goods) {
            System.out.println(g);
        }

        // Safety Rule:
        // Cylindrical → ONLY Petroleum
        boolean isSafe = goods.stream()
                .allMatch(g ->
                        !g.type.equals("Cylindrical") ||
                                g.cargo.equals("Petroleum")
                );

        if (isSafe) {
            System.out.println("\nTrain is SAFETY COMPLIANT ✅");
        } else {
            System.out.println("\nTrain is NOT SAFE ❌");
        }

        System.out.println("\nUC12 completed...");
    }
}