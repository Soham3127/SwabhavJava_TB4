package com.quiz.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.quiz.model.Question;
import com.quiz.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/quiz-data")
public class QuizDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Question> questions = (List<Question>) session.getAttribute("questions");
        Integer currentQuestionIndex = (Integer) session.getAttribute("currentQuestion");
        Map<Integer, String> answers = (Map<Integer, String>) session.getAttribute("answers");
        Map<Integer, Boolean> bookmarked = (Map<Integer, Boolean>) session.getAttribute("bookmarked");
        Long startTime = (Long) session.getAttribute("startTime");

        if (questions == null || currentQuestionIndex == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        // Current question data
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            
            jsonBuilder.append("\"currentQuestion\":{");
            jsonBuilder.append("\"id\":").append(currentQuestion.getId()).append(",");
            jsonBuilder.append("\"questionText\":\"").append(escapeJson(currentQuestion.getQuestionText())).append("\",");
            jsonBuilder.append("\"optionA\":\"").append(escapeJson(currentQuestion.getOptionA())).append("\",");
            jsonBuilder.append("\"optionB\":\"").append(escapeJson(currentQuestion.getOptionB())).append("\",");
            jsonBuilder.append("\"optionC\":\"").append(escapeJson(currentQuestion.getOptionC())).append("\",");
            jsonBuilder.append("\"optionD\":\"").append(escapeJson(currentQuestion.getOptionD())).append("\"");
            jsonBuilder.append("},");
        }

        jsonBuilder.append("\"currentQuestionIndex\":").append(currentQuestionIndex).append(",");
        jsonBuilder.append("\"totalQuestions\":").append(questions.size()).append(",");
        
        String selectedAnswer = answers.get(currentQuestionIndex);
        if (selectedAnswer != null) {
            jsonBuilder.append("\"selectedAnswer\":\"").append(escapeJson(selectedAnswer)).append("\",");
        } else {
            jsonBuilder.append("\"selectedAnswer\":null,");
        }
        
        jsonBuilder.append("\"isBookmarked\":").append(bookmarked.getOrDefault(currentQuestionIndex, false)).append(",");
        jsonBuilder.append("\"startTime\":").append(startTime).append(",");

        // Progress data
        int answeredCount = 0;
        int bookmarkedCount = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (answers.containsKey(i)) answeredCount++;
            if (bookmarked.getOrDefault(i, false)) bookmarkedCount++;
        }

        jsonBuilder.append("\"answeredCount\":").append(answeredCount).append(",");
        jsonBuilder.append("\"bookmarkedCount\":").append(bookmarkedCount);

        jsonBuilder.append("}");

        PrintWriter out = response.getWriter();
        out.print(jsonBuilder.toString());
    }
    
    private String escapeJson(String str) {
        if (str == null) return "";
        return str.replace("\\", "\\\\")
                 .replace("\"", "\\\"")
                 .replace("\n", "\\n")
                 .replace("\r", "\\r")
                 .replace("\t", "\\t");
    }
}