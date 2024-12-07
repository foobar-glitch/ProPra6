public class WindowlessRoom implements Room {
    private final String name;
    private Space space;
    private final double length, width, lightFlux;

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

    public double getLightFlux() { return lightFlux; }

    @Override
    public Space space(){return this.space;}

    @Override
    public void setSpace(Space space){
        this.space = space;
    }
}