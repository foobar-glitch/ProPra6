public class WindowRoom implements Room {
    private final String name;
    private final double length, width, windowArea;
    private Space space;

    /**
     * Creates new Room with Window(s)
     * @param name name!=null, unique name of the Room
     * @param length length of the room (in meter)
     * @param width width of the room (in meter)
     * @param windowArea area of window (in m^2)
     * @param space space!=null, Element containing the Usage of the room (f.ex. StorageSpace f. Storage)
     */
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

    /**
     * @return WindowArea of this room (in m^2)
     */
    public double getWindowArea() { return windowArea; }
}
