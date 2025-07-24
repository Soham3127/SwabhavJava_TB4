package com.aurionpro.interface01;

public class Truck implements IVehicleControl {
    public void start() {
        System.out.println("Truck started.");
    }
    public void stop() {
        System.out.println("Truck stopped.");
    }
    public void changeGear(int gear) {
        System.out.println("Truck changed to gear " + gear);
    }
}

