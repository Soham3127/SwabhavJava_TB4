package com.quiz.util;


import java.util.List;

import com.quiz.model.Question;
import com.quiz.model.User;

import jakarta.servlet.http.HttpSession;

public class SessionManager {
    
    public static void initializeQuizSession(HttpSession session, User user, List<Question> questions) {
        session.setAttribute("user", user);
        session.setAttribute("userId", user.getId());
        session.setAttribute("username", user.getUsername());
        session.setAttribute("questions", questions);
        session.setAttribute("currentQuestion", 0);
        session.setAttribute("answers", new java.util.HashMap<Integer, String>());
        session.setAttribute("bookmarked", new java.util.HashMap<Integer, Boolean>());
        session.setAttribute("startTime", System.currentTimeMillis());
    }
    
    public static void clearQuizSession(HttpSession session) {
        session.removeAttribute("questions");
        session.removeAttribute("currentQuestion");
        session.removeAttribute("answers");
        session.removeAttribute("bookmarked");
        session.removeAttribute("startTime");
        session.removeAttribute("lastScore");
        session.removeAttribute("lastTimeTaken");
    }
    
    public static boolean isValidQuizSession(HttpSession session) {
        return session != null &&
               session.getAttribute("user") != null &&
               session.getAttribute("questions") != null &&
               session.getAttribute("startTime") != null;
    }
    
    public static long getElapsedTime(HttpSession session) {
        Long startTime = (Long) session.getAttribute("startTime");
        if (startTime == null) return 0;
        return (System.currentTimeMillis() - startTime) / 1000; // Return in seconds
    }
    
    public static boolean isTimeExpired(HttpSession session, int maxTimeInSeconds) {
        return getElapsedTime(session) > maxTimeInSeconds;
    }
}