public class StorageSpace implements Space, UsableSpace {

    private final double volume;

    /**
     * Creates new object of this
     * @param volume volume >= 0, volume of Storage Space (in m^3)
     */
    public StorageSpace(double volume){
        this.volume = volume;
    }

    /**
     * @return Volume of room (in m^3)
     */
    public double volume(){return volume;}

}
