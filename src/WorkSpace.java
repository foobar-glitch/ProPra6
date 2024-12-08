public class WorkSpace implements Space, UsableSpace {
    private final int workStations;

    /**
     * Creates new object of this
     * @param workStations workStations >= 0, number of workStations in Room
     */
    public WorkSpace(int workStations){
        this.workStations = workStations;
    }

    /**
     * @return number of workStations in Room
     */
    public int workStations(){return this.workStations;}
}
