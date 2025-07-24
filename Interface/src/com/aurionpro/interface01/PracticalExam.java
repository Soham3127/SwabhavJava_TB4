package com.aurionpro.interface01;

public class PracticalExam implements IExamEvaluator {
    private int marks;

    public void evaluateMarks(int marks) {
        this.marks = marks;
    }

    public String calculateGrade() {
        if (marks < 35) return "Fail";
        else if (marks >= 85) return "Distinction";
        else return "Pass";
    }
}
