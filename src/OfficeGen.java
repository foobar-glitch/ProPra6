import java.util.Iterator;

public class OfficeGen {
    private final int id;
    // usableRooms >= 1
    // bspw. Flur oder Nassraum
    // sideRooms
    private final LinkedMapGen<String, Space> rooms;

    public OfficeGen(int id, LinkedMapGen<String, Space> rooms) {
        this.id = id;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public double getAreaOfAdjacentRooms() {
        double areaSideRooms = 0.0;
        for (LinkedMapGen<String, Space> currentNode = rooms; currentNode != null; currentNode = currentNode.getNext()) {
            Room room = currentNode.getValue().room();
            if (!(room instanceof UsableRoom)) {
                areaSideRooms += room.getLength() * room.getWidth();
            }
        }
        return areaSideRooms;
    }

    public double totalArea() {
        double areaTotal = 0.0;
        for (LinkedMapGen<String, Space> currentNode = rooms; currentNode != null; currentNode = currentNode.getNext()) {
            Room room = currentNode.getValue().room();
            areaTotal += room.getLength() * room.getWidth();
        }
        return areaTotal;
    }

    public void addRoom(Space space) {
        Room room = space.room();
        String roomId = room.getName();

        // If roomName already present in Building => error, sma room can't exist twice
        if(rooms.get(roomId) != null) return;

        // Else Add room
        rooms.put(roomId, space);

    }

    public boolean removeRoom(Space space) {
        Room room = space.room();
        String roomId = room.getName();

        if(rooms.get(roomId) == null) return false;
        rooms.remove(roomId);
        return true;
    }

    /**
     * @param space New Space with same Room but in different Space.Class, f.ex.:
     *              Room room = new Room();
     *              Space space1 = WorkSpace(room, people);
     *              this.addRoom(space1);
     *              Space space2 = StorageSpace(room, volume);
     *              this.changeRoomUsage(space2)
     *              => Now, RoomUsage is changed from WorkSpace to Storage
     */
    public void changeRoomUsage (Space space) {
        Room room = space.room();
        if (rooms.get(room.getName()) != null) {
            rooms.put(room.getName(), space);
        }
    }

    // Methoden zum Berechnen folgender (statistischer) Werte:
    // ...
    public double averageAreaRoom() {
        int len = 0;
        double result = 0.0;

        Iterator<Space> rooms = this.rooms.getValues();
        while(rooms.hasNext()){
            Room room = rooms.next().room();
            result += room.getArea();
            len++;
        }

        if(len == 0) return 0;

        result/=len;
        return result;
    }

    public double averageAreaRoomsWithWindows() {
        return 0.0;
    }

    public double averageAreaRoomsNoWindows() {
        return 0.0;
    }

    public double averageVolumeStorageRooms() {
        int len = 0;
        double result = 0.0;

        Iterator<Space> rooms = this.rooms.getValues();
        while(rooms.hasNext()){
            Room room = rooms.next().room();
            if(room instanceof StorageSpace){
                StorageSpace storage = (StorageSpace) room;
                result+=storage.volume();
                len++;
            }
        }

        if(len == 0) return 0;

        result/=len;
        return result;
    }

    public double averageNumberOfWorkspaces() {
        int len=0;
        double result=0.0;

        Iterator<Space> spaces = rooms.getValues();
        while(spaces.hasNext()){
            Room room = spaces.next().room();
            if(room instanceof WorkSpace){
                WorkSpace workSpace = (WorkSpace) room;
                result+=workSpace.workStations();
                len++;
            }
        }

        if(len == 0) return 0;

        return result / len;
    }

    public <RoomType> double averageRatioWindowToArea() {
        return 0.0;
    }

    public <RoomType> double averageRatioLuminousFluxToArea() {
        return 0.0;
    }

}
