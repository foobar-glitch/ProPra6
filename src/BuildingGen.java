// TODO BuildingGen und CompanyGen sind so ähnlich könnte man hier eine gemeinsame abstrakte Elternklasse mit generischen Typen nehmen?

public class BuildingGen {

    private final String name;
    private final LinkedMapGen<Integer, OfficeGen> offices;

    private BuildingGen(String name) {
        this.name = name;
        this.offices = new LinkedMapGen<Integer, OfficeGen>();
    }

    public String getName() {
        return name;
    }

    private void addOffice(OfficeGen office){
        offices.put(office.getId(), office);
    }

    private void removeOffice(OfficeGen office){
        offices.remove(office.getId());
    }

    private void printAllOfficeInformation() {
        // TODO
        LinkedMapGen<Integer, OfficeGen> iterator = offices;
        while (iterator != null) {

            System.out.println("The value is " + iterator.getValue());
            iterator = iterator.getNext();
        }
    }
}
