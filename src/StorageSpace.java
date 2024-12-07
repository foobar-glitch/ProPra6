public class StorageSpace implements Space, UsableSpace {

    private double volume;

    public StorageSpace(double volume){
        this.volume = volume;
    }

    public double volume(){return volume;}

}
