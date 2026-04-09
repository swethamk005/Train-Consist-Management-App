import java.util.ArrayList;
import java.util.List;

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

public class TrainConsistManagement {
    public static void main(String[] args) {
        // Create a list of passenger bogies
        List<PassengerBogie> bogies = new ArrayList<>();

        // Add passenger bogies
        bogies.add(new PassengerBogie("BG101", "Sleeper", 72));
        bogies.add(new PassengerBogie("BG102", "AC Chair", 56));
        bogies.add(new PassengerBogie("BG103", "First Class", 24));
        bogies.add(new PassengerBogie("BG104", "Second Sitting", 90));

        // Display all bogies
        System.out.println("=== PASSENGER BOGIES IN TRAIN ===");
        for (PassengerBogie bogie : bogies) {
            bogie.displayBogie();
            System.out.println("--------------------------");
        }

        // Use reduce() to calculate total seating capacity
        int totalSeats = bogies.stream()
                .map(PassengerBogie::getSeatCapacity)
                .reduce(0, Integer::sum);

        // Display total seats
        System.out.println("\n=== TOTAL SEATING CAPACITY ===");
        System.out.println("Total Seats in Train: " + totalSeats);
    }
}