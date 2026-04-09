import java.util.ArrayList;

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

class Train {
    private ArrayList<PassengerBogie> passengerBogies;

    public Train() {
        passengerBogies = new ArrayList<>();
    }

    // Add passenger bogie
    public void addPassengerBogie(PassengerBogie bogie) {
        if (checkBogieExists(bogie.getBogieId())) {
            System.out.println("Bogie with ID " + bogie.getBogieId() + " already exists.");
        } else {
            passengerBogies.add(bogie);
            System.out.println("Passenger bogie " + bogie.getBogieId() + " added successfully.");
        }
    }

    // Remove passenger bogie by ID
    public void removePassengerBogie(String bogieId) {
        for (int i = 0; i < passengerBogies.size(); i++) {
            if (passengerBogies.get(i).getBogieId().equalsIgnoreCase(bogieId)) {
                passengerBogies.remove(i);
                System.out.println("Passenger bogie " + bogieId + " removed successfully.");
                return;
            }
        }
        System.out.println("Passenger bogie " + bogieId + " not found.");
    }

    // Check if bogie exists
    public boolean checkBogieExists(String bogieId) {
        for (PassengerBogie bogie : passengerBogies) {
            if (bogie.getBogieId().equalsIgnoreCase(bogieId)) {
                return true;
            }
        }
        return false;
    }

    // Display all passenger bogies
    public void displayPassengerBogies() {
        if (passengerBogies.isEmpty()) {
            System.out.println("No passenger bogies attached.");
            return;
        }

        System.out.println("\nPassenger Bogies in Train:");
        for (PassengerBogie bogie : passengerBogies) {
            bogie.displayBogie();
            System.out.println("--------------------------");
        }
    }
}

public class TrainConsistManagement {
    public static void main(String[] args) {
        Train train = new Train();

        // Adding passenger bogies
        System.out.println("=== ADDING PASSENGER BOGIES ===");
        train.addPassengerBogie(new PassengerBogie("S1", "Sleeper", 72));
        train.addPassengerBogie(new PassengerBogie("A1", "AC Chair", 60));
        train.addPassengerBogie(new PassengerBogie("F1", "First Class", 24));

        // Display bogies after adding
        train.displayPassengerBogies();

        // Checking whether a bogie exists
        System.out.println("\n=== CHECKING BOGIE EXISTENCE ===");
        String searchId = "A1";
        if (train.checkBogieExists(searchId)) {
            System.out.println("Passenger bogie " + searchId + " exists in the train.");
        } else {
            System.out.println("Passenger bogie " + searchId + " does not exist in the train.");
        }

        // Removing a bogie
        System.out.println("\n=== REMOVING A PASSENGER BOGIE ===");
        train.removePassengerBogie("A1");

        // Display bogies after removal
        train.displayPassengerBogies();

        // Check again after removal
        System.out.println("\n=== CHECKING BOGIE EXISTENCE AFTER REMOVAL ===");
        if (train.checkBogieExists(searchId)) {
            System.out.println("Passenger bogie " + searchId + " exists in the train.");
        } else {
            System.out.println("Passenger bogie " + searchId + " does not exist in the train.");
        }
    }
}