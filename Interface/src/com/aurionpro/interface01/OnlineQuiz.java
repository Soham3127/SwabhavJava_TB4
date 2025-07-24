package com.aurionpro.interface01;

public class OnlineQuiz implements IExamEvaluator {
    private int marks;

    public void evaluateMarks(int marks) {
        this.marks = marks;
    }

    public String calculateGrade() {
        if (marks < 30) return "Fail";
        else if (marks < 60) return "Can Improve";
        else if (marks < 80) return "Good";
        else return "Excellent";
    }
}
