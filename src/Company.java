public class Company implements StringContainerInterface{

    private final String name;
    private final BuildingLinkedMap map = new BuildingLinkedMap();


    /**
     * Creates new Company
     * @param name name!=null, Unique Name of (this) Company
     */
    public Company(String name) {
        this.name = name;
    }

    /**
     * Adds building to this Building if no building with the same unique name is in this
     * @param building building!=null, building to be added to this
     * @return  TRUE if building is added to this, FALSE if building was not added to this
     *          (because this already contained a building with same name)
     */
    public boolean add(Building building){
        String key = building.id();
        if(map.get(key) != null) return false;
        map.put(key, building);
        return true;
    }

    /**
     * Removes Building from this
     * @param name unique name of Building which should be removed from this
     * @return Building which was removed or Null if no such Building was in this
     */
    public Building remove(String name){return map.remove(name);}

    /**
     * @return Unique Name of this
     */
    public String getName(){return this.name;}

    @Override
    public void print(){

        BuildingLinkedMap map = this.map;
        System.out.println("Company: " + this.getName() );
        System.out.println("#########################");
        System.out.println();
        int i=0;
        BuildingNodeListIterator buildings = map.getValues();
        while(buildings.hasNext()){
            Building building = buildings.next();
            System.out.println("Building " + i++ + ": " + building.getName());
            System.out.println("-------------------------------");
            building.print();
            System.out.println();
        }

    }

    @Override
    public String id(){return this.getName();}

    // for testing
    public Building getBuilding(String name) {
        return map.get(name);
    }
}
