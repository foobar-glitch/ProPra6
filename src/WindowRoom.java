public class WindowRoom implements Room {
    private final String name;
    private final double length, width, windowArea;

    public WindowRoom(String name, double length, double width, double windowArea) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.windowArea = windowArea;
    }

    @Override
    public String getName() { return name; }

    @Override
    public double getLength() { return length; }

    @Override
    public double getWidth() { return width; }

    @Override
    public double getArea() { return length * width; }

    public double getWindowArea() { return windowArea; }
}
