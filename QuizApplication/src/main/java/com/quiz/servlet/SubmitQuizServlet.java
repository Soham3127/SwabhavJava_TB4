package com.quiz.servlet;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.quiz.dao.QuizResultDAO;
import com.quiz.model.Question;
import com.quiz.model.QuizResult;
import com.quiz.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/submit-quiz")
public class SubmitQuizServlet extends HttpServlet {
    private QuizResultDAO resultDAO = new QuizResultDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            response.sendRedirect("login.html");
            return;
        }
        
        List<Question> questions = (List<Question>) session.getAttribute("questions");
        Map<Integer, String> answers = (Map<Integer, String>) session.getAttribute("answers");
        Long startTime = (Long) session.getAttribute("startTime");
        
        if (questions == null || answers == null || startTime == null) {
            response.sendRedirect("quiz");
            return;
        }
        
        // Calculate score
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            String userAnswer = answers.get(i);
            if (userAnswer != null && userAnswer.equals(question.getCorrectAnswer())) {
                score++;
            }
        }
        
        // Calculate time taken (in seconds)
        long timeTaken = (System.currentTimeMillis() - startTime) / 1000;
        
        // Save result
        QuizResult result = new QuizResult(user.getId(), score, questions.size(), timeTaken);
        resultDAO.saveQuizResult(result);
        
        // Store result in session for display
        session.setAttribute("lastScore", score);
        session.setAttribute("lastTimeTaken", timeTaken);
        
        response.sendRedirect("result.html");
    }
}