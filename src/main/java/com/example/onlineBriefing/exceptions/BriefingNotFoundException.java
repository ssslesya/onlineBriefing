package com.example.onlineBriefing.exceptions;

public class BriefingNotFoundException extends RuntimeException{
    public BriefingNotFoundException(Integer id) {
        super("No briefing found.");
    }
}
