public class Office implements ContainerInterface<Integer>{
    private final int id;
    private final LinkedMapGen<String, Space> rooms;

    public Office(int id, LinkedMapGen<String, Space> rooms) {
        this.id = id;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public double getAreaOfAdjacentRooms() {
        double areaSideRooms = 0.0;
        for (LinkedMapGen<String, Space> currentNode = rooms; currentNode != null; currentNode = currentNode.getNext()) {
            Space space = currentNode.getValue();
            Room room = space.room();
            if (!(space instanceof UsableSpace)) {
                areaSideRooms += room.getLength() * room.getWidth();
            }
        }
        return areaSideRooms;
    }

    public double totalArea() {
        double areaTotal = 0.0;
        for (LinkedMapGen<String, Space> currentNode = rooms; currentNode != null; currentNode = currentNode.getNext()) {
            Room room = currentNode.getValue().room();
            areaTotal += room.getLength() * room.getWidth();
        }
        return areaTotal;
    }

    public void addRoom(Space space) {
        Room room = space.room();
        String roomId = room.getName();

        // If roomName already present in Building => error, same room can't exist twice
        if(rooms.get(roomId) != null) return;

        // Else Add room
        rooms.put(roomId, space);

    }

    public boolean removeRoom(Space space) {
        Room room = space.room();
        String roomId = room.getName();

        if(rooms.get(roomId) == null) return false;
        rooms.remove(roomId);
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
    public void changeRoomUsage (Space space) {
        Room room = space.room();
        if (rooms.get(room.getName()) != null) {
            rooms.put(room.getName(), space);
        }
    }

    // Methoden zum Berechnen folgender (statistischer) Werte:
    // ...
    public double averageAreaRoom() {
        int len = 0;
        double result = 0.0;

        Iterator<Space> spaces = this.rooms.getValues();
        while(spaces.hasNext()){
            Space space = spaces.next();
            Room room = space.room();
            if(space instanceof UsableSpace) {
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

        Iterator<Space> spaces = this.rooms.getValues();
        while (spaces.hasNext()){
            Space space = spaces.next();
            Room room = space.room();
            if(space instanceof UsableSpace && room instanceof WindowRoom){
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

        Iterator<Space> spaces = this.rooms.getValues();
        while (spaces.hasNext()){
            Space space = spaces.next();
            Room room = space.room();
            if(space instanceof UsableSpace && room instanceof WindowlessRoom){
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

        Iterator<Space> spaces = this.rooms.getValues();
        while(spaces.hasNext()){
            Space space = spaces.next();
            if(space instanceof StorageSpace){
                StorageSpace storage = (StorageSpace) space;
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

        Iterator<Space> spaces = rooms.getValues();
        while(spaces.hasNext()){
            Space space = spaces.next();
            if(space instanceof WorkSpace){
                WorkSpace workSpace = (WorkSpace) space;
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


        Iterator<Space> spaces = rooms.getValues();
        while(spaces.hasNext()){
            Space space = spaces.next();
            Room room = space.room();
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


        Iterator<Space> spaces = rooms.getValues();
        while(spaces.hasNext()){
            Space space = spaces.next();
            Room room = space.room();
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
        Iterator<Space> spaces = rooms.getValues();
        while(spaces.hasNext()){
            Space space = spaces.next();
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

    }

    @Override
    public String toString(){
        String result = "Total Area: " + totalArea();
        int[] numberOfSpaces = numberOfSpaces();
        result += "\n" + "WorkSpaces: " + numberOfSpaces[0] + ", StorageSpaces: " + numberOfSpaces[1] + ", AdjacentSpaces: " + numberOfSpaces[2];

        result +=   "\n" + "Average Area of Rooms: " + averageAreaRoom() + ", "
                    + "Average Area of Rooms with Windows: " + averageAreaRoomsWithWindows() + ", \n"
                    + "Average Area of Rooms without Windows: " + averageAreaRoomsNoWindows() + ", \n"
                    + "Average Volume of Storage Rooms: " + averageVolumeStorageRooms() + ", \n"
                    + "Average Number of Workspaces: " + averageNumberOfWorkspaces() + ", \n"
                    + "Average Window to Area Ratio: " + averageRatioWindowToArea()[0] + ", \n"
                    + "Average LuminousFlux to Area Ratio: " + averageRatioLuminousFluxToArea()[0]
        ;
        result+="\n";
        return result;
    }
}
