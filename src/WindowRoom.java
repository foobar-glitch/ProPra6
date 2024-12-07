public class WindowRoom implements Room {
    private final String name;
    private final double length, width, windowArea;
    private Space space;

    public WindowRoom(String name, double length, double width, double windowArea, Space space) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.windowArea = windowArea;
        this.space = space;
    }

    @Override
    public String getName() { return name; }

    @Override
    public double getLength() { return length; }

    @Override
    public double getWidth() { return width; }

    @Override
    public double getArea() { return length * width; }

    @Override
    public Space space() {
        return this.space;
    }

    @Override
    public void setSpace(Space space) {
        this.space = space;
    }

    public double getWindowArea() { return windowArea; }
}
