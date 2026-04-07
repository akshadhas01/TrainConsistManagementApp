import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== UC20: Exception Handling During Search ===");

        // ---- Create bogie array ----
        // Case 1: EMPTY (to test exception)
        String[] bogieIds = {};

        // Case 2: Uncomment to test normal flow
        // String[] bogieIds = {"BG101", "BG205", "BG309"};

        String searchId = "BG101";

        try {

            // ---- FAIL-FAST VALIDATION ----
            if (bogieIds.length == 0) {
                throw new IllegalStateException("No bogies available in train. Cannot perform search.");
            }

            // ---- SEARCH LOGIC ----
            boolean found = false;

            for (String id : bogieIds) {
                if (id.equals(searchId)) {
                    found = true;
                    break;
                }
            }

            // ---- RESULT ----
            if (found) {
                System.out.println("Bogie Found: " + searchId);
            } else {
                System.out.println("Bogie NOT Found: " + searchId);
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("UC20 execution completed...");
    }
}