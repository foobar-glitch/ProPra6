// TODO CompanyGen und BuildingGen sind so ähnlich könnte man hier eine gemeinsame abstrakte Elternklasse mit generischen Typen nehmen?
public class Company extends ContainerGen<String, BuildingGen> implements ContainerInterface<String>{

    public Company(String name) {
        super(name);
    }

    @Override
    public void print(){

        LinkedMapGen<String, BuildingGen> map = this.map();
        System.out.println("Company: " + this.getName() );
        System.out.println("#########################");
        System.out.println();
        int i=0;
        Iterator<BuildingGen> buildings = map.getValues();
        while(buildings.hasNext()){
            BuildingGen building = buildings.next();
            System.out.println("Building " + i++ + ": " + building.getName());
            System.out.println("-------------------------------");
            building.print();
            System.out.println();
        }

    }

    @Override
    public String id(){return this.getName();}

}
