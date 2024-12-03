import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

// Can't delete elements
public class LinkedMapGen<K, V> {

    private LinkedMapGen<K, V> next = null;
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
        this.key = null;
        this.value = null;
    }

    /**
     * Constructor with Parameters
     *
     * @param key key
     * @param value value
     */
    public LinkedMapGen(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * recursively looks for a node in the LinkedMap containing the key
     *
     * @param key key to look up
     * @return value that is mapped to key; null if key is not found
     */
    public V get (K key) {
        if (this.key != null && this.key.equals(key)) {
            return value;
        }
        if (next != null) {
            return next.get(key);
        } else {
            return null;
        }
    }

    /**
     * recursively looks for place to insert pair; if key already exists overwrites value at that node; otherwise
     * writes value-key pair to the earliest empty node or if not adds new node for value-key pair at the end of list
     *
     * @param key key of key-value pair to add
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
}
