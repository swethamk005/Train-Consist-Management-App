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
}

public class TrainConsistManagement {
    public static void main(String[] args) {
        // Create a large list of passenger bogies
        List<PassengerBogie> bogies = new ArrayList<>();

        for (int i = 1; i <= 100000; i++) {
            bogies.add(new PassengerBogie("BG" + i, "Sleeper", (i % 100) + 20));
        }

        // -------------------------------
        // Loop-based filtering performance
        // -------------------------------
        long loopStart = System.nanoTime();

        List<PassengerBogie> loopFiltered = new ArrayList<>();
        for (PassengerBogie bogie : bogies) {
            if (bogie.getSeatCapacity() >= 60) {
                loopFiltered.add(bogie);
            }
        }

        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;

        // -------------------------------
        // Stream-based filtering performance
        // -------------------------------
        long streamStart = System.nanoTime();

        List<PassengerBogie> streamFiltered = bogies.stream()
                .filter(bogie -> bogie.getSeatCapacity() >= 60)
                .toList();

        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;

        // Display results
        System.out.println("=== PERFORMANCE COMPARISON: LOOP VS STREAM ===");
        System.out.println("Loop-based filtering time   : " + loopTime + " ns");
        System.out.println("Stream-based filtering time : " + streamTime + " ns");

        System.out.println("\n=== FILTER RESULT CHECK ===");
        System.out.println("Loop filtered bogies count   : " + loopFiltered.size());
        System.out.println("Stream filtered bogies count : " + streamFiltered.size());
    }
}