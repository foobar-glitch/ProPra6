public class RoomLinkedMap {
    private RoomLinkedMap next;
    private String key;
    private Room value;

    public Room getValue() {
        return value;
    }

    /**
     * parameterless Constructor; creates empty node
     */
    public RoomLinkedMap() {
        this.next = null;
        this.key = null;
        this.value = null;
    }

    /**
     * Creates new "Node" of this with given key and value
     * @param key key!=null
     * @param value value!=null
     */
    private RoomLinkedMap(String key, Room value) {
        this.next = null;
        this.key = key;
        this.value = value;
    }

    /**
     * @return Next Node of this Or Null if this is last element
     */
    private RoomLinkedMap getNext() {
        return next;
    };


    /**
     * Iteratively search for room for a given key
     *
     * @param roomName roomName!=null, name of room to look up
     * @return Room containing the key; null if no room with the key is not found
     */
    public Room get(String roomName){
        RoomLinkedMap nodeWithKey = findNode(roomName);
        if (nodeWithKey != null) {
            return nodeWithKey.value;
        } else {
            return null;
        }
    }



    /**
     * Search for room and overwrite it if the key is unused write at the end
     *
     * @param roomName roomName!=null, Name of the room which is the key of the dictionary
     * @param room Room !=null, Room which is the value of the dictionary
     */
    public void insertPair(String roomName, Room room) {
        if ((this.key == null && this.value == null) || (this.key != null && this.key.equals(roomName))) {
            this.key = roomName;
            this.value = room;
        } else {
            if (next != null) {
                next.insertPair(roomName, room);
            } else {
                next = new RoomLinkedMap(roomName, room);
            }
        }
    }

    /**
     * adds mapping to this LinkedMap structure
     *
     * @param key key!=null, key of key-value pair to add
     * @param newValue newValue!=null, value of key-value pair to add
     * @return null if key was not already included; otherwise old value assigned to the key
     */
    public Room put(String key, Room newValue) {
        Room oldValue = get(key);
        insertPair(key, newValue);
        return oldValue;
    }

    /**
     * @return NodeList elem, containing all values in this
     */
    public RoomNodeList valueList(){
        RoomNodeList result = new RoomNodeList();

        if(this.key == null && this.next == null) return result;

        RoomLinkedMap tmp = this;
        while(tmp!=null){
            if(tmp.getValue() != null)
                result.add(tmp.getValue());
            tmp = tmp.getNext();
        }

        return result;
    }

    /**
     * recursively looks for a node in the LinkedMap containing the key
     *
     * @param key key!=null, key to look up
     * @return node containing the key; null if no node with the key is not found
     */
    private RoomLinkedMap findNode(String key) {
        if (this.key != null && this.key.equals(key)) {
            return this;
        }
        if (next != null) {
            return next.findNode(key);
        } else {
            return null;
        }
    }

    /**
     * removes mapping from this LinkedMap structure (sets key and value to null -> sets Node to empty)
     *
     * @param key key!=null, key of key-value pair to add
     * @return null if key could not be found; otherwise old value assigned to the key
     */
    public Room remove(String key) {
        Room oldValue = get(key);
        RoomLinkedMap nodeToRemove = findNode(key);
        if (nodeToRemove != null) {
            nodeToRemove.key = null;
            nodeToRemove.value = null;
        }
        return oldValue;
    }

    /**
     * @return Iterator over all values V inside this
     */
    public RoomNodeListIterator getValues(){return valueList().iterator();}

}