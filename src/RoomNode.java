/**
 * Simple Node Implementation
 */
public class RoomNode{

    private RoomNode next = null;
    private final Room value;

    /**
     * Creates new Node with given value
     * @param value value of new Node
     */
    public RoomNode(Room value){this.value = value;}

    /**
     * @return Next RoomNode or Null if next does not exist
     */
    public RoomNode next(){return next;}

    /**
     * @return value of this Node
     */
    public Room value(){return value;}

    /**
     * Set next Node of this to node
     */
    public void setNext(RoomNode node){
        this.next = node;
    }

}