package com.quiz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import com.quiz.dao.QuizResultDAO;
import com.quiz.model.QuizResult;
import com.quiz.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    private QuizResultDAO resultDAO = new QuizResultDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.html");
            return;
        }

        String dataParam = request.getParameter("data");

        if ("json".equals(dataParam)) {
            // Return JSON data
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            List<QuizResult> results = resultDAO.getUserQuizHistory(user.getId());

            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("[");
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (int i = 0; i < results.size(); i++) {
                QuizResult result = results.get(i);
                
                if (i > 0) {
                    jsonBuilder.append(",");
                }
                
                jsonBuilder.append("{");
                jsonBuilder.append("\"score\":").append(result.getScore()).append(",");
                jsonBuilder.append("\"totalQuestions\":").append(result.getTotalQuestions()).append(",");
                jsonBuilder.append("\"percentage\":").append((result.getScore() * 100.0) / result.getTotalQuestions()).append(",");
                jsonBuilder.append("\"timeTaken\":").append(result.getTimeTaken()).append(",");
                jsonBuilder.append("\"completionTime\":\"").append(escapeJson(dateFormat.format(result.getCompletionTime()))).append("\"");
                jsonBuilder.append("}");
            }

            jsonBuilder.append("]");

            PrintWriter out = response.getWriter();
            out.print(jsonBuilder.toString());
        } else {
            // Redirect to history page
            response.sendRedirect("history.html");
        }
    }
    
    private String escapeJson(String str) {
        if (str == null) return "null";
        return str.replace("\\", "\\\\")
                 .replace("\"", "\\\"")
                 .replace("\n", "\\n")
                 .replace("\r", "\\r")
                 .replace("\t", "\\t");
    }
}