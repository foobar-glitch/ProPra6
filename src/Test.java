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

        LinkedMapGen<String, Room> map = new LinkedMapGen<>();
        Room Wichtelraum = new WindowRoom(
                "Wichtelraum",
                250,
                250,
                75,
                new WorkSpace(20)
        );
        map.put(Wichtelraum.getName(), Wichtelraum);
        Office office = new Office(5, map);
        office.print();


    }



}
