import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagement {
    public static void main(String[] args) {
        // LinkedHashSet stores unique bogie IDs in insertion order
        Set<String> bogieIds = new LinkedHashSet<>();

        // Adding bogie IDs
        System.out.println("=== ADDING BOGIE IDS ===");
        addBogieId(bogieIds, "BG101");
        addBogieId(bogieIds, "BG103");
        addBogieId(bogieIds, "BG102");
        addBogieId(bogieIds, "BG105");

        // Attempting to add duplicate bogie ID
        System.out.println("\n=== ADDING DUPLICATE BOGIE ID ===");
        addBogieId(bogieIds, "BG103");

        // Display bogie IDs in insertion order
        System.out.println("\n=== BOGIE IDS IN INSERTION ORDER ===");
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

    // Method to display all bogie IDs in insertion order
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