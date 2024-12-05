// String name
// double length
// double width
// ggf. double window area
// ggf. double luminous flux

public interface Room {
    String getName();
    double getLength();
    double getWidth();
    void setUsageType(String usageType);
    String getUsageType();
    double getArea();
    double getVolume();
}
/*
public interface Room {
    public String getName();
    public double getLength();
    public double getWidth();
    // TODO only for rooms with windows
    public double getWindowArea();
    // TODO only for rooms without windows
    public double getLuminousFlux();
    // TODO is der Parameter für newUsage ein String?
    public void setUsage(String newUsage);
    // TODO only for office space
    public int getNumberOfWorkspaces();
    // TODO only for storage room
    public double getStorageArea();

    public String getUsage();
}
*/