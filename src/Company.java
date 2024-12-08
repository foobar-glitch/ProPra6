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
        BuildingNodeListIterator elems = map.getValues();
        System.out.println(name);
        System.out.println("-------------------------");
        while(elems.hasNext()){
            System.out.println("\t" + elems.next().toString());
        }

    }

    @Override
    public String id(){return this.getName();}

    // for testing
    public Building getBuilding(String name) {
        return map.get(name);
    }
}
