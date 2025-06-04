package org.example.app.util;

public enum SUCCESS {
    CREATED(">>Created<<"),
    DELETED(">>Deleted<<"),
    UPDATED(">>Updated<<")
    ;
    private final String message;
    SUCCESS(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
