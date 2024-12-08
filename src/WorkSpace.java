public class WorkSpace implements Space, UsableSpace {
    int workStations;
    public WorkSpace(int workStations){
        this.workStations = workStations;
    }

    public int workStations(){return this.workStations;}
}
