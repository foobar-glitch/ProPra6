import java.util.NoSuchElementException;

/**
 * Implementation of a simple LinkedList
 */
public class NodeListGen<X> {

    Node<X> start = null;

    /**
     * Adds elem to NodeList
     * @param elem (elem!=null)
     */
    public void add(X elem){
        if(start == null){start = new Node<>(elem); return;}
        Node<X> tmp = start;
        while(tmp.next != null){tmp = tmp.next;}
        tmp.next = new Node<>(elem);
    }

    /**
     * Removes first Element equal to this from this NodeList
     * @param elem (elem!=null) elem to remove
     * @return true => NodeList contained elem || false => NodeList didn't contain elem
     */
    public boolean remove(X elem){
        if(start == null) return false;
        Node<X> tmp = start;
        // Special case if start is removed
        if(start.value.equals(elem)){start = start.next; return true;}
        // Else
        while(tmp.next != null){
            // If tmp.next equals elem, remove it and fix list
            if(tmp.next.value.equals(elem)){
                tmp.next = tmp.next.next;
                return true;
            }
            // Else go to next Node
            tmp = tmp.next;
        }
        return false;
    }

    /**
     * Removes all occurrences of elem in NodeList
     * @param elem (!= null)
     * @return true (elem existed in NodeList) || false (elem didn't exist in NodeList)
     */
    public boolean removeAll(X elem){
        if(!contains(elem)) return false;

        boolean state = true;
        while (state){
            state = remove(elem);
        }

        return true;
    }

    /**
     * Does NodeList contain this Object?
     * @param elem (elem!= null)
     * @return True (NodeList contains elem); False (NodeList doesn't contain elem)
     */
    public boolean contains(X elem){
        if(start== null) return false;
        Node<X> tmp = start;
        while (tmp != null){
            if(tmp.value.equals(elem)) return true;
            tmp = tmp.next;
        }
        return false;
    }

    /**
     * Retrieves Element at Index index, if there is no elem at index return null
     * @param index Index of element to be retrieved
     * @return Elem or Null if no element exists at this index
     */
    public X get(int index){
        if(start == null) return null;

        int i = 0;
        Node<X> tmp = start;
        while (tmp != null){
            if(i++ == index) return tmp.value;
            tmp = tmp.next;
        }

        return null;
    }

    /**
     * @return Number of Elements in NodeList
     */
    public int length(){

        int len = 0;
        if(start == null) return len;

        Node<X> tmp = start;
        while(tmp != null){len++; tmp=tmp.next;}

        return len;
    }

    /**
     * Live-Iterator over all elements in NodeList
     * @return Iterator
     */
    public Iterator<X> iterator(){
        return new NodeListIterator<X>(start);
    }

    /**
     * @return String in Array Style, containing all elements in NodeList [x0, x1, x2, ...]
     */
    @Override
    public String toString(){
        if(start == null) return "[]";
        StringBuilder stringBuilder = new StringBuilder();
        Node<X> tmp = start;
        while(tmp != null){
            stringBuilder.append(tmp.value).append(", ");
            tmp = tmp.next;
        }
        return "[" + stringBuilder.substring(0, stringBuilder.length()-2) + "]";
    }

}

/**
 * Simple Node Implementation
 * @param <X> Type of Object to be value of Node
 */
class Node<X>{

    Node<X> next = null;
    X value = null;

    public Node(X value){this.value = value;}

}

/**
 * Simple Iterator implementation
 * @param <X> Type X over which Objects is Iterated
 */
class NodeListIterator<X> implements Iterator<X>{

    Node<X> current;

    public NodeListIterator(Node<X> start){this.current = start;}

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public X next() {
        if(!hasNext()) throw new NoSuchElementException();
        X value = current.value;
        current = current.next;
        return value;
    }
}
