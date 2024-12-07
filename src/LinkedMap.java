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
    public Room findRoom(String roomName){
        for(LinkedMap current = next; current != null; current = current.getNext()){
            if(current.key.equals(roomName)){
                return current.getValue();
            }
        }
        return null;
    }



    /**
     * Search for room and overwrite it if the key is unused write at the end
     *
     * @param roomName Name of the room which is the key of the dictionary
     * @param room Room which is the value of the dictionary
     */
    public LinkedMap insertPair(String roomName, Room room) {
        // When room exists, overwrite
        LinkedMap current = this;

        // Traverse the list to check if the room already exists
        while (current != null) {
            if (current.key.equals(roomName)) {
                // If roomName exists, overwrite the value
                current.value = room;
                return current;
            }
            current = current.getNext();
        }

        // If the roomName doesn't exist, append a new node to the end
        // Traverse to the last node
        LinkedMap lastNode = this;
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }

        // Now append the new node
        lastNode.next = new LinkedMap(roomName, room);

        // Return the newly added node
        return lastNode.getNext(); // Return the newly appended node
    }

}