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

    /**
     * Creates new "Node" of this with given key and value
     * @param key key!=null
     * @param value value!=null
     */
    private OfficeLinkedMap(int key, Office value) {
        this.next = null;
        this.key = key;
        this.value = value;
    }

    /**
     * @return Next Node of this Or Null if this is last element
     */
    public OfficeLinkedMap getNext() {
        return next;
    };


    /**
     * Iteratively search for Office for a given key
     *
     * @param key ID of Office
     * @return Office containing the key; null if no office with the key is not found
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
     * Search for office and overwrite it if the key is unused write at the end
     *
     * @param id ID of the office which is the key of the dictionary
     * @param office office which is the value of the dictionary
     */
    public OfficeLinkedMap insertPair(int id, Office office) {

        OfficeLinkedMap current = this;

        while (current != null) {
            if (current.key == id) {
                current.value = office;
                return current;
            }
            current = current.getNext();
        }

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
     * @param key key!=null, key of key-value pair to add
     * @param newValue newValue!=null, value of key-value pair to add
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
     * @param key key!=null, key to look up
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
     * @param key key!=null, key of key-value pair to add
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
     * @return Iterator over all values inside this
     */
    public OfficeNodeListIterator getValues(){return valueList().iterator();}

}
