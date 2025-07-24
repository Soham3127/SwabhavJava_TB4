package com.aurionpro.reflection;

public class Plugin {
    private double version;

    private Plugin() {
       
    }

    public void execute() {
        System.out.println("Plugin executed");
    }
}
