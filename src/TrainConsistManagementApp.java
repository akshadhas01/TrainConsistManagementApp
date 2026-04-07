import java.util.*;

// ===== Custom Bogie Class =====
class Bogie {
    String name;
    int capacity;

    // Constructor
    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Display format
    public String toString() {
        return name + " -> " + capacity;
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

        System.out.println("After Adding: " + passengerBogies);

        passengerBogies.remove("AC Chair");
        System.out.println("After Removing AC Chair: " + passengerBogies);

        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Sleeper bogie exists");
        }

        System.out.println("Final Passenger Bogies: " + passengerBogies);


        // ===== UC3 =====
        System.out.println("\n=== UC3: Track Unique Bogie IDs ===");

        Set<String> bogies = new HashSet<>();

        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");

        bogies.add("BG101");
        bogies.add("BG102");

        System.out.println("Bogie IDs After Insertion: " + bogies);


        // ===== UC4 =====
        System.out.println("\n=== UC4: Maintain Ordered Bogie Consist ===");

        List<String> orderedTrain = new LinkedList<>();

        orderedTrain.add("Engine");
        orderedTrain.add("Sleeper");
        orderedTrain.add("AC");
        orderedTrain.add("Cargo");
        orderedTrain.add("Guard");

        System.out.println("Initial Train Consist: " + orderedTrain);

        orderedTrain.add(2, "Pantry Car");
        System.out.println("After Insert: " + orderedTrain);

        orderedTrain.remove(0);
        orderedTrain.remove(orderedTrain.size() - 1);
        System.out.println("After Removal: " + orderedTrain);


        // ===== UC5 =====
        System.out.println("\n=== UC5: Preserve Insertion Order ===");

        Set<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        System.out.println("Formation: " + formation);


        // ===== UC6 =====
        System.out.println("\n=== UC6: Map Bogie to Capacity ===");

        Map<String, Integer> map = new HashMap<>();

        map.put("Sleeper", 72);
        map.put("AC Chair", 56);
        map.put("First Class", 24);
        map.put("Cargo", 120);

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }


        // ===== UC7 =====
        System.out.println("\n=== UC7: Sort Bogies by Capacity ===");

        List<Bogie> bogieList = new ArrayList<>();

        // Add objects
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));

        // Before sorting
        System.out.println("Before Sorting:");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        // Sorting using Comparator (Lambda)
        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        // After sorting
        System.out.println("\nAfter Sorting by Capacity:");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        System.out.println("\nUC7 sorting completed...");
    }
}