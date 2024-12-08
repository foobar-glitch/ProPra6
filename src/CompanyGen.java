public class CompanyGen extends ContainerGen<String, BuildingGen> implements ContainerInterface<String> {

    /**
     * Creates new Object of this with unique Name name
     * @param name name!=null, Unique Name of this
     */
    public CompanyGen(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Company: " + super.getName();
    }

    @Override
    public String id() {
        return super.getName();
    }

    /**
     * Returns Building with unique name name if it's inside this
     * @param name name!=null, unique name of Office which should be retrieved
     * @return Building if building is in this, otherwise return Null
     */
    public BuildingGen getBuilding(String name) {
        return super.map().get(name);

    }
}
