// TODO BuildingGen und CompanyGen sind so ähnlich könnte man hier eine gemeinsame abstrakte Elternklasse mit generischen Typen nehmen?

public class BuildingGen extends ContainerGen<Integer, Office> implements ContainerInterface<String>{

    public BuildingGen(String name) {
        super(name);
    }

    @Override
    public void print(){

        LinkedMapGen<Integer, Office> map = this.map();
        Iterator<Office> offices = map.getValues();
        System.out.println("Offices");

        int i=0;
        while(offices.hasNext()){

            Office office = offices.next();
            System.out.println("Office " + i++ + ": " + office.id());
            System.out.println("----------");
            System.out.println(office);
            System.out.println();
        }

    }

    @Override
    public String id() {
        return this.getName();
    }

}
