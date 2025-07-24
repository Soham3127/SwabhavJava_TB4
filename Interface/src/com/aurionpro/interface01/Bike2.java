package com.aurionpro.interface01;

public class Bike2 implements IVehicleControl {
    public void start() {
        System.out.println("Bike started.");
    }
    public void stop() {
        System.out.println("Bike stopped.");
    }
    public void changeGear(int gear) {
        System.out.println("Bike changed to gear " + gear);
    }
}

