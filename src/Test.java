// TODO Aufgabenteilung:

/*
    Wer was gemacht hat:
    Julian -
    Hamed -
    Marian -
 */

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

    Test for behaviour when dividing by 0!!!
     */

    public static void main(String[] args) {


        Room testGenRoom_Acc = new WindowRoom("Accounting", 125, 75, 2000, new WorkSpace(650));
        Room testGenRoom_CR1 = new WindowRoom("Conference Room 1", 6, 18, 25, new WorkSpace(12));
        Room testGenRoom_CR2 = new WindowRoom("Conference Room 2", 15, 25, 40, new WorkSpace(200));
        Room testGenRoom_Arc = new WindowlessRoom("Archive", 15, 25, 350, new StorageSpace(350));
        Room testGenRoom_TE = new WindowRoom("Technical Equipment", 10, 2, 6, new StorageSpace(10));
        Room testGenRoom_OM = new WindowRoom("Office Materials", 5, 6, 8, new StorageSpace(30));
        BuildingGen testGenBuilding2_Asia = new BuildingGen("Example Inc. Asia");

        //                                      Office1
        LinkedMapGen<String, Room> roomsGenOffice1 = new LinkedMapGen<String, Room>();
        // Accounting
        roomsGenOffice1.put(testGenRoom_Acc.getName(), testGenRoom_Acc);
        // Conference Room 1
        roomsGenOffice1.put(testGenRoom_Acc.getName(), testGenRoom_CR1);
        // contains Accounting and Conference Room 1
        OfficeGen<String, Room> testGenOffice1 = new OfficeGen<String, Room>(1, roomsGenOffice1);

        //                                      Office2
        LinkedMapGen<String, Room> roomsGenOffice2 = new LinkedMapGen<String, Room>();
        // Conference Room 2
        roomsGenOffice2.put(testGenRoom_Arc.getName(), testGenRoom_CR2);
        // contains Archive
        OfficeGen<String, Room> testGenOffice2 = new OfficeGen<String, Room>(1, roomsGenOffice2);

        //                                      Office3
        LinkedMapGen<String, Room> roomsGenOffice3 = new LinkedMapGen<String, Room>();
        // Archive
        roomsGenOffice3.put(testGenRoom_Arc.getName(), testGenRoom_Arc);
        // contains Archive
        OfficeGen<String, Room> testGenOffice3 = new OfficeGen<String, Room>(1, roomsGenOffice3);

        //                                      Office4
        LinkedMapGen<String, Room> roomsGenOffice4 = new LinkedMapGen<String, Room>();
        // Archive
        roomsGenOffice4.put(testGenRoom_Arc.getName(), testGenRoom_TE);
        // contains Archive
        OfficeGen<String, Room> testGenOffice4 = new OfficeGen<String, Room>(1, roomsGenOffice4);

        // Test create Company
        CompanyGen testGenCompany_ExInc = new CompanyGen("Example Inc.");
        // Test create first Office Building
        BuildingGen testGenBuilding1_HQ = new BuildingGen("Example Inc. Headquarters");




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
