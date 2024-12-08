// TODO should BuildingGen have Type-Parameters??
public class BuildingGen extends ContainerGen<Integer, OfficeGen<String, Room>> implements ContainerInterface<String>{
    public BuildingGen(String name) {
        super(name);
    }

    @Override
    public String toString() {
        String allOneString = "Building: " + super.getName();
        allOneString = allOneString.concat("\n-------------------------");
        IteratorGen<OfficeGen<String, Room>> elems = super.map().getValues();
        System.out.println("-------------------------");
        while(elems.hasNext()){
            System.out.println("\t" + elems.next().toString());
        }

        return allOneString;

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
