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

@WebServlet("/result-data")
public class ResultDataServlet extends HttpServlet {

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
        Map<Integer, String> answers = (Map<Integer, String>) session.getAttribute("answers");
        Integer lastScore = (Integer) session.getAttribute("lastScore");
        Long lastTimeTaken = (Long) session.getAttribute("lastTimeTaken");

        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        
        jsonBuilder.append("\"score\":").append(lastScore).append(",");
        jsonBuilder.append("\"totalQuestions\":").append(questions.size()).append(",");
        jsonBuilder.append("\"timeTaken\":").append(lastTimeTaken).append(",");
        jsonBuilder.append("\"percentage\":").append((lastScore * 100.0) / questions.size()).append(",");

        // Question details
        jsonBuilder.append("\"questions\":[");
        
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            String userAnswer = answers.get(i);

            if (i > 0) {
                jsonBuilder.append(",");
            }
            
            jsonBuilder.append("{");
            jsonBuilder.append("\"questionText\":\"").append(escapeJson(question.getQuestionText())).append("\",");
            jsonBuilder.append("\"optionA\":\"").append(escapeJson(question.getOptionA())).append("\",");
            jsonBuilder.append("\"optionB\":\"").append(escapeJson(question.getOptionB())).append("\",");
            jsonBuilder.append("\"optionC\":\"").append(escapeJson(question.getOptionC())).append("\",");
            jsonBuilder.append("\"optionD\":\"").append(escapeJson(question.getOptionD())).append("\",");
            jsonBuilder.append("\"correctAnswer\":\"").append(escapeJson(question.getCorrectAnswer())).append("\",");
            
            if (userAnswer != null) {
                jsonBuilder.append("\"userAnswer\":\"").append(escapeJson(userAnswer)).append("\",");
            } else {
                jsonBuilder.append("\"userAnswer\":null,");
            }
            
            boolean isCorrect = userAnswer != null && userAnswer.equals(question.getCorrectAnswer());
            jsonBuilder.append("\"isCorrect\":").append(isCorrect);
            
            jsonBuilder.append("}");
        }

        jsonBuilder.append("]");
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