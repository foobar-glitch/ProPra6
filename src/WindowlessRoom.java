public class WindowlessRoom implements Room {
    private final String name;
    private Space space;
    private final double length, width, lightFlux;

    /**
     * Creates new Room with No Window(s)
     * @param name name!=null, unique name of the Room
     * @param length length of the room (in meter)
     * @param width width of the room (in meter)
     * @param lightFlux lightFlux of artificial light in Room (in lumen)
     * @param space space!=null, Element containing the Usage of the room (f.ex. StorageSpace f. Storage)
     */
    public WindowlessRoom(String name, double length, double width, double lightFlux, Space space) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.lightFlux = lightFlux;
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
    public Space space(){return this.space;}

    @Override
    public void setSpace(Space space){
        this.space = space;
    }

    /**
     * @return lightFlux of artificial light in Room (in lumen)
     */
    public double getLightFlux() { return lightFlux; }
}