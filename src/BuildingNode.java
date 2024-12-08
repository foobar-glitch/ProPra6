public class BuildingNode {


    private BuildingNode next = null;
    private final Building value;

    /**
     * Creates new Node with given value
     * @param value value of new Node
     */
    public BuildingNode(Building value){this.value = value;}

    /**
     * @return Next RoomNode or Null if next does not exist
     */
    public BuildingNode next(){return next;}

    /**
     * @return value of this Node
     */
    public Building value(){return value;}

    /**
     * Set next Node of this to node
     */
    public void setNext(BuildingNode node){
        this.next = node;
    }

}
