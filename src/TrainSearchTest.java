public class TrainSearchTest {
    public static void main(String[] args) {

        // 1. Exception when empty
        try {
            String[] arr = {};
            TrainConsistManagementApp.linearSearch(arr, "BG101");
            System.out.println("FAIL");
        } catch (IllegalStateException e) {
            System.out.println("PASS: Exception thrown");
        }

        // 2. Found case
        String[] arr1 = {"BG101", "BG205"};
        System.out.println(
                TrainConsistManagementApp.linearSearch(arr1, "BG101")
                        ? "PASS: Found"
                        : "FAIL"
        );

        // 3. Not found
        System.out.println(
                !TrainConsistManagementApp.linearSearch(arr1, "BG999")
                        ? "PASS: Not Found"
                        : "FAIL"
        );

        // 4. Single element
        String[] arr2 = {"BG101"};
        System.out.println(
                TrainConsistManagementApp.linearSearch(arr2, "BG101")
                        ? "PASS: Single works"
                        : "FAIL"
        );
    }
}