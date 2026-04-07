import java.util.*;   // ✅ This single line avoids all import errors

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

        bogies.add("BG101"); // duplicate
        bogies.add("BG102"); // duplicate

        System.out.println("Bogie IDs After Insertion: " + bogies);
        System.out.println("Note: Duplicates are automatically ignored by HashSet.");
        System.out.println("UC3 uniqueness validation completed...");


        // ===== UC4 =====
        System.out.println("\n=== UC4: Maintain Ordered Bogie Consist ===");

        List<String> orderedTrain = new LinkedList<>();

        orderedTrain.add("Engine");
        orderedTrain.add("Sleeper");
        orderedTrain.add("AC");
        orderedTrain.add("Cargo");
        orderedTrain.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(orderedTrain);

        orderedTrain.add(2, "Pantry Car");

        System.out.println("\nAfter Inserting 'Pantry Car' at position 2:");
        System.out.println(orderedTrain);

        orderedTrain.remove(0);
        orderedTrain.remove(orderedTrain.size() - 1);

        System.out.println("\nAfter Removing First and Last Bogie:");
        System.out.println(orderedTrain);

        System.out.println("UC4 ordered consist operations completed...");


        // ===== UC5 =====
        System.out.println("\n=== UC5: Preserve Insertion Order of Bogies ===");

        Set<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        formation.add("Sleeper"); // duplicate ignored

        System.out.println("Final Train Formation:");
        System.out.println(formation);

        System.out.println("\nNote: LinkedHashSet preserves insertion order and removes duplicates automatically.");
        System.out.println("UC5 formation setup completed...");


        // ===== UC6 =====
        System.out.println("\n=== UC6: Map Bogie to Capacity (HashMap) ===");

        Map<String, Integer> bogieCapacity = new HashMap<>();

        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 56);
        bogieCapacity.put("First Class", 24);
        bogieCapacity.put("Cargo", 120);

        System.out.println("Bogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed...");
    }
}