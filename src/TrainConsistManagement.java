import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagement {
    public static void main(String[] args) {
        // HashMap to store bogie ID and its capacity
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // Adding bogies with capacities
        System.out.println("=== ADDING BOGIES WITH CAPACITY ===");
        addBogie(bogieCapacityMap, "BG101", 72);   // Sleeper
        addBogie(bogieCapacityMap, "BG102", 60);   // AC Chair
        addBogie(bogieCapacityMap, "BG103", 24);   // First Class

        // Display all bogie-capacity mappings
        System.out.println("\n=== BOGIE CAPACITY DETAILS ===");
        displayBogieCapacities(bogieCapacityMap);

        // Lookup capacity of a specific bogie
        System.out.println("\n=== CHECKING CAPACITY OF A SPECIFIC BOGIE ===");
        String searchId = "BG102";
        if (bogieCapacityMap.containsKey(searchId)) {
            System.out.println("Bogie ID " + searchId + " has capacity: " + bogieCapacityMap.get(searchId));
        } else {
            System.out.println("Bogie ID " + searchId + " not found.");
        }
    }

    // Method to add bogie ID and capacity
    public static void addBogie(Map<String, Integer> bogieCapacityMap, String bogieId, int capacity) {
        bogieCapacityMap.put(bogieId, capacity);
        System.out.println("Bogie ID " + bogieId + " with capacity " + capacity + " added successfully.");
    }

    // Method to display all bogie-capacity mappings
    public static void displayBogieCapacities(Map<String, Integer> bogieCapacityMap) {
        if (bogieCapacityMap.isEmpty()) {
            System.out.println("No bogie capacity data found.");
        } else {
            for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
                System.out.println("Bogie ID: " + entry.getKey() + " | Capacity: " + entry.getValue());
            }
        }
    }
}