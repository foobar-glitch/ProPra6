// Generisch nutze room gen mit genertischen datentypen für nicht generich nutze normal room UND
// Normal LinkedMap... Würde das so nicht sinn ergeben?
public class OfficeGen<K, V extends RoomGen<K, V>> implements ContainerInterface<Integer> {
    private final int id;
    private final LinkedMapGen<K, V> rooms;

    // TODO constructor soll laut Aufgabenstellung auch eine double mit der Fläche der Nebenraeume setzten!!!
    public OfficeGen(int id, LinkedMapGen<K, V> rooms) {
        this.id = id;
        this.rooms = rooms;
    }

    public double totalArea() {
        double areaTotal = 0.0;
        Iterator<V> rooms = this.rooms.getValues();
        while(rooms.hasNext()){
            areaTotal+=rooms.next().getArea();
        }
        return areaTotal;
    }

    public void addRoom(V roomValue) {
        K roomName = roomValue.getName();
        // If roomName already present in Building => error, same room can't exist twice
        if(rooms.get(roomName) != null) return;

        // Else Add room
        rooms.put(roomName, roomValue);

    }

    public boolean removeRoom(V roomValue) {
        K roomName = roomValue.getName();
        if(rooms.get(roomName) == null) return false;
        rooms.remove(roomName);
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
    public void changeRoomUsage (V roomValue, V newRoomValue) {
        V tmp = rooms.get(roomValue.getName());
        if (tmp != null) {
            tmp.setValue(newRoomValue);
        }
    }

    // Methoden zum Berechnen folgender (statistischer) Werte:
    // ...
    public double averageAreaRoom() {
        int len = 0;
        double result = 0.0;

        //Iterator<Room> rooms = this.rooms.getValues();
        LinkedMapGen<K, V> current = rooms;
        while(current != null){
            //Room room = rooms.next();
            V roomValue = rooms.getValue();
            if(roomValue.getValue() instanceof UsableSpace) {
                result += roomValue.getArea();
                len++;
            }
            current = current.getNext();
        }

        if(len == 0) return 0;

        result/=len;
        return result;
    }

    public double averageAreaRoomsWithWindows() {
        int len = 0;
        double result = 0.0;

        LinkedMapGen<K, V> current = rooms;
        while (current != null){
            V roomValue = rooms.getValue();
            if(roomValue.getValue() instanceof UsableSpace && roomValue instanceof WindowRoom wRoom){
                result+=wRoom.getArea();
                len++;
            }
            current = current.getNext();
        }


        if(len == 0) return 0;
        return result / len;
    }

    public double averageAreaRoomsNoWindows() {
        int len = 0;
        double result = 0.0;

        LinkedMapGen<K, V> current = rooms;
        while (current != null){
            V roomValue = rooms.getValue();
            if(roomValue.getValue() instanceof UsableSpace && roomValue instanceof WindowlessRoom wRoom){
                result+=wRoom.getArea();
                len++;
            }
            current = current.getNext();
        }

        if(len == 0) return 0;
        return result / len;
    }

    public double averageVolumeStorageRooms() {
        int len = 0;
        double result = 0.0;

        LinkedMapGen<K, V> current = rooms;
        while(current != null){
            V roomValue = rooms.getValue();
            if(roomValue.getValue() instanceof StorageSpace storage){
                result+=storage.volume();
                len++;
            }
            current = current.getNext();
        }

        if(len == 0) return 0;

        result/=len;
        return result;
    }

    public double averageNumberOfWorkspaces() {
        int len=0;
        double result=0.0;

        LinkedMapGen<K, V> current = rooms;
        while(current != null){
            V roomValue = rooms.getValue();
            if(roomValue.getValue() instanceof WorkSpace workSpace){
                result+=workSpace.workStations();
                len++;
            }
            current = current.getNext();
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


        LinkedMapGen<K, V> current = rooms;
        while(current != null){
            V room = current.getValue();
            V space = room.getValue();
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
            current = current.getNext();
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


        LinkedMapGen<K, V> current = rooms;
        while(current != null){
            //Room room = rooms.next();
            V room = rooms.getValue();
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
        Iterator<Room> rooms = this.rooms.getValues();
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

    @Override
    public Integer id() {
        return 0;
    }

    @Override
    public void print() {

    }
}


