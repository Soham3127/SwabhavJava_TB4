package com.aurionpro.mini.project03.StudentPerformanceSystem;

class ArtsStudent extends Student {
    private int history, politicalScience, sociology;

    public ArtsStudent(String name, int rollNumber, int history, int politicalScience, int sociology , String stream ) {
        super(name, rollNumber, stream );
        this.history = history;
        this.politicalScience = politicalScience;
        this.sociology = sociology;
    }

    public double calculatePerformance() {
        return (history + politicalScience + sociology) / 3.0;
    }

    public  void showMarks() {
        System.out.println("History: " + history + ", Political Science: " + politicalScience + ", Sociology: " + sociology);
    }
}
