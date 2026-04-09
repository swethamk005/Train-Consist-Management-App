import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class PassengerBogie {
    private String bogieId;
    private String bogieType;
    private int seatCapacity;

    public PassengerBogie(String bogieId, String bogieType, int seatCapacity) {
        this.bogieId = bogieId;
        this.bogieType = bogieType;
        this.seatCapacity = seatCapacity;
    }

    public String getBogieId() {
        return bogieId;
    }

    public String getBogieType() {
        return bogieType;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void displayBogie() {
        System.out.println("Bogie ID      : " + bogieId);
        System.out.println("Bogie Type    : " + bogieType);
        System.out.println("Seat Capacity : " + seatCapacity);
    }
}

// Custom Comparator to sort bogies by seating capacity
class CapacityComparator implements Comparator<PassengerBogie> {
    @Override
    public int compare(PassengerBogie b1, PassengerBogie b2) {
        return Integer.compare(b1.getSeatCapacity(), b2.getSeatCapacity());
    }
}

public class TrainConsistManagement {
    public static void main(String[] args) {
        // Create a list of passenger bogies
        ArrayList<PassengerBogie> bogies = new ArrayList<>();

        // Add passenger bogies
        bogies.add(new PassengerBogie("BG101", "Sleeper", 72));
        bogies.add(new PassengerBogie("BG102", "AC Chair", 56));
        bogies.add(new PassengerBogie("BG103", "First Class", 24));
        bogies.add(new PassengerBogie("BG104", "Second Sitting", 90));

        // Display before sorting
        System.out.println("=== PASSENGER BOGIES BEFORE SORTING ===");
        displayBogies(bogies);

        // Sort bogies using custom Comparator
        Collections.sort(bogies, new CapacityComparator());

        // Display after sorting
        System.out.println("\n=== PASSENGER BOGIES SORTED BY SEATING CAPACITY ===");
        displayBogies(bogies);
    }

    // Method to display bogie details
    public static void displayBogies(ArrayList<PassengerBogie> bogies) {
        for (PassengerBogie bogie : bogies) {
            bogie.displayBogie();
            System.out.println("--------------------------");
        }
    }
}