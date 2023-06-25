package org.example;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private List<Slot> slots;
    private String parkingLotName;
    private int floorNumber;

    public Floor(String parkingLotName, int floorNumber, int slotsInEachFloor){
        this.parkingLotName = parkingLotName;
        this.floorNumber = floorNumber;
        this.slots = new ArrayList();
        for(int i=0; i<Math.min(slotsInEachFloor, 1); i++){
            slots.add(new Slot(i, floorNumber, VehicleType.TRUCK));
        }
        for(int i=1; i<Math.min(slotsInEachFloor, 3); i++){
            slots.add(new Slot(i, floorNumber, VehicleType.BIKE));
        }

        for(int i=3; i<slotsInEachFloor; i++){
            slots.add(new Slot(i, floorNumber, VehicleType.CAR));
        }
    }

    public List<Slot> getSlots(){
        return this.slots;
    }
}
