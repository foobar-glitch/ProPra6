// TODO should BuildingGen have Type-Parameters??
public class CompanyGen extends ContainerGen<String, BuildingGen> implements ContainerInterface<String> {
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

    public BuildingGen getBuilding(String name) {
        return super.map().get(name);

    }
}
