import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistManagement {

    // Method to validate Train ID
    public static boolean isValidTrainId(String trainId) {
        String trainIdPattern = "^TRN-\\d{4}$";
        Pattern pattern = Pattern.compile(trainIdPattern);
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    // Method to validate Cargo Code
    public static boolean isValidCargoCode(String cargoCode) {
        String cargoCodePattern = "^CG-[A-Z]{3}\\d{3}$";
        Pattern pattern = Pattern.compile(cargoCodePattern);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Sample Train IDs
        String trainId1 = "TRN-1234";
        String trainId2 = "TRAIN12";

        // Sample Cargo Codes
        String cargoCode1 = "CG-ABC123";
        String cargoCode2 = "CG-12AB34";

        // Validate Train IDs
        System.out.println("=== TRAIN ID VALIDATION ===");
        System.out.println(trainId1 + " -> " + (isValidTrainId(trainId1) ? "Valid" : "Invalid"));
        System.out.println(trainId2 + " -> " + (isValidTrainId(trainId2) ? "Valid" : "Invalid"));

        // Validate Cargo Codes
        System.out.println("\n=== CARGO CODE VALIDATION ===");
        System.out.println(cargoCode1 + " -> " + (isValidCargoCode(cargoCode1) ? "Valid" : "Invalid"));
        System.out.println(cargoCode2 + " -> " + (isValidCargoCode(cargoCode2) ? "Valid" : "Invalid"));
    }
}