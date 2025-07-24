package com.aurionpro.interface01;

public  class Light implements IControllable {
    public void turnOn() {
        System.out.println("Light turned ON");
    }
    public void turnOff() {
        System.out.println("Light turned OFF");
    }
    public void setMode(String mode) {
        System.out.println("Light mode set to: " + mode);
    }
}
