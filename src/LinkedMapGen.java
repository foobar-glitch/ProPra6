import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

// Can't delete elements
public class LinkedMapGen<K, V> {

    private LinkedMapGen<K, V> next;
    private K key;
    private V value;

    public LinkedMapGen<K, V> getNext() {
        return next;
    }

    public V getValue() {
        return value;
    }

    /**
     * parameterless Constructor; creates empty node
     */
    public LinkedMapGen() {
        this.next = null;
        this.key = null;
        this.value = null;
    }

    /**
     * Constructor with Parameters
     *
     * @param key key; can not be null
     * @param value value
     */
    public LinkedMapGen(K key, V value) {
        this.next = null;
        this.key = key;
        this.value = value;
    }

    /**
     * recursively looks for a node in the LinkedMap containing the key
     *
     * @param key key to look up
     * @return node containing the key; null if no node with the key is not found
     */
    private LinkedMapGen<K, V> findNode(K key) {
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
     * looks for a node in the LinkedMap containing the key
     *
     * @param key key to look up
     * @return value that is mapped to key; null if key is not found
     */
    public V get (K key) {
        LinkedMapGen<K, V> nodeWithKey = findNode(key);
        if (nodeWithKey != null) {
            return nodeWithKey.value;
        } else {
            return null;
        }
    }

    /**
     * recursively looks for place to insert pair; if key already exists overwrites value at that node; otherwise
     * writes value-key pair to the earliest empty node or if not adds new node for value-key pair at the end of list
     *
     * @param key key of key-value pair to add; can not be null
     * @param value value of key-value pair to add
     */
    private void insertPair(K key, V value) {
        if ((this.key == null && this.value == null) || (this.key != null && this.key.equals(key))) {
            this.key = key;
            this.value = value;
        } else {
            if (next != null) {
                next.insertPair(key, value);
            } else {
                next = new LinkedMapGen<K, V>(key, value);
            }
        }
    }

    /**
     * adds mapping to this LinkedMap structure
     *
     * @param key key of key-value pair to add
     * @param newValue value of key-value pair to add
     * @return null if key was not already included; otherwise old value assigned to the key
     */
    public V put(K key, V newValue) {
        V oldValue = get(key);
        insertPair(key, value);
        return oldValue;
    }

    /**
     * removes mapping from this LinkedMap structure (sets key and value to null -> sets Node to empty)
     *
     * @param key key of key-value pair to add
     * @return null if key could not be found; otherwise old value assigned to the key
     */
    public V remove(K key) {
        V oldValue = get(key);
        LinkedMapGen<K, V> nodeToRemove = findNode(key);
        if (nodeToRemove != null) {
            nodeToRemove.key = null;
            nodeToRemove.value = null;
        }
        return oldValue;
    }
}
