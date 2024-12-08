public class Building implements StringContainerInterface{

    private final String name;
    private final OfficeLinkedMap map = new OfficeLinkedMap();

    /**
     * Creates new Building
     * @param name name!=null, Unique Name of (this) Building
     */
    public Building(String name) {
        this.name = name;
    }

    /**
     * Adds office to this Building if no office with the same unique id is in this
     * @param office office!=null, office to be added to this
     * @return  TRUE if office is added to this, FALSE if office was not added to this
     *          (because this already contained an office with same id)
     */
    public boolean add(Office office){
        int id = office.id();
        if(map.get(id) != null) return false;
        map.put(office.id(), office);
        return true;
    }

    /**
     * Removes Office from this
     * @param id unique id of Office which should be removed from this
     * @return Office which was removed or Null if no such Office was in this
     */
    public Office remove(int id){
        return map.remove(id);
    }

    /**
     * @return Unique Name of this
     */
    public String getName(){return this.name;}

    @Override
    public void print(){

        OfficeLinkedMap map = this.map;
        OfficeNodeListIterator offices = map.getValues();
        System.out.println("Offices");

        int i=0;
        while(offices.hasNext()){

            Office office = offices.next();
            System.out.println("Office " + i++ + ": " + office.id());
            System.out.println("----------");
            System.out.println(office);
            System.out.println();
        }

    }

    @Override
    public String id() {
        return this.getName();
    }

    // for testing
    public Office getOffice(int id) {
        return map.get(id);
    }
}