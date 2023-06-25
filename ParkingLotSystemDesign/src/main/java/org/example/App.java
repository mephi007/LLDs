package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello Parking Lot System!" );
        ParkingLot parkingLot = new ParkingLot("Parking1234", 2, 6);
        System.out.println(parkingLot.toString());
        parkingLot.displayFreeCount("CAR");
        parkingLot.displayFreeSlots("BIKE");
        parkingLot.parkVehicle("CAR", "CAR KA-01-DB-1234",  "black");
        parkingLot.displayOccupiedSlots("CAR");
        parkingLot.displayFreeSlots("CAR");
        parkingLot.unParkVehicle("Parking1234_1_4");
        parkingLot.displayFreeSlots("CAR");
    }
}
