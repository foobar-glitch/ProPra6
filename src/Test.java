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

        //                                      Test Gen
        // Create Objects used in Testing
        Room testGenRoom_Acc = new WindowRoom("Accounting", 125, 75, 2000, new WorkSpace(650));
        Room testGenRoom_CR1 = new WindowRoom("Conference Room 1", 6, 18, 25, new WorkSpace(12));
        Room testGenRoom_CR2 = new WindowRoom("Conference Room 2", 15, 25, 40, new WorkSpace(200));
        Room testGenRoom_Caf = new WindowRoom("Cafeteria", 15, 10, 30, new WorkSpace(1));
        Room testGenRoom_Arc = new WindowlessRoom("Archive", 15, 25, 350, new StorageSpace(350));
        Room testGenRoom_TE = new WindowRoom("Technical Equipment", 10, 2, 6, new StorageSpace(10));
        Room testGenRoom_OM = new WindowRoom("Office Materials", 5, 6, 8, new StorageSpace(30));
        Room testGenRoom_OA = new WindowRoom("Office Asia", 50, 12, 230, new WorkSpace(250));


        // Office1
        LinkedMapGen<String, Room> roomsGenOffice1 = new LinkedMapGen<String, Room>();
        // Accounting
        roomsGenOffice1.put(testGenRoom_Acc.getName(), testGenRoom_Acc);
        // Conference Room 1
        roomsGenOffice1.put(testGenRoom_CR1.getName(), testGenRoom_CR1);
        // contains Accounting and Conference Room 1
        OfficeGen<String, Room> testGenOffice1 = new OfficeGen<String, Room>(1, roomsGenOffice1);

        // Office2
        LinkedMapGen<String, Room> roomsGenOffice2 = new LinkedMapGen<String, Room>();
        // Conference Room 2
        roomsGenOffice2.put(testGenRoom_CR2.getName(), testGenRoom_CR2);
        // Archive
        roomsGenOffice2.put(testGenRoom_Arc.getName(), testGenRoom_Arc);
        // contains Conference Room 2 and Archive
        OfficeGen<String, Room> testGenOffice2 = new OfficeGen<String, Room>(2, roomsGenOffice2);

        // Office3
        LinkedMapGen<String, Room> roomsGenOffice3 = new LinkedMapGen<String, Room>();
        // Cafeteria
        roomsGenOffice3.put(testGenRoom_Caf.getName(), testGenRoom_Caf);
        // Storage for Technical Equipment
        roomsGenOffice3.put(testGenRoom_TE.getName(), testGenRoom_TE);
        // contains Cafeteria and Technical Equipment
        OfficeGen<String, Room> testGenOffice3 = new OfficeGen<String, Room>(3, roomsGenOffice3);

        // Office4
        LinkedMapGen<String, Room> roomsGenOffice4 = new LinkedMapGen<String, Room>();
        // Office Asia
        roomsGenOffice4.put(testGenRoom_OA.getName(), testGenRoom_OA);
        // Storage for Office Materials
        roomsGenOffice4.put(testGenRoom_OM.getName(), testGenRoom_OM);
        OfficeGen<String, Room> testGenOffice4 = new OfficeGen<String, Room>(4, roomsGenOffice4);

        // Test create Company
        CompanyGen testGenCompany_ExInc = new CompanyGen("Example Inc.");
        // Test create first Office Building
        BuildingGen testGenBuilding1_HQ = new BuildingGen("Example Inc. Headquarters");
        // Test add Offices
        testGenBuilding1_HQ.add(testGenOffice1);
        testGenBuilding1_HQ.add(testGenOffice2);
        testGenBuilding1_HQ.add(testGenOffice3);
        // Test create second Office Buildings
        BuildingGen testGenBuilding2_Asia = new BuildingGen("Example Inc. Asia");
        // Test add Office
        testGenBuilding2_Asia.add(testGenOffice4);
        // Test change Office Buildings (add and remove Offices)
        testGenBuilding2_Asia.add(testGenBuilding1_HQ.getOffice(3));
        testGenBuilding1_HQ.removeOffice(3);
        testGenBuilding2_Asia.removeOffice(3);
        // Test change Offices (add and remove Rooms)
        testGenBuilding1_HQ.getOffice(1).addRoom("Conference Room 2", testGenBuilding1_HQ.getOffice(2).getRoom("Conference Room 2"));
        testGenBuilding1_HQ.getOffice(2).removeRoom("Conference Room 2");
        testGenBuilding1_HQ.getOffice(2).addRoom("Accounting",testGenBuilding1_HQ.getOffice(1).getRoom("Accounting"));
        testGenBuilding1_HQ.getOffice(1).removeRoom("Accounting");
        testGenBuilding2_Asia.getOffice(4).addRoom("Accounting",testGenBuilding1_HQ.getOffice(1).getRoom("Accounting"));

        // Test change usage for Rooms
        testGenBuilding1_HQ.getOffice(2).getRoom("Office Materials").setSpace(new WorkSpace(2));
        testGenBuilding1_HQ.getOffice(2).getRoom("Conference Room 1").setSpace(new StorageSpace(100));
        // Test output all statistics
        testGenCompany_ExInc.print();
    }
}
