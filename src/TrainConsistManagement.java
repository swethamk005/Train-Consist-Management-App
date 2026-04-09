import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface SafetyRule {
    boolean isSafe(GoodsBogie bogie);
}

class GoodsBogie {
    private String bogieId;
    private String bogieShape;
    private String cargoType;

    public GoodsBogie(String bogieId, String bogieShape, String cargoType) {
        this.bogieId = bogieId;
        this.bogieShape = bogieShape;
        this.cargoType = cargoType;
    }

    public String getBogieId() {
        return bogieId;
    }

    public String getBogieShape() {
        return bogieShape;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void displayBogie() {
        System.out.println("Bogie ID    : " + bogieId);
        System.out.println("Bogie Shape : " + bogieShape);
        System.out.println("Cargo Type  : " + cargoType);
    }
}

public class TrainConsistManagement {
    public static void main(String[] args) {
        // Create a list of goods bogies
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        // Add goods bogies
        goodsBogies.add(new GoodsBogie("GB101", "Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("GB102", "Rectangular", "Coal"));
        goodsBogies.add(new GoodsBogie("GB103", "Cylindrical", "Coal"));      // Unsafe
        goodsBogies.add(new GoodsBogie("GB104", "Rectangular", "Cement"));

        // Functional interface implemented using lambda expression
        SafetyRule safetyCheck = bogie -> {
            if (bogie.getBogieShape().equalsIgnoreCase("Cylindrical")) {
                return bogie.getCargoType().equalsIgnoreCase("Petroleum");
            }
            return true; // Rectangular bogies are safe for general cargo
        };

        // Display safety compliance results
        System.out.println("=== GOODS BOGIE SAFETY COMPLIANCE CHECK ===");

        goodsBogies.stream().forEach(bogie -> {
            bogie.displayBogie();
            System.out.println("Safety Status: " + (safetyCheck.isSafe(bogie) ? "SAFE" : "UNSAFE"));
            System.out.println("--------------------------");
        });
    }
}