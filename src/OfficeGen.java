import java.util.Iterator;

public class OfficeGen {
    private final int id;
    // usableRooms >= 1
    // bspw. Flur oder Nassraum
    // sideRooms
    private final LinkedMapGen<String, Room> rooms;

    public OfficeGen(int id, LinkedMapGen<String, Room> rooms) {
        this.id = id;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public double getAreaOfAdjacentRooms() {
        double areaSideRooms = 0.0;
        for (LinkedMapGen<String, Room> currentNode = rooms; currentNode != null; currentNode = currentNode.getNext()) {
            if (currentNode.getValue().getUsageType().equals("sideRoom")) {
                areaSideRooms += currentNode.getValue().getLength() * currentNode.getValue().getWidth();
            }
        }
        return areaSideRooms;
    }

    public double totalArea() {
        double areaTotal = 0.0;
        for (LinkedMapGen<String, Room> currentNode = rooms; currentNode != null; currentNode = currentNode.getNext()) {
                areaTotal += currentNode.getValue().getLength() * currentNode.getValue().getWidth();
        }
        return areaTotal;
    }

    public void addRoom(Room room, String usageType) {
        String roomId = room.getName();

        // If roomName already present in Building => error, sma room can't exist twice
        if(rooms.get(roomId) != null) return;

        // Else Add room
        room.setUsageType(usageType);
        rooms.put(roomId, room);

    }

    public boolean removeRoom(Room room) {
        String roomId = room.getName();

        if(rooms.get(roomId) == null) return false;
        rooms.remove(roomId);
        return true;
    }

    // Ändern der Informationen von Räumen wie oben beschrieben
    // TODO is der Parameter für usage ein String?
    public void changeRoomUsage (String nameRoom, String newUsage) {
        Room room = rooms.get(nameRoom);
        if (room != null) {
            room.setUsageType(newUsage);
        }
    }

    // Methoden zum Berechnen folgender (statistischer) Werte:
    // ...
    public double averageAreaRoom() {
        int len = 0;
        double result = 0.0;

        Iterator<Room> rooms = this.rooms.getValues();
        while(rooms.hasNext()){
            Room room = rooms.next();
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

        Iterator<Room> rooms = this.rooms.getValues();
        while(rooms.hasNext()){
            Room room = rooms.next();
            if(room.getUsageType().equals(UsageType.STORAGE_SPACE)){
                result+=room.getVolume();
                len++;
            }
        }

        if(len == 0) return 0;

        result/=len;
        return result;
    }

    public double averageNumberOfWorkspaces() {

        return 0.0;
    }

    public <RoomType> double averageRatioWindowToArea() {
        return 0.0;
    }

    public <RoomType> double averageRatioLuminousFluxToArea() {
        return 0.0;
    }

}
