public class StorageSpace implements Space{

    private UsableRoom room;
    private double volume;

    public StorageSpace(UsableRoom room, double volume){
        this.room = room;
        this.volume = volume;
    }

    @Override
    public Room room() {
        return this.room;
    }

    public double volume(){return volume;}

}
