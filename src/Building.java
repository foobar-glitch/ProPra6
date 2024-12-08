public class Building implements StringContainerInterface{

    private final String name;
    private final OfficeLinkedMap map = new OfficeLinkedMap();

    public Building(String name) {
        this.name = name;
    }

    public void add(Office office){
        int id = office.id();
        if(map.get(id) != null) return;
        map.put(office.id(), office);
    }

    public Office remove(int id){
        return map.remove(id);
    }

    public String getName(){return this.name;}

    @Override
    public void print(){

        OfficeLinkedMap map = this.map;
        OfficeNodeListIterator offices = map.getValues();
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