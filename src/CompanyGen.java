// TODO CompanyGen und BuildingGen sind so ähnlich könnte man hier eine gemeinsame abstrakte Elternklasse mit generischen Typen nehmen?
public class CompanyGen {
    private final String name;
    private final LinkedMapGen<String, BuildingGen> buildings;

    public CompanyGen(String name) {
        this.name = name;
        this.buildings = new LinkedMapGen<String, BuildingGen>();
    }

    private void addOffice(BuildingGen building){
        buildings.put(building.getName(), building);
    }

    private void removeOffice(BuildingGen building){
        buildings.remove(building.getName());
    }

    private void printAllOfficeInformation() {
        // TODO
    }

}
