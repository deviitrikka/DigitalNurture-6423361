package exercise6.ProxyPatternExample;

public class ProxyImage implements Image {
    private final String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);  // Lazy initialization
        } else {
            System.out.println("Image already loaded, using cache: " + filename);
        }
        realImage.display();
    }
}
