public class OfficeGen<K, V extends Space> implements ContainerInterface<Integer> {
    private final int id;
    private final LinkedMapGen<K, V> rooms;

    public OfficeGen(int id, LinkedMapGen<K, V> rooms) {
        this.id = id;
        this.rooms = rooms;
    }

    public int getId() {return id;}

    public double getAreaOfAdjacentRooms() {
        double areaSideRooms = 0.0;
        V space;
        for (LinkedMapGen<K, V> currentNode = rooms; currentNode != null; currentNode = currentNode.getNext()) {
            space = currentNode.getValue();
            Room room = space.room();
            if (!(space instanceof UsableSpace)) {
                areaSideRooms += room.getLength() * room.getWidth();
            }
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
}


