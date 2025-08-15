package com.quiz.util;


import java.util.regex.Pattern;

public class ValidationUtils {
    
    private static final String EMAIL_PATTERN = 
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    
    private static final String PASSWORD_PATTERN = 
        "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$";
    
    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
    private static final Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);
    
    public static boolean isValidEmail(String email) {
        return email != null && emailPattern.matcher(email).matches();
    }
    
    public static boolean isValidPassword(String password) {
        return password != null && passwordPattern.matcher(password).matches();
    }
    
    public static boolean isValidUsername(String username) {
        return username != null && 
               username.trim().length() >= 3 && 
               username.trim().length() <= 50 &&
               username.matches("^[a-zA-Z0-9_]+$");
    }
    
    public static String sanitizeInput(String input) {
        if (input == null) return null;
        return input.trim()
                   .replaceAll("<", "&lt;")
                   .replaceAll(">", "&gt;")
                   .replaceAll("\"", "&quot;")
                   .replaceAll("'", "&#x27;")
                   .replaceAll("/", "&#x2F;");
    }
}
