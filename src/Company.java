public class Company implements StringContainerInterface{

    private final String name;
    private final BuildingLinkedMap map = new BuildingLinkedMap();

    public Company(String name) {
        this.name = name;
    }

    public void add(Building building){
        String key = building.id();
        if(map.get(key) != null) return;
        map.put(key, building);
    }

    public Building remove(String name){return map.remove(name);}

    public String getName(){return this.name;}

    @Override
    public void print(){

        BuildingLinkedMap map = this.map;
        System.out.println("Company: " + this.getName() );
        System.out.println("#########################");
        System.out.println();
        int i=0;
        BuildingNodeListIterator buildings = map.getValues();
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
