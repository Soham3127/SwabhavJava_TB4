package com.aurionpro.interface01;

public   class Speaker implements IControllable {
    public void turnOn() {
        System.out.println("Speaker  turned ON");
    }
    public void turnOff() {
        System.out.println("Speaker turned OFF");
    }
    public void setMode(String mode) {
        System.out.println("Speaker mode set to: " + mode);
    }
}

