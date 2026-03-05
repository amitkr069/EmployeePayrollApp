package com.service;

public class SessionManager {

    private static String activeUser = null;

    public static void startSession(String username) {
        activeUser = username;
        System.out.println("\nSession active for user: " + username);
    }

    public static void endSession() {
        activeUser = null;
        System.out.println("Session ended.");
    }

    public static boolean isSessionActive() {
        return activeUser != null;
    }
}
