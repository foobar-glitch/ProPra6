public class BuildingLinkedMap {
    private BuildingLinkedMap next;
    private String key;
    private Building value;

    public Building getValue() {
        return value;
    }

    /**
     * parameterless Constructor; creates empty node
     */
    public BuildingLinkedMap() {
        this.next = null;
        this.key = null;
        this.value = null;
    }

    private BuildingLinkedMap(String key, Building value) {
        this.next = null;
        this.key = key;
        this.value = value;
    }

    private BuildingLinkedMap getNext() {
        return next;
    };


    /**
     * Iteratively search for room for a given key
     *
     * @param roomName name of room to look up
     * @return Room containing the key; null if no room with the key is not found
     */
    public Building get(String key){
        for(BuildingLinkedMap current = next; current != null; current = current.getNext()){
            if(current.key.equals(key)){
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
    private BuildingLinkedMap insertPair(String id, Building building) {
        // When room exists, overwrite
        BuildingLinkedMap current = this;

        // Traverse the list to check if the room already exists
        while (current != null) {
            if (current.key.equals(id)) {
                // If roomName exists, overwrite the value
                current.value = building;
                return current;
            }
            current = current.getNext();
        }

        // If the roomName doesn't exist, append a new node to the end
        // Traverse to the last node
        BuildingLinkedMap lastNode = this;
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }

        // Now append the new node
        lastNode.next = new BuildingLinkedMap(id, building);

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
    public Building put(String key, Building newValue) {
        Building oldValue = get(key);
        insertPair(key, newValue);
        return oldValue;
    }

    /**
     * @return NodeList elem, containing all values in this
     */
    public BuildingNodeList valueList(){
        BuildingNodeList result = new BuildingNodeList();

        if(this.key == null && this.next == null) return result;

        BuildingLinkedMap tmp = this;
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
    private BuildingLinkedMap findNode(String key) {
        if (this.key.equals(key)) {
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
    public Building remove(String key) {
        Building oldValue = get(key);
        BuildingLinkedMap nodeToRemove = findNode(key);
        if (nodeToRemove != null) {
            nodeToRemove.key = null;
            nodeToRemove.value = null;
        }
        return oldValue;
    }

    /**
     * @return Iterator over all values V inside this
     */
    public BuildingNodeListIterator getValues(){return valueList().iterator();}
}
