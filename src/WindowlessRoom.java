public class WindowlessRoom implements Room {
    private final String name;
    private final double length, width, lightFlux;
    private String usageType;

    public WindowlessRoom(String name, double length, double width, double lightFlux) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.lightFlux = lightFlux;
    }

    @Override
    public String getName() { return name; }

    @Override
    public double getLength() { return length; }

    @Override
    public double getWidth() { return width; }

    @Override
    public void setUsageType(String usageType) { this.usageType = usageType; }

    @Override
    public String getUsageType() { return usageType; }

    @Override
    public double getArea() { return length * width; }

    public double getLightFlux() { return lightFlux; }
}