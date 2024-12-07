// TODO should BuildingGen have Type-Parameters??
public class BuildingGen extends ContainerGen<Integer, OfficeGen<String, Space>> implements ContainerInterface<String>{
    public BuildingGen(String name) {
        super(name);
    }

    @Override
    public String id() {
        return "";
    }
}
