public class Test {
    /*
    1. create and do the following for an Object of Company and an Object of CompanyGen
        - create and change/update multiple Buildings with multiple Offices (each respectively containing a few rooms)
        - each Building should be accessed (by its unique name)
        - each Office should be accessed (by its unique number)
        - each Room should be accessed (by its unique name)
     2. add and remove Offices one at a time to the Buildings; access the Offices via their unique id number
     3. add, remove and update the information in Rooms one at a time to the Offices; access Offices via their unique id number/ access Offices via their unique name
     4. calculate and output on the screen all the statistical information for all Offices
     */

    public static void main(String[] args) {

        Company comp = new Company("Bauernhof und CO KG");
        Building werkstatt = new Building("Wichtelwerkstatt");

        Room buero0 = new WindowRoom("Alpha", 100, 100, 10);
        Room buero2 = new WindowRoom("Beta", 50, 50, 1);
        Room kammer = new WindowlessRoom("Lost", 10, 10, 0.5);

        LinkedMapGen<String, Space> map = new LinkedMapGen<>();
        map.put(buero0.getName(), new WorkSpace(buero0, 20));
        map.put(buero2.getName(), new WorkSpace(buero2, 10));
        map.put(kammer.getName(), new StorageSpace(kammer, 200));

        Office office = new Office(0, map);
        werkstatt.add(office);

        comp.add(werkstatt);

        comp.print();

    }



}
