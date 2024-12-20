public class Office implements ContainerInterface<Integer>{
    private final int id;
    private final RoomLinkedMap rooms;
    private final double adjacentRooms;

    public Office(int id, RoomLinkedMap rooms, double adjacentRooms) {
        this.id = id;
        this.rooms = rooms;
        this.adjacentRooms = adjacentRooms;
    }

    public int getId() {
        return id;
    }

    public double getAreaOfAdjacentRooms() {
        return adjacentRooms;
    }

    public double totalArea() {
        double areaTotal = adjacentRooms;
        RoomNodeListIterator rooms = this.rooms.getValues();
        while(rooms.hasNext()){
            Room currentRoom = rooms.next();
            if (currentRoom.space() instanceof UsableSpace) {
                areaTotal += currentRoom.getArea();
            }
        }
        return areaTotal;
    }

    public void addRoom(Room room) {
        String roomId = room.getName();

        // If roomName already present in Building => error, same room can't exist twice
        if(rooms.get(roomId) != null) return;

        // Else Add room
        rooms.put(roomId, room);

    }

    // for testing
    public boolean removeRoom(String name) {
        if(rooms.get(name) == null) return false;
        rooms.remove(name);
        return true;
    }

    /**
     * @param space New Space with same Room but in different Space.Class, f.ex.:
     *              Room room = new Room();
     *              Space space1 = WorkSpace(room, people);
     *              this.addRoom(space1);
     *              Space space2 = StorageSpace(room, volume);
     *              this.changeRoomUsage(space2)
     *              => Now, RoomUsage is changed from WorkSpace to Storage
     */
    public void changeRoomUsage (Room room, Space space) {
        Room tmp = rooms.get(room.getName());
        if (tmp != null) {
            tmp.setSpace(space);
        }
    }

    // Methoden zum Berechnen folgender (statistischer) Werte:
    // ...
    public double averageAreaRoom() {
        int len = 0;
        double result = 0.0;

        RoomNodeListIterator rooms = this.rooms.getValues();
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

        RoomNodeListIterator rooms = this.rooms.getValues();
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

        RoomNodeListIterator rooms = this.rooms.getValues();
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

        RoomNodeListIterator rooms = this.rooms.getValues();
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

        RoomNodeListIterator rooms = this.rooms.getValues();
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


        RoomNodeListIterator rooms = this.rooms.getValues();
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


        RoomNodeListIterator rooms = this.rooms.getValues();
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
        RoomNodeListIterator rooms = this.rooms.getValues();
        while(rooms.hasNext()){
            Space space = rooms.next().space();
            if(space instanceof WorkSpace) result[0]++;
            else if(space instanceof StorageSpace) result[1]++;
            else result[2]++;
        }

        return result;
    }

    @Override
    public Integer id(){return id;}

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String allOneString = "Office with id: " + Integer.toString(id);
        allOneString += ("\n-------------------------");
        allOneString += "\n\tTotal Area: " + totalArea() + ", Area of Adjacent Rooms: " + getAreaOfAdjacentRooms();
        int[] numberOfSpaces = numberOfSpaces();
        allOneString += "\n\t" + "WorkSpaces: " + numberOfSpaces[0] + ", StorageSpaces: " + numberOfSpaces[1];

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

    public Room getRoom(String name) {
        return rooms.get(name);
    }
}
