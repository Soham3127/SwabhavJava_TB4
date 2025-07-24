package com.aurionpro.mini.project03.StudentPerformanceSystem;

class ScienceStudent extends Student {
    private int physics, chemistry, maths;

    public ScienceStudent (String name, int rollNumber, int physics, int chemistry, int maths, String stream ) {
        super(name, rollNumber, stream);
        this.physics = physics;
        this.chemistry = chemistry;
        this.maths = maths;
    }

    public double calculatePerformance() {
        return (physics + chemistry + maths) / 3.0;
    }

    public void showMarks() {
        System.out.println("Physics: " + physics + ", Chemistry: " + chemistry + ", Maths: " + maths);
    }
}



