package exercise3.BuilderPatternExample;

public class Computer {
    // Required attributes
    private final String CPU;
    private final String RAM;

    // Optional attributes
    private final String storage;
    private final String graphicsCard;
    private final String operatingSystem;

    // Private constructor to enforce usage of Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.operatingSystem = builder.operatingSystem;
    }

    // Static nested Builder class
    public static class Builder {
        // Required
        private final String CPU;
        private final String RAM;

        // Optional
        private String storage;
        private String graphicsCard;
        private String operatingSystem;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setOperatingSystem(String os) {
            this.operatingSystem = os;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    // For displaying computer configuration
    @Override
    public String toString() {
        return "Computer Configuration:\n" +
                "CPU: " + CPU + "\n" +
                "RAM: " + RAM + "\n" +
                "Storage: " + (storage != null ? storage : "Not specified") + "\n" +
                "Graphics Card: " + (graphicsCard != null ? graphicsCard : "Not specified") + "\n" +
                "Operating System: " + (operatingSystem != null ? operatingSystem : "Not specified");
    }
}
