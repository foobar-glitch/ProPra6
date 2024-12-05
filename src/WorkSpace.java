public class WorkSpace implements Space{

    UsableRoom room;
    double workStations;
    public WorkSpace(UsableRoom room, double workStations){
        this.room = room;
        this.workStations = workStations;
    }

    @Override
    public Room room() {
        return this.room;
    }

    public double workStations(){return this.workStations;}
}
