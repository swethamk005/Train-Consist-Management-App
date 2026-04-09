import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagement {
    public static void main(String[] args) {
        // HashSet to store unique bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Adding bogie IDs
        System.out.println("=== ADDING BOGIE IDS ===");

        addBogieId(bogieIds, "BG101");
        addBogieId(bogieIds, "BG102");
        addBogieId(bogieIds, "BG103");

        // Attempting to add a duplicate bogie ID
        System.out.println("\n=== ADDING DUPLICATE BOGIE ID ===");
        addBogieId(bogieIds, "BG101");

        // Display final unique bogie IDs
        System.out.println("\n=== UNIQUE BOGIE IDS IN TRAIN ===");
        displayBogieIds(bogieIds);
    }

    // Method to add bogie ID only if it is unique
    public static void addBogieId(Set<String> bogieIds, String bogieId) {
        if (bogieIds.add(bogieId)) {
            System.out.println("Bogie ID " + bogieId + " added successfully.");
        } else {
            System.out.println("Duplicate Bogie ID " + bogieId + " is not allowed.");
        }
    }

    // Method to display all unique bogie IDs
    public static void displayBogieIds(Set<String> bogieIds) {
        if (bogieIds.isEmpty()) {
            System.out.println("No bogie IDs found.");
        } else {
            for (String id : bogieIds) {
                System.out.println(id);
            }
        }
    }
}