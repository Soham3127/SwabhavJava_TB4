package com.aurionpro.interface01;

public class Car2 implements IVehicleControl {
    public void start() {
        System.out.println("Car started.");
    }
    public void stop() {
        System.out.println("Car stopped.");
    }
    public void changeGear(int gear) {
        System.out.println("Car changed to gear " + gear);
    }
}
