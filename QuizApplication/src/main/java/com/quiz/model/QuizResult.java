package com.quiz.model;

import java.sql.Timestamp;

public class QuizResult {
    private int id;
    private int userId;
    private int score;
    private int totalQuestions;
    private Timestamp completionTime;
    private long timeTaken; // in seconds
    
    public QuizResult() {}
    
    public QuizResult(int userId, int score, int totalQuestions, long timeTaken) {
        this.userId = userId;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.timeTaken = timeTaken;
    }
    
    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    
    public int getTotalQuestions() { return totalQuestions; }
    public void setTotalQuestions(int totalQuestions) { this.totalQuestions = totalQuestions; }
    
    public Timestamp getCompletionTime() { return completionTime; }
    public void setCompletionTime(Timestamp completionTime) { this.completionTime = completionTime; }
    
    public long getTimeTaken() { return timeTaken; }
    public void setTimeTaken(long timeTaken) { this.timeTaken = timeTaken; }
}
