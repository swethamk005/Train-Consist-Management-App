
    class Engine {
        private String engineId;
        private String engineType;
        // Constructor to initialize engine details
        public Engine(String engineId, String engineType) {
            this.engineId = engineId;
            this.engineType = engineType;
        }
        // Method to return formatted engine details
        public String getEngineInfo() {
            return engineId + " (" + engineType + ")";
        }
    }
    class Train {
        private String trainId;
        private Engine engine;
        private int bogieCount;
        // Constructor to initialize train details
        public Train(String trainId, Engine engine) {
            this.trainId = trainId;
            this.engine = engine;
            this.bogieCount = 0; // Initially no bogies attached
        }
        // Method to display the initial train consist summary
        public void displayConsistSummary() {
            System.out.println("===== TRAIN CONSIST MANAGEMENT APP =====");
            System.out.println("Train ID        : " + trainId);
            System.out.println("Engine          : " + engine.getEngineInfo());
            System.out.println("Bogies Attached : " + bogieCount);
            System.out.println("Passenger Seats : 0");
            System.out.println("Goods Load      : 0");
            System.out.println("Cargo Types     : None");
            System.out.println("Safety Status   : SAFE");
            System.out.println();
            System.out.println("No bogies are currently attached to the train.");
        }
    }
    public class TrainConsistManagement {
        public static void main(String[] args) {
            // Initialize engine
            Engine engine = new Engine("E-5001", "Diesel Engine");
            // Initialize train with engine
            Train train = new Train("TC101", engine);
            // Display initial state of the train
            train.displayConsistSummary();

    }
}
