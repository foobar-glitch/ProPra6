public class OfficeLinkedMap {

    private OfficeLinkedMap next;
    private int key;
    private Office value;

    public Office getValue() {
        return value;
    }

    /**
     * parameterless Constructor; creates empty node
     */
    public OfficeLinkedMap() {
        this.next = null;
        this.key = -1;
        this.value = null;
    }

    private OfficeLinkedMap(int key, Office value) {
        this.next = null;
        this.key = key;
        this.value = value;
    }

    public OfficeLinkedMap getNext() {
        return next;
    };


    /**
     * Iteratively search for room for a given key
     *
     * @param roomName name of room to look up
     * @return Room containing the key; null if no room with the key is not found
     */
    public Office get(int key){
        for(OfficeLinkedMap current = next; current != null; current = current.getNext()){
            if(current.key == key){
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
    public OfficeLinkedMap insertPair(int id, Office office) {
        // When room exists, overwrite
        OfficeLinkedMap current = this;

        // Traverse the list to check if the room already exists
        while (current != null) {
            if (current.key == id) {
                // If roomName exists, overwrite the value
                current.value = office;
                return current;
            }
            current = current.getNext();
        }

        // If the roomName doesn't exist, append a new node to the end
        // Traverse to the last node
        OfficeLinkedMap lastNode = this;
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }

        // Now append the new node
        lastNode.next = new OfficeLinkedMap(id, office);

        // Return the newly added node
        return lastNode.getNext(); // Return the newly appended node
    }

    /**
     * adds mapping to this LinkedMap structure
     *
     * @param key key of key-value pair to add
     * @param newValue value of key-value pair to add
     * @return null if key was not already included; otherwise old value assigned to the key
     */
    public Office put(int key, Office newValue) {
        Office oldValue = get(key);
        insertPair(key, newValue);
        return oldValue;
    }

    /**
     * @return NodeList elem, containing all values in this
     */
    public OfficeNodeList valueList(){
        OfficeNodeList result = new OfficeNodeList();

        if(this.key == -1 && this.next == null) return result;

        OfficeLinkedMap tmp = this;
        while(tmp!=null){
            result.add(tmp.getValue());
            tmp = tmp.getNext();
        }

        return result;
    }

    /**
     * recursively looks for a node in the LinkedMap containing the key
     *
     * @param key key to look up
     * @return node containing the key; null if no node with the key is not found
     */
    private OfficeLinkedMap findNode(int key) {
        if (this.key == key) {
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
     * @param key key of key-value pair to add
     * @return null if key could not be found; otherwise old value assigned to the key
     */
    public Office remove(int key) {
        Office oldValue = get(key);
        OfficeLinkedMap nodeToRemove = findNode(key);
        if (nodeToRemove != null) {
            nodeToRemove.key = -1;
            nodeToRemove.value = null;
        }
        return oldValue;
    }

    /**
     * @return Iterator over all values V inside this
     */
    public RoomIterator getValues(){return valueList().iterator();}

}
