public class Company extends ContainerGen<String, Building> implements ContainerInterface<String>{

    public Company(String name) {
        super(name);
    }

    @Override
    public void print(){

        LinkedMapGen<String, Building> map = this.map();
        System.out.println("Company: " + this.getName() );
        System.out.println("#########################");
        System.out.println();
        int i=0;
        Iterator<Building> buildings = map.getValues();
        while(buildings.hasNext()){
            Building building = buildings.next();
            System.out.println("Building " + i++ + ": " + building.getName());
            System.out.println("-------------------------------");
            building.print();
            System.out.println();
        }

    }

    @Override
    public String id(){return this.getName();}

}
