package org.example.app.exception;

import java.util.HashMap;
import java.util.Map;

public class StudentException extends RuntimeException {
    Map<String, String> errors;

    public StudentException(String message, Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }

    public String showErrors(Map<String, String> errors) {
        this.errors = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        errors.forEach(
                (key, message) ->
                        stringBuilder.append("\n")
                                .append(key)
                                .append(": ")
                                .append(message)
        );
        return stringBuilder.toString();
    }
}
