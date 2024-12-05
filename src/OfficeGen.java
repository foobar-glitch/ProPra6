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

    public void addRoom() {
        // how to add usable/unusable room? how to differenciate??
    }

    public void removeRoom() {
        // how to remove usable/unusable room? how to differenciate??
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
        return 0.0;
    }

    public double averageAreaRoomsWithWindows() {
        return 0.0;
    }

    public double averageAreaRoomsNoWindows() {
        return 0.0;
    }

    public double averageAreaStorageRooms() {
        return 0.0;
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
