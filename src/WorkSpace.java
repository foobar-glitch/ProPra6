public class WorkSpace implements Space, UsableRoom{

    Room room;
    double workStations;
    public WorkSpace(Room room, double workStations){
        this.room = room;
        this.workStations = workStations;
    }

    @Override
    public Room room() {
        return this.room;
    }

    public double workStations(){return this.workStations;}
}
