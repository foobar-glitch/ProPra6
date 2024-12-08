import java.util.NoSuchElementException;

public class BuildingNodeListIterator {

    private BuildingNode current;

    public BuildingNodeListIterator(BuildingNode start) {
        this.current = start;
    }
    public boolean hasNext() {
        return current != null;
    }

    public Building next() {
        if (!hasNext()) throw new NoSuchElementException();
        Building value = current.value();
        current = current.next();
        return value;
    }

}
