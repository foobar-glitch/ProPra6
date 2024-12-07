public class WorkSpace implements Space, UsableSpace {
    double workStations;
    public WorkSpace(double workStations){
        this.workStations = workStations;
    }

    public double workStations(){return this.workStations;}
}
