public class Building extends ContainerGen<Integer, Office> implements ContainerInterface<String>{

    public Building(String name) {
        super(name);
    }

    @Override
    public void print(){

        LinkedMapGen<Integer, Office> map = this.map();
        IteratorGen<Office> offices = map.getValues();
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