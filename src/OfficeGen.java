public class OfficeGen<K, V extends Room> implements ContainerInterface<Integer> {
    private final int id;
    private final LinkedMapGen<K, V> rooms;
    private final double adjacentRooms;

    public OfficeGen(int id, LinkedMapGen<K, V> rooms, double adjacentRooms) {
        this.id = id;
        this.rooms = rooms;
        this.adjacentRooms = adjacentRooms;
    }

    @Override
    public String toString() {
        String allOneString = "Office with id: " + Integer.toString(id);
        allOneString += ("\n-------------------------");
        allOneString += "\n\tTotal Area: " + totalArea();
        int[] numberOfSpaces = numberOfSpaces();
        allOneString += "\n\t" + "WorkSpaces: " + numberOfSpaces[0] + ", StorageSpaces: " + numberOfSpaces[1] + "Area of Adjacent Rooms: " + getAreaOfAdjacentRooms();

        allOneString +=   "\n\t" + "Average Area of Rooms: " + averageAreaRoom() + ", "
                + "\tAverage Area of Rooms with Windows: " + averageAreaRoomsWithWindows() + ", \n"
                + "\tAverage Area of Rooms without Windows: " + averageAreaRoomsNoWindows() + ", \n"
                + "\tAverage Volume of Storage Rooms: " + averageVolumeStorageRooms() + ", \n"
                + "\tAverage Number of Workspaces: " + averageNumberOfWorkspaces() + ", \n"
                + "\tAverage Window to Area Ratio: " + averageRatioWindowToArea()[0] + ", \n"
                + "\tAverage LuminousFlux to Area Ratio: " + averageRatioLuminousFluxToArea()[0]
        ;
        return allOneString.replace("\n", "\n\t");
    }

    public int getId() {return id;}

    public double getAreaOfAdjacentRooms() {
        return adjacentRooms;
    }


    @Override
    public Integer id() {
        return id;
    }

    @Override
    public void print() {

    }

    public void addRoom(K identifier, V room) {
        rooms.put(identifier, room);
    }

    public Room getRoom(K identifier) {
        return rooms.get(identifier);
    }

    public void removeRoom(K identifier) {
        rooms.remove(identifier);
    }

    public double totalArea() {
        double areaTotal = adjacentRooms;
        IteratorGen<V> rooms = this.rooms.getValues();
        while(rooms.hasNext()){
            Room currentRoom = rooms.next();
            if (currentRoom.space() instanceof UsableSpace) {
                areaTotal += currentRoom.getArea();
            }
        }
        return areaTotal;
    }

    // Methoden zum Berechnen folgender (statistischer) Werte:
    // ...
    public double averageAreaRoom() {
        int len = 0;
        double result = 0.0;

        IteratorGen<V>  rooms = this.rooms.getValues();
        while(rooms.hasNext()){
            Room room = rooms.next();
            if(room.space() instanceof UsableSpace) {
                result += room.getArea();
                len++;
            }
        }

        if(len == 0) return 0;

        result/=len;
        return result;
    }

    public double averageAreaRoomsWithWindows() {
        int len = 0;
        double result = 0.0;

        IteratorGen<V>  rooms = this.rooms.getValues();
        while (rooms.hasNext()){
            Room room = rooms.next();
            if(room.space() instanceof UsableSpace && room instanceof WindowRoom){
                WindowRoom wRoom = (WindowRoom) room;
                result+=wRoom.getArea();
                len++;
            }
        }

        if(len == 0) return 0;
        return result / len;
    }

    public double averageAreaRoomsNoWindows() {
        int len = 0;
        double result = 0.0;

        IteratorGen<V>  rooms = this.rooms.getValues();
        while (rooms.hasNext()){
            Room room = rooms.next();
            if(room.space() instanceof UsableSpace && room instanceof WindowlessRoom){
                WindowlessRoom wRoom = (WindowlessRoom) room;
                result+=wRoom.getArea();
                len++;
            }
        }

        if(len == 0) return 0;
        return result / len;
    }

    public double averageVolumeStorageRooms() {
        int len = 0;
        double result = 0.0;

        IteratorGen<V>  rooms = this.rooms.getValues();
        while(rooms.hasNext()){
            Room room = rooms.next();
            if(room.space() instanceof StorageSpace){
                StorageSpace storage = (StorageSpace) room.space();
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

        IteratorGen<V>  rooms = this.rooms.getValues();
        while(rooms.hasNext()){
            Room room = rooms.next();
            if(room.space() instanceof WorkSpace){
                WorkSpace workSpace = (WorkSpace) room.space();
                result+=workSpace.workStations();
                len++;
            }
        }

        if(len == 0) return 0;

        return result / len;
    }

    /**
     * @return  double[3]
     *          [0] average across all rooms
     *          [1] average across WorkingSpaces
     *          [2] average across StorageSpaces
     */
    public double[] averageRatioWindowToArea() {
        double workingArea=0.0;
        double wWindowArea=0.0;
        double storageArea=0.0;
        double sWindowArea=0.0;


        IteratorGen<V>  rooms = this.rooms.getValues();
        while(rooms.hasNext()){
            Room room = rooms.next();
            Space space = room.space();
            if(space instanceof UsableSpace){
                if(room instanceof WindowRoom){
                    if(space instanceof WorkSpace) {
                        workingArea += room.getArea();
                        wWindowArea += ((WindowRoom) room).getWindowArea();
                    }
                    else if(space instanceof StorageSpace){
                        storageArea += room.getArea();
                        sWindowArea += ((WindowRoom) room).getWindowArea();
                    }
                }
            }
        }

        if(workingArea == 0.0 && storageArea == 0.0) return new double[]{0,0,0};
        else if(workingArea == 0.0) return new double[]{(wWindowArea+sWindowArea)/storageArea, 0.0, sWindowArea/storageArea};
        else if(storageArea == 0.0) return new double[]{(wWindowArea+sWindowArea)/workingArea, wWindowArea/workingArea, 0.0};

        return new double[]{(wWindowArea+sWindowArea)/(storageArea+workingArea), wWindowArea/workingArea, sWindowArea/storageArea};
    }


    /**
     * @return  double[3]
     *          [0] average across all rooms
     *          [1] average across WorkingSpaces
     *          [2] average across StorageSpaces
     */
    public double[] averageRatioLuminousFluxToArea() {
        double workingArea=0.0;
        double wWindowArea=0.0;
        double storageArea=0.0;
        double sWindowArea=0.0;


        IteratorGen<V>  rooms = this.rooms.getValues();
        while(rooms.hasNext()){
            Room room = rooms.next();
            Space space = room.space();
            if(space instanceof UsableSpace){
                if(room instanceof WindowlessRoom){
                    if(space instanceof WorkSpace) {
                        workingArea += room.getArea();
                        wWindowArea += ((WindowlessRoom) room).getLightFlux();
                    }
                    else if(space instanceof StorageSpace){
                        storageArea += room.getArea();
                        sWindowArea += ((WindowlessRoom) room).getLightFlux();
                    }
                }
            }
        }

        if(workingArea == 0.0 && storageArea == 0.0) return new double[]{0,0,0};
        else if(workingArea == 0.0) return new double[]{(wWindowArea+sWindowArea)/storageArea, 0.0, sWindowArea/storageArea};
        else if(storageArea == 0.0) return new double[]{(wWindowArea+sWindowArea)/workingArea, wWindowArea/workingArea, 0.0};

        return new double[]{(wWindowArea+sWindowArea)/(storageArea+workingArea), wWindowArea/workingArea, sWindowArea/storageArea};
    }

    /**
     * @return [0] number of WorkSpaces; [1] number of StorageSpaces; [2] number of Useless Spaces
     */
    public int[] numberOfSpaces(){
        int[] result = new int[3];
        IteratorGen<V>  rooms = this.rooms.getValues();
        while(rooms.hasNext()){
            Space space = rooms.next().space();
            if(space instanceof WorkSpace) result[0]++;
            else if(space instanceof StorageSpace) result[1]++;
            else result[2]++;
        }

        return result;
    }

}


