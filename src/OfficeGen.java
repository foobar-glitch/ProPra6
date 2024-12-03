public class OfficeGen {
    int id;
    double areaOfAdjacentRooms;
    // usableRooms >= 1
    // unusableRooms

    public OfficeGen(int id, double areaOfAdjacentRooms) {
        this.id = id;
        this.areaOfAdjacentRooms = areaOfAdjacentRooms;
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

    // Methoden zum Berechnen folgender (statistischer) Werte:
    // ...
}
