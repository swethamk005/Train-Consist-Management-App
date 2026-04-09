import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Bogie {
    private String bogieId;
    private String bogieType;
    private int capacity;

    public Bogie(String bogieId, String bogieType, int capacity) {
        this.bogieId = bogieId;
        this.bogieType = bogieType;
        this.capacity = capacity;
    }

    public String getBogieId() {
        return bogieId;
    }

    public String getBogieType() {
        return bogieType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void displayBogie() {
        System.out.println("Bogie ID   : " + bogieId);
        System.out.println("Bogie Type : " + bogieType);
        System.out.println("Capacity   : " + capacity);
    }
}

public class TrainConsistManagement {
    public static void main(String[] args) {
        // Create a list of bogies
        List<Bogie> bogies = new ArrayList<>();

        // Add bogies
        bogies.add(new Bogie("BG101", "Sleeper", 72));
        bogies.add(new Bogie("BG102", "AC Chair", 56));
        bogies.add(new Bogie("BG103", "First Class", 24));
        bogies.add(new Bogie("BG104", "Sleeper", 72));
        bogies.add(new Bogie("BG105", "AC Chair", 56));

        // Group bogies by type using Collectors.groupingBy()
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getBogieType));

        // Display grouped bogies
        System.out.println("=== GROUPED BOGIES BY TYPE ===");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nBogie Type: " + entry.getKey());

            for (Bogie bogie : entry.getValue()) {
                bogie.displayBogie();
                System.out.println("----------------------");
            }
        }
    }
}