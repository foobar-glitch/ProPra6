public class OfficeGen<K, V extends Room> implements ContainerInterface<Integer> {
    private final int id;
    private final LinkedMapGen<K, V> rooms;

    // TODO constructor soll laut Aufgabenstellung auch eine double mit der Fläche der Nebenraeume setzten!!!
    public OfficeGen(int id, LinkedMapGen<K, V> rooms) {
        this.id = id;
        this.rooms = rooms;
    }

    public int getId() {return id;}

    public double getAreaOfAdjacentRooms() {
        double areaSideRooms = 0.0;
        Iterator<V> rooms = this.rooms.getValues();
        while(rooms.hasNext()){
            Room room = rooms.next();
            if(! (room.space() instanceof UsableSpace) ) areaSideRooms+=room.getArea();
        }
        return areaSideRooms;
    }


    @Override
    public Integer id() {
        return 0;
    }

    @Override
    public void print() {

    }

    public Room getOffice(K identifier) {
        return rooms.get(identifier);
    }

    public void removeOffice(K identifier) {
        rooms.remove(identifier);
    }
}


