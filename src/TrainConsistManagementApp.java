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

        // ===== UC1 =====
        System.out.println("=== Train Consist Management App ===");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count: " + trainConsist.size());
        System.out.println("Current Train Consist: " + trainConsist);
        System.out.println("System ready for operations....");


        // ===== UC2 =====
        System.out.println("\n=== UC2 ===");
        List<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        passengerBogies.remove("AC Chair");
        System.out.println(passengerBogies);


        // ===== UC3 =====
        System.out.println("\n=== UC3 ===");
        Set<String> ids = new HashSet<>();
        ids.add("BG101");
        ids.add("BG101");
        ids.add("BG102");
        System.out.println(ids);


        // ===== UC4 =====
        System.out.println("\n=== UC4 ===");
        List<String> list = new LinkedList<>();
        list.add("Engine");
        list.add("Sleeper");
        list.add("Cargo");
        list.add("Guard");
        list.add(2, "Pantry");
        list.remove(0);
        list.remove(list.size() - 1);
        System.out.println(list);


        // ===== UC5 =====
        System.out.println("\n=== UC5 ===");
        Set<String> set = new LinkedHashSet<>();
        set.add("Engine");
        set.add("Sleeper");
        set.add("Sleeper");
        System.out.println(set);


        // ===== UC6 =====
        System.out.println("\n=== UC6 ===");
        Map<String, Integer> map = new HashMap<>();
        map.put("Sleeper", 72);
        map.put("AC Chair", 56);
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }


        // ===== UC7 =====
        System.out.println("\n=== UC7 ===");
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.sort(Comparator.comparingInt(b -> b.capacity));
        for (Bogie b : bogieList) System.out.println(b);


        // ===== UC8 =====
        System.out.println("\n=== UC8 ===");
        List<Bogie> filtered = bogieList.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());
        for (Bogie b : filtered) System.out.println(b);


        // ===== UC9 =====
        System.out.println("\n=== UC9 ===");
        Map<String, List<Bogie>> grouped =
                bogieList.stream().collect(Collectors.groupingBy(b -> b.name));
        System.out.println(grouped);


        // ===== UC10 =====
        System.out.println("\n=== UC10 ===");
        int total = bogieList.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        System.out.println("Total Capacity: " + total);


        // ===== UC11 =====
        System.out.println("\n=== UC11 ===");
        String trainId = "TRN-1234";
        if (Pattern.matches("TRN-\\d{4}", trainId)) {
            System.out.println("Valid Train ID");
        }


        // ===== UC12 =====
        System.out.println("\n=== UC12 ===");
        List<GoodsBogie> goods = new ArrayList<>();
        goods.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goods.add(new GoodsBogie("Open", "Coal"));

        boolean safe = goods.stream()
                .allMatch(g -> !g.type.equals("Cylindrical") || g.cargo.equals("Petroleum"));

        System.out.println("Safety: " + safe);


        // ===== UC13 =====
        System.out.println("\n=== UC13: Performance Comparison ===");

        // Create large dataset
        List<Bogie> bigList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bigList.add(new Bogie("Sleeper", i % 100));
        }

        // LOOP APPROACH
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bigList) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // STREAM APPROACH
        long startStream = System.nanoTime();

        List<Bogie> streamResult = bigList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // Results
        System.out.println("Loop Time (ns): " + loopTime);
        System.out.println("Stream Time (ns): " + streamTime);
        System.out.println("Same Result Size: " + (loopResult.size() == streamResult.size()));

        System.out.println("\nUC13 completed...");
    }
}