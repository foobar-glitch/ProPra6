public class BuildingNode {


    private BuildingNode next = null;
    private final Building value;

    public BuildingNode(Building value){this.value = value;}

    public BuildingNode next(){return next;}
    public Building value(){return value;}

    public void setNext(BuildingNode node){
        this.next = node;
    }

}
