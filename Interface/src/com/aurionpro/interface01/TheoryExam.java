package com.aurionpro.interface01;

public class TheoryExam implements IExamEvaluator {
    private int marks;

    public void evaluateMarks(int marks) {
        this.marks = marks;
    }

    public String calculateGrade() {
        if (marks < 35) return "Fail";
        else if (marks < 50) return "C";
        else if (marks < 70) return "B";
        else return "A";
    }
}
