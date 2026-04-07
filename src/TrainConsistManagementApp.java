import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

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

        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("After Adding: " + passengerBogies);

        // Remove bogie
        passengerBogies.remove("AC Chair");
        System.out.println("After Removing AC Chair: " + passengerBogies);

        // Check existence
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Sleeper bogie exists");
        }

        System.out.println("Final Passenger Bogies: " + passengerBogies);


        // ===== UC3 =====
        System.out.println("\n=== UC3: Track Unique Bogie IDs ===");

        // Create HashSet (no duplicates allowed)
        Set<String> bogies = new HashSet<>();

        // Add IDs (including duplicates)
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");

        // Duplicate entries (ignored automatically)
        bogies.add("BG101");
        bogies.add("BG102");

        // Display result
        System.out.println("Bogie IDs After Insertion: " + bogies);

        System.out.println("Note: Duplicates are automatically ignored by HashSet.");
        System.out.println("UC3 uniqueness validation completed...");
    }
}