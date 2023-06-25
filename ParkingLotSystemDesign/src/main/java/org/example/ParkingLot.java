package org.example;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Floor> floors;
    private String name;

    public ParkingLot(String name, int floorCount, int slotsInEachFloor){
        this.name = name;
        this.floors = new ArrayList();
        for(int i=0; i<floorCount; i++){
            floors.add(new Floor(name, i, slotsInEachFloor));
        }
    }

    public void parkVehicle(String vehicleType, String regNo, String color) {
        boolean isFull = true;
        for(int i=0; i< floors.size(); i++){
            List<Slot> slots = floors.get(i).getSlots();
            for(Slot slot: slots){
                if(!slot.getIsBooked() && vehicleType.toUpperCase().equals(slot.getVehicleType())){
                    slot.setIsBooked(true);
                    Vehicle vehicle = new Vehicle(regNo, color, VehicleType.valueOf(vehicleType));
                    slot.setVehicle(vehicle);
                    String ticketId = slot.generateTicketID();
                    isFull = false;
                    System.out.println("vehicle parked at : " + ticketId);
                    return;
                }
            }
        }
        if(isFull){
            System.out.println("Parking Full");
        }
    }

    public void unParkVehicle(String ticket){
        String[] input = ticket.trim().split("_");
        int floorNumber = Integer.parseInt(input[1]) - 1;
        int slotNumber = Integer.parseInt(input[2]) - 1;
        Vehicle freeVehicle = null;
        if(input[0].equals(name) && floorNumber < floors.size() && slotNumber < floors.get(0).getSlots().size()) {
            Slot slot = floors.get(floorNumber).getSlots().get(slotNumber);
            if(slot.getIsBooked()){
                slot.setIsBooked(false);
                freeVehicle = slot.getVehicle();
                slot.setVehicle(null);
                return;
            }
        }
        System.out.println("Invalid Ticket");
        return;

    }

    public void displayFreeCount(String vehicleType){
        for(int i=0; i< floors.size(); i++){
            int freeCount = 0;
            List<Slot> slots = floors.get(i).getSlots();
            for(Slot slot: slots){
                if(!slot.getIsBooked() && vehicleType.toUpperCase().equals(slot.getVehicleType())){
                    freeCount++;
                }
            }
            System.out.println("No. of free slots for CAR on Floor " + (i+1) + " : " + freeCount);
        }
    }

    public void displayFreeSlots(String vehicleType){
        for(int i=0; i<floors.size(); i++){
            StringBuilder sb = new StringBuilder("Free slots for ");
            sb.append(vehicleType + " on Floor " + (i+1) + " : ");
            List<Slot> slots = floors.get(i).getSlots();
            for(Slot slot: slots){
                if(!slot.getIsBooked() && vehicleType.toUpperCase().equals(slot.getVehicleType())){
                    sb.append(slot.getSlotNumber() + ", ");
                }
            }
            System.out.println(sb);
        }
    }

    public void displayOccupiedSlots(String vehicle_type){
        for(int i =0; i<floors.size(); i++){
            List<Slot> slots = floors.get(i).getSlots();
            for(Slot slot: slots){
                if(slot.getIsBooked()){
                    System.out.println(slot.getSlotNumber() + " on floor " + (i+1) + " is oocuppied ");
                }
            }
        }
    }

    public String toString(){
        return "created parking lot " + this.name + " having " + this.floors.size() + " floors";
    }

}
