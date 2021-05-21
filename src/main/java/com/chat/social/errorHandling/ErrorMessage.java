package com.chat.social.errorHandling;

public class ErrorMessage {
    private String message;

    public ErrorMessage(Exception e){
        this.message = e.getMessage();
    }

    public String getMessage() {
        return message;
    }    
    
}
