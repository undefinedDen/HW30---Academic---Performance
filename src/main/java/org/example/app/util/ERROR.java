package org.example.app.util;

public enum ERROR {
    INCORRECT_OPERATOR(">>Incorrect operator inputted<<"),
    INCORRECT_ID(">>Incorrect id was  inputted<<"),
    INCORRECT_NAME(">>Incorrect name was inputted<<"),
    INCORRECT_EMAIL(">>Incorrect email was inputted<<"),
    INCORRECT_MARK(">>Incorrect mark was inputted<<"),
    ABSENT_DATA(">>Data is Absent<<")
    ;

    private final String message;
     ERROR(String message){
        this.message = message;
    }

    public String getMessage() {
         return message;
    }
}
