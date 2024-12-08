public class BuildingGen extends ContainerGen<Integer, OfficeGen<String, Room>> implements ContainerInterface<String>{

    /**
     * Creates new Object of this with unique Name name
     * @param name name!=null, Unique Name of this
     */
    public BuildingGen(String name) {
        super(name);
    }


    @Override
    public String toString() {
        String allOneString = "Building: " + super.getName();
        allOneString = allOneString.concat("\n-------------------------");
        IteratorGen<OfficeGen<String, Room>> elems = super.map().getValues();
        while(elems.hasNext()){
            allOneString = allOneString.concat("\n\t" + elems.next().toString());
        }
        return allOneString.replace("\n", "\n\t");
    }

    @Override
    public String id() {
        return super.getName();
    }

    /**
     * Returns Office with unique id id if it's inside this
     * @param id unique id of Office which should be retrieved
     * @return Office if office is in this, otherwise returns Null
     */
    public OfficeGen<String, Room> getOffice(int id) {
        return super.map().get(id);
    }

    /**
     * Removes office from this if office is in this, otherwise nothing happens
     * @param id id!=null, unique id of office which should be removed
     */
    public void removeOffice(int id) {
        super.remove(super.map().get(id));
    }
}
