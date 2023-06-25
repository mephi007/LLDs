package org.example;

public class Vehicle {
    private String regNo;
    private String color;
    private VehicleType type;

    public Vehicle(String regNo, String color, VehicleType type){
        this.regNo = regNo;
        this.color = color;
        this.type = type;
    }

    public String getRegNo(){
        return this.regNo;
    }

    public String getColor(){
        return this.color;
    }

    public String getType(){
        return this.type.toString();
    }
}
