public class LinkedMap {
    private LinkedMap next;
    private String key;
    private Room value;

    public Room getValue() {
        return value;
    }

    /**
     * parameterless Constructor; creates empty node
     */
    public LinkedMap() {
        this.next = null;
        this.key = null;
        this.value = null;
    }

    public LinkedMap(String key, Room value) {
        this.next = null;
        this.key = key;
        this.value = value;
    }

    public LinkedMap getNext() {
        return next;
    };


    /**
     * Iteratively search for room for a given key
     *
     * @param roomName name of room to look up
     * @return Room containing the key; null if no room with the key is not found
     */
    private Room findRoom(String roomName){
        for(LinkedMap current = next; current != null; current = current.getNext()){
            if(current.key.equals(roomName)){
                return current.getValue();
            }
        }
        return null;
    }





}