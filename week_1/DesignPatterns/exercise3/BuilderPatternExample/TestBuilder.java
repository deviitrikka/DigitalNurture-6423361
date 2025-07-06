package exercise3.BuilderPatternExample;

public class TestBuilder {
    public static void main(String[] args) {
        // Build a basic computer
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
                .build();

        System.out.println("Basic Computer");
        System.out.println(basicComputer);
        System.out.println();

        // Build a gaming computer
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11 Pro")
                .build();

        System.out.println("Gaming Computer");
        System.out.println(gamingComputer);
        System.out.println();

        // Build a developer machine
        Computer devComputer = new Computer.Builder("AMD Ryzen 7", "16GB")
                .setStorage("512GB SSD")
                .setOperatingSystem("Ubuntu 24.04")
                .build();

        System.out.println( "Developer Machine");
        System.out.println(devComputer);
    }
}
