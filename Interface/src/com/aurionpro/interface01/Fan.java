package com.aurionpro.interface01;

public   class Fan implements IControllable {
    public void turnOn() {
        System.out.println("Fan turned ON");
    }
    public void turnOff() {
        System.out.println("Fan turned OFF");
    }
    public void setMode(String mode) {
        System.out.println("Fan mode set to: " + mode);
    }
}
