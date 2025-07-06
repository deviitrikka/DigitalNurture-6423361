package exercise6.ProxyPatternExample;

public class TestProxy {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("mountains.jpg");
        Image image2 = new ProxyImage("beach.png");

        // Image is loaded from remote server
        System.out.println("First display call for image1:");
        image1.display();

        // Cached image is used
        System.out.println("\nSecond display call for image1:");
        image1.display();

        // New image is loaded
        System.out.println("\nFirst display call for image2:");
        image2.display();
    }
}
