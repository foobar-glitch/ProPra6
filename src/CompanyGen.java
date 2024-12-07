public class CompanyGen extends ContainerGen<String, BuildingGen> implements ContainerInterface<String> {
    public CompanyGen(String name) {
        super(name);
    }

    @Override
    public String id() {
        return "";
    }
}
