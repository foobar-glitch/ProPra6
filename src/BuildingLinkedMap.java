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

    /**
     * Creates new "Node" of this with given key and value
     * @param key key!=null
     * @param value value!=null
     */
    private BuildingLinkedMap(String key, Building value) {
        this.next = null;
        this.key = key;
        this.value = value;
    }

    /**
     * @return Next Node of this Or Null if this is last element
     */
    private BuildingLinkedMap getNext() {
        return next;
    };


    /**
     * Iteratively search for building for a given key
     *
     * @param key key!=null, name of building to look up
     * @return Building containing the key; null if no building with the key is not found
     */
    public Building get(String key){
        BuildingLinkedMap nodeWithKey = findNode(key);
        if (nodeWithKey != null) {
            return nodeWithKey.value;
        } else {
            return null;
        }
    }

    /**
     * Search for Building and overwrite it if the key is unused write at the end
     *
     * @param id id!=null, Name of the building which is the key of the dictionary
     * @param building building!=null, Building which is the value of the dictionary
     */
    private void insertPair(String id, Building building) {
        if ((this.key == null && this.value == null) || (this.key != null && this.key.equals(id))) {
            this.key = id;
            this.value = building;
        } else {
            if (next != null) {
                next.insertPair(id, building);
            } else {
                next = new BuildingLinkedMap(id, building);
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
    private BuildingLinkedMap findNode(String key) {
        if (this.key == null) {
            return null;
        }
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
     * @param key key!=null, key of key-value pair to add
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
     * @return Iterator over all values inside this
     */
    public BuildingNodeListIterator getValues(){return valueList().iterator();}
}
