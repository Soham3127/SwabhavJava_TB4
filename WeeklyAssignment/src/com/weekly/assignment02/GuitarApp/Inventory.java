package com.weekly.assignment02.GuitarApp;

import java.util.*;

public class Inventory {
    private List<Guitar> guitars = new ArrayList<>();

    public void addGuitar(String serialNumber, double price, GuitarSpec spec) {
        guitars.add(new Guitar(serialNumber, price, spec));
    }

    public List<Guitar> getAllGuitars() {
        return new ArrayList<>(guitars); // return copy to avoid direct mutation
    }

    public List<Guitar> searchGuitars(List<Guitar> list, GuitarSpec searchSpec, Integer numStrings) {
        List<Guitar> matched = new ArrayList<>();

        for (Guitar guitar : list) {
            GuitarSpec spec = guitar.getSpec();

            if (searchSpec.getBuilder() != null && !searchSpec.getBuilder().equals(spec.getBuilder()))
                continue;
            if (searchSpec.getModel() != null && (spec.getModel() == null ||
                !searchSpec.getModel().equalsIgnoreCase(spec.getModel())))
                continue;
            if (searchSpec.getType() != null && !searchSpec.getType().equals(spec.getType()))
                continue;
            if (numStrings != null && !numStrings.equals(spec.getNumStrings()))
                continue;
            if (searchSpec.getBackWood() != null && !searchSpec.getBackWood().equals(spec.getBackWood()))
                continue;
            if (searchSpec.getTopWood() != null && !searchSpec.getTopWood().equals(spec.getTopWood()))
                continue;

            matched.add(guitar);
        }

        return matched;
    }

    public void displayTable(List<Guitar> guitars) {
        System.out.println("+----+------------+------------+------------+--------------+----------+---------+------------------+----------------+");
        System.out.println("| #  | Serial No  | Price      | Builder    | Model        | Type     | Strings | Back Wood        | Top Wood       |");
        System.out.println("+----+------------+------------+------------+--------------+----------+---------+------------------+----------------+");
        for (int i = 0; i < guitars.size(); i++) {
            guitars.get(i).display(i);
        }
        System.out.println("+----+------------+------------+------------+--------------+----------+---------+------------------+----------------+");
    }
}