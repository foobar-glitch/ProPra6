public class OfficeGen {
    int id;
    double areaOfAdjacentRooms;
    // usableRooms >= 1
    // bspw. Flur oder Nassraum
    // sideRooms
    LinkedMapGen<String, Room> rooms;

    public OfficeGen(int id, LinkedMapGen<String, Room> rooms) {
        this.id = id;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public double getAreaOfAdjacentRooms() {
        return areaOfAdjacentRooms;
    }

    public double totalArea() {
        // add area of usable rooms to this
        return areaOfAdjacentRooms;
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
            room.setUsage(newUsage);
        }
    }

    // Methoden zum Berechnen folgender (statistischer) Werte:
    // ...
}
