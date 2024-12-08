// TODO Aufgabenteilung:
// TODO Division durch 0 testen

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
        // contains Office Asia and Office Materials
        OfficeGen<String, Room> testGenOffice4 = new OfficeGen<String, Room>(4, roomsGenOffice4);

        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\tTesting for generic");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        // Test create Company
        CompanyGen testGenCompany_ExInc = new CompanyGen("Example Inc.");
        if (testGenCompany_ExInc != null && testGenCompany_ExInc.getName().equals("Example Inc.")) {
            System.out.println("Company 'Example Inc.' successfully created");
        } else {
            System.out.println("ERROR: issue with creating Company 'Example Inc.'");
        }

        // Test create first Office Building
        BuildingGen testGenBuilding_HQ = new BuildingGen("Example Inc. Headquarters");
        if (testGenBuilding_HQ != null && testGenBuilding_HQ.getName().equals("Example Inc. Headquarters")) {
            System.out.println("Building 'Example Inc. Headquarters' successfully created");
        } else {
            System.out.println("ERROR: issue with creating Building 'Example Inc. Headquarters'");
        }

        // Test create second Office Building
        BuildingGen testGenBuilding_Asia = new BuildingGen("Example Inc. Asia");
        if (testGenBuilding_HQ != null && testGenBuilding_Asia.getName().equals("Example Inc. Asia")) {
            System.out.println("Building 'Example Inc. Asia' successfully created");
        } else {
            System.out.println("ERROR: issue with creating Building 'Example Inc. Asia'");
        }


        // Test add to Company
        testGenCompany_ExInc.add(testGenBuilding_HQ);
        if (testGenCompany_ExInc.getBuilding("Example Inc. Headquarters") != null) {
            System.out.println("Building 'Example Inc. Headquarters' successfully added to Company 'Example Inc.'");
        } else {
            System.out.println("ERROR: issue with adding Building 'Example Inc. Headquarters' to Company 'Example Inc.'");
        }
        testGenCompany_ExInc.add(testGenBuilding_Asia);
        if (testGenCompany_ExInc.getBuilding("Example Inc. Asia") != null) {
            System.out.println("Building 'Example Inc. Asia' successfully added to Company 'Example Inc.'");
        } else {
            System.out.println("ERROR: issue with adding Building 'Example Inc. Asia' to Company 'Example Inc.'");
        }

        // Test add Offices
        testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").add(testGenOffice1);
        if (testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(1) != null &&
                testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(1).getRoom("Accounting") != null &&
                testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(1).getRoom("Conference Room 1") != null) {
            System.out.println("Office 'Office 1' successfully added to Building 'Example Inc. Headquarters'");
        } else {
            System.out.println("ERROR: issue with adding Office 'Office 1' to Building 'Example Inc. Headquarters'");
        }
        testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").add(testGenOffice2);
        if (testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(2) != null &&
                testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(2).getRoom("Conference Room 2") != null &&
                testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(2).getRoom("Archive") != null) {
            System.out.println("Office 'Office 2' successfully added to Building 'Example Inc. HQ'");
        } else {
            System.out.println("ERROR: issue with adding Office 'Office 2' to Building 'Example Inc. Headquarters'");
        }
        testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").add(testGenOffice3);
        if (testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(3) != null &&
                testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(3).getRoom("Cafeteria") != null &&
                testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(3).getRoom("Technical Equipment") != null) {
            System.out.println("Office 'Office 3' successfully added to Building 'Example Inc. HQ'");
        } else {
            System.out.println("ERROR: issue with adding Office 'Office 3' to Building 'Example Inc. Headquarters'");
        }

        // Test add to second Office Building
        testGenCompany_ExInc.getBuilding("Example Inc. Asia").add(testGenOffice4);
        if (testGenCompany_ExInc.getBuilding("Example Inc. Asia").getOffice(4) != null &&
                testGenCompany_ExInc.getBuilding("Example Inc. Asia").getOffice(4).getRoom("Office Asia") != null &&
                testGenCompany_ExInc.getBuilding("Example Inc. Asia").getOffice(4).getRoom("Office Materials") != null) {
            System.out.println("Office 'Office 4' successfully added to Building 'Example Inc. Asia'");
        } else {
            System.out.println("ERROR: issue with adding Office 'Office 3' to Building 'Example Inc. Asia'");
        }

        // Test change Office Buildings (add and remove Offices)
        testGenCompany_ExInc.getBuilding("Example Inc. Asia").add(testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(3));
        testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").removeOffice(3);
        if (testGenCompany_ExInc.getBuilding("Example Inc. Asia").getOffice(3) != null &&
                testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(3) == null) {
            System.out.println("Office 'Office 3' successfully moved from Building 'Example Inc. Headquarters' to Building 'Example Inc. Asia'");
        } else {
            System.out.println("ERROR: issue with moving Office 'Office 3' from Building 'Example Inc. Headquarters' to Building 'Example Inc. Asia'");
        }
        testGenCompany_ExInc.getBuilding("Example Inc. Asia").removeOffice(3);
        if (testGenCompany_ExInc.getBuilding("Example Inc. Asia").getOffice(3) == null) {
            System.out.println("Office 'Office 3' successfully removed from Building 'Example Inc. Asia'");
        } else {
            System.out.println("ERROR: issue with moving Office 'Office 3' from Building 'Example Inc. Headquarters' to 'Example Inc. Asia'");
        }

        // Test change Offices (add and remove Rooms)
        testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(1).addRoom("Conference Room 2", testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(2).getRoom("Conference Room 2"));
        testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(2).removeRoom("Conference Room 2");
        if (testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(1).getRoom("Conference Room 2") != null &&
                testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(2).getRoom("Conference Room 2") == null) {
            System.out.println("Room 'Conference Room 2' successfully moved from Office 'Office 2' to Office 'Office 1'");
        } else {
            System.out.println("ERROR: issue with moving Room 'Conference Room 2' from Office 'Office 2' to Office 'Office 1'");
        }
        testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(2).addRoom("Accounting",testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(1).getRoom("Accounting"));
        testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(1).removeRoom("Accounting");
        if (testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(2).getRoom("Accounting") != null &&
                testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(1).getRoom("Accounting") == null) {
            System.out.println("Room 'Accounting' successfully moved from Office 'Office 1' to Office 'Office 2'");
        } else {
            System.out.println("ERROR: issue with moving Room 'Accounting' from Office 'Office 1' to Office 'Office 2'");
        }
        testGenCompany_ExInc.getBuilding("Example Inc. Asia").getOffice(4).addRoom("Accounting",testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(2).getRoom("Accounting"));
        testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(2).removeRoom("Accounting");
        if (testGenCompany_ExInc.getBuilding("Example Inc. Asia").getOffice(4).getRoom("Accounting") != null &&
                testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(2).getRoom("Accounting") == null) {
            System.out.println("Room 'Accounting' successfully moved from Office 'Office 2' in Building 'Example Inc. Headquarters' to Office 'Office 4' in Building 'Example Inc. Asia'");
        } else {
            System.out.println("ERROR: issue with moving Room 'Accounting' from Office 'Office 2' in Building 'Example Inc. Headquarters' to 'Office 4' in Building 'Example Inc. Asia'");
        }

        // Test change usage for Rooms
        Space oldSpaceCF1 = testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(1).getRoom("Conference Room 1").space();
        testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(1).getRoom("Conference Room 1").setSpace(new StorageSpace(100));
        if (oldSpaceCF1 instanceof WorkSpace &&
                testGenCompany_ExInc.getBuilding("Example Inc. Headquarters").getOffice(1).getRoom("Conference Room 1").space() instanceof StorageSpace) {
            System.out.println("Room 'Conference Room 1' successfully changed its usage from 'WorkSpace' to 'StorageSpace'");
        } else {
            System.out.println("ERROR: issue with changing usage of Room 'Conference Room 1' from 'WorkSpace' to 'StorageSpace'");
        }
        Space oldSpaceOM = testGenCompany_ExInc.getBuilding("Example Inc. Asia").getOffice(4).getRoom("Office Materials").space();
        testGenCompany_ExInc.getBuilding("Example Inc. Asia").getOffice(4).getRoom("Office Materials").setSpace(new WorkSpace(2));
        if (oldSpaceOM instanceof StorageSpace &&
                testGenCompany_ExInc.getBuilding("Example Inc. Asia").getOffice(4).getRoom("Office Materials").space() instanceof WorkSpace) {
            System.out.println("Room 'Office Materials' successfully changed its usage from 'StorageSpace' to 'WorkSpace'");
        } else {
            System.out.println("ERROR: issue with changing usage of Room 'Office Materials' from 'StorageSpace' to 'WorkSpace'");
        }

        // Test output all statistics
        System.out.println();
        testGenCompany_ExInc.print();
    }
}
