import java.util.SortedSet;
import java.util.TreeSet;

public class TrainConsistManagement {
    public static void main(String[] args) {
        // TreeSet stores unique bogie IDs in sorted order
        SortedSet<String> bogieIds = new TreeSet<>();

        // Adding bogie IDs
        System.out.println("=== ADDING BOGIE IDS ===");
        addBogieId(bogieIds, "BG105");
        addBogieId(bogieIds, "BG101");
        addBogieId(bogieIds, "BG103");
        addBogieId(bogieIds, "BG102");

        // Attempting to add duplicate bogie ID
        System.out.println("\n=== ADDING DUPLICATE BOGIE ID ===");
        addBogieId(bogieIds, "BG101");

        // Display sorted unique bogie IDs
        System.out.println("\n=== SORTED UNIQUE BOGIE IDS IN TRAIN ===");
        displayBogieIds(bogieIds);
    }

    // Method to add bogie ID only if it is unique
    public static void addBogieId(SortedSet<String> bogieIds, String bogieId) {
        if (bogieIds.add(bogieId)) {
            System.out.println("Bogie ID " + bogieId + " added successfully.");
        } else {
            System.out.println("Duplicate Bogie ID " + bogieId + " is not allowed.");
        }
    }

    // Method to display all bogie IDs in sorted order
    public static void displayBogieIds(SortedSet<String> bogieIds) {
        if (bogieIds.isEmpty()) {
            System.out.println("No bogie IDs found.");
        } else {
            for (String id : bogieIds) {
                System.out.println(id);
            }
        }
    }
}