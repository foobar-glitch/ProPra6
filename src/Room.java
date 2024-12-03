public interface Room {
    public String getName();
    public double getLength();
    public double getWidth();
    // TODO only for rooms with windows
    public double getWindowArea();
    // TODO only for rooms without windows
    public double getLuminousFlux();
    public void setUsage();
    // TODO only for office space
    public int getNumberOfWorkspaces();
    // TODO only for storage room
    public double getStorageArea();
}
