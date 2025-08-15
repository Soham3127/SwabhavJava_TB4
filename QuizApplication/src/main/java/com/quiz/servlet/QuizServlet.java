package com.quiz.servlet;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.quiz.dao.QuestionDAO;
import com.quiz.model.Question;
import com.quiz.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {
    private QuestionDAO questionDAO = new QuestionDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            response.sendRedirect("login.html");
            return;
        }
        
        // Initialize quiz session
        List<Question> questions = questionDAO.getRandomQuestions(5);
        session.setAttribute("questions", questions);
        session.setAttribute("currentQuestion", 0);
        session.setAttribute("answers", new HashMap<Integer, String>());
        session.setAttribute("bookmarked", new HashMap<Integer, Boolean>());
        session.setAttribute("startTime", System.currentTimeMillis());
        
        response.sendRedirect("quiz.html");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            response.sendRedirect("login.html");
            return;
        }
        
        String action = request.getParameter("action");
        
        if ("next".equals(action) || "previous".equals(action) || "jump".equals(action)) {
            handleNavigation(request, response, session);
        } else if ("bookmark".equals(action)) {
            handleBookmark(request, response, session);
        } else if ("review".equals(action)) {
            response.sendRedirect("review.html");
        }
    }
    
    private void handleNavigation(HttpServletRequest request, HttpServletResponse response, 
                                HttpSession session) throws IOException {
        
        String action = request.getParameter("action");
        int currentQuestion = (Integer) session.getAttribute("currentQuestion");
        String selectedAnswer = request.getParameter("answer");
        
        // Save current answer
        if (selectedAnswer != null) {
            Map<Integer, String> answers = (Map<Integer, String>) session.getAttribute("answers");
            answers.put(currentQuestion, selectedAnswer);
            session.setAttribute("answers", answers);
        }
        
        if ("next".equals(action)) {
            currentQuestion++;
        } else if ("previous".equals(action)) {
            currentQuestion--;
        } else if ("jump".equals(action)) {
            String questionIndex = request.getParameter("questionIndex");
            currentQuestion = Integer.parseInt(questionIndex);
        }
        
        session.setAttribute("currentQuestion", currentQuestion);
        
        if (currentQuestion >= 5) {
            response.sendRedirect("review.html");
        } else {
            response.sendRedirect("quiz.html");
        }
    }
    
    private void handleBookmark(HttpServletRequest request, HttpServletResponse response, 
                              HttpSession session) throws IOException {
        
        int currentQuestion = (Integer) session.getAttribute("currentQuestion");
        Map<Integer, Boolean> bookmarked = (Map<Integer, Boolean>) session.getAttribute("bookmarked");
        
        boolean isBookmarked = bookmarked.getOrDefault(currentQuestion, false);
        bookmarked.put(currentQuestion, !isBookmarked);
        session.setAttribute("bookmarked", bookmarked);
        
        response.sendRedirect("quiz.html");
    }
}