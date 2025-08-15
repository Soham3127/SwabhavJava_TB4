package com.quiz.dao;

import com.quiz.model.QuizResult;
import com.quiz.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizResultDAO {
    
    public boolean saveQuizResult(QuizResult result) {
        String sql = "INSERT INTO quiz_results (user_id, score, total_questions, time_taken) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, result.getUserId());
            ps.setInt(2, result.getScore());
            ps.setInt(3, result.getTotalQuestions());
            ps.setLong(4, result.getTimeTaken());
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseConnection.closeConnection(conn, ps, null);
        }
    }
    
    public List<QuizResult> getUserQuizHistory(int userId) {
        String sql = "SELECT * FROM quiz_results WHERE user_id = ? ORDER BY completion_time DESC";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<QuizResult> results = new ArrayList<>();
        
        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                QuizResult result = new QuizResult();
                result.setId(rs.getInt("id"));
                result.setUserId(rs.getInt("user_id"));
                result.setScore(rs.getInt("score"));
                result.setTotalQuestions(rs.getInt("total_questions"));
                result.setCompletionTime(rs.getTimestamp("completion_time"));
                result.setTimeTaken(rs.getLong("time_taken"));
                results.add(result);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn, ps, rs);
        }
        
        return results;
    }
}
