package com.quiz.servlet;


import java.io.IOException;
import java.util.regex.Pattern;

import com.quiz.dao.UserDAO;
import com.quiz.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("register.html");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        
        // Validation
        String error = validateInput(username, email, password, confirmPassword);
        
        if (error != null) {
            response.sendRedirect("register.html?error=" + error);
            return;
        }
        
        // Check if username already exists
        if (userDAO.isUsernameExists(username)) {
            response.sendRedirect("register.html?error=Username already exists");
            return;
        }
        
        // Check if email already exists
        if (userDAO.isEmailExists(email)) {
            response.sendRedirect("register.html?error=Email already registered");
            return;
        }
        
        User user = new User(username, email, password);
        
        if (userDAO.registerUser(user)) {
            response.sendRedirect("login.html?success=Registration successful! Please login.");
        } else {
            response.sendRedirect("register.html?error=Registration failed. Please try again.");
        }
    }
    
    private String validateInput(String username, String email, String password, String confirmPassword) {
        if (username == null || username.trim().length() < 3) {
            return "Username must be at least 3 characters long";
        }
        
        if (email == null || !isValidEmail(email)) {
            return "Please enter a valid email address";
        }
        
        if (password == null || password.length() < 6) {
            return "Password must be at least 6 characters long";
        }
        
        if (!password.equals(confirmPassword)) {
            return "Passwords do not match";
        }
        
        // Password strength check
        if (!isStrongPassword(password)) {
            return "Password must contain at least one uppercase letter, one lowercase letter, and one number";
        }
        
        return null;
    }
    
    private boolean isValidEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(emailPattern, email);
    }
    
    private boolean isStrongPassword(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    }
}