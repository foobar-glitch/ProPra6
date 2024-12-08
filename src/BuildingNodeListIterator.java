import java.util.NoSuchElementException;

/**
 * Simple Iterator over Building objects implementation
 */
public class BuildingNodeListIterator {

    private BuildingNode current;

    /**
     * New NodeListIterator over Building Elements
     * @param start Node of a LinkedList/NodeList OR Null if Iterator over 0 elements
     */
    public BuildingNodeListIterator(BuildingNode start) {
        this.current = start;
    }

    /**
     * @return True if this.next() exists
     */
    public boolean hasNext() {
        return current != null;
    }

    /**
     * @return Next Element from Iterator
     * @throws NoSuchElementException if no next element exists
     */
    public Building next() {
        if (!hasNext()) throw new NoSuchElementException();
        Building value = current.value();
        current = current.next();
        return value;
    }

}
