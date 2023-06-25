package org.example;

import java.util.HashMap;
import java.util.Map;

public class Slot {
    private int slotNumber;
    private int floorNumber;
    private Vehicle vehicle;
    private VehicleType slotType;
    private boolean isBooked;
//    private Map<String, Ticket> ticketMapping = new HashMap();

    public Slot(int slotNumber, int floorNumber, VehicleType slotType){
        this.slotNumber =slotNumber;
        this.floorNumber = floorNumber;
        this.slotType = slotType;
        isBooked = false;
    }

    public boolean getIsBooked(){
        return this.isBooked;
    }

    public void setIsBooked(boolean setBooked){
        this.isBooked = setBooked;
    }

//    public Ticket getParkingTicket(Vehicle vehicle){
//        Ticket ticket = new Ticket(vehicle, this);
//        ticketMapping.put(ticket.getUuid(), ticket);
//        return
//    }

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void removeVehicle(){
        this.vehicle = null;
    }

    public String generateTicketID() {
        return "_" + (this.floorNumber + 1) + "_" + (this.slotNumber + 1);
    }


    public int getFloorNumber() {
        return this.floorNumber;
    }

    public int getSlotNumber(){
        return this.slotNumber;
    }

    public String getVehicleType() {
        return this.slotType.toString();
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }
}
