public class StorageSpace implements Space, UsableSpace {

    private Room room;
    private double volume;

    public StorageSpace(Room room, double volume){
        this.room = room;
        this.volume = volume;
    }

    @Override
    public Room room() {
        return this.room;
    }

    public double volume(){return volume;}

}
