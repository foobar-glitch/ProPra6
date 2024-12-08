// TODO should BuildingGen have Type-Parameters??
public class BuildingGen extends ContainerGen<Integer, OfficeGen<String, Room>> implements ContainerInterface<String>{
    public BuildingGen(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Building: " + super.getName();
    }

    @Override
    public String id() {
        return super.getName();
    }

    public OfficeGen<String, Room> getOffice(int id) {
        return super.map().get(id);
    }

    public void removeOffice(int id) {
        super.remove(super.map().get(id));
    }
}
