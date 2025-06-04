package org.example.app.util;

import java.util.HashMap;
import java.util.Map;

public class AppValidator {
    private static final String ID_RGX = "^[0-9]+$";
    private static final String NAME_RGX = "^[A-Za-z\\s.]+$";
    private static final String EMAIL_RGX = "^[a-z0-9+_.-]+@[a-z0-9.-]+$";
    private static final String MARK_RGX = "^[1-5]$";

    private static boolean isIdValid(String id) {
        return id != null && id.matches(ID_RGX);
    }

    private static boolean isStudentNameValid(String name) {
        return name != null && !name.trim().isEmpty() && name.matches(NAME_RGX);
    }

    private static boolean isStudentEmailValid(String email) {
        return email != null && !email.trim().isEmpty() && email.matches(EMAIL_RGX);
    }

    private static boolean isStudentMarkValid(String mark) {
        return mark != null && !mark.trim().isEmpty() && mark.matches(MARK_RGX);
    }

    public static Map<String, String> validateStudents(Map<String, String> data) {
        Map<String, String> errors = new HashMap<>();
        if (data.containsKey("id") && !isIdValid(data.get("id"))) {
            errors.put("id", ERROR.INCORRECT_ID.getMessage());
        }
        if (data.containsKey("student_name") && !isStudentNameValid(data.get("student_name"))) {
            errors.put("student name", ERROR.INCORRECT_NAME.getMessage());
        }
        if (data.containsKey("student_email") && !isStudentEmailValid(data.get("student_email"))) {
            errors.put("student email", ERROR.INCORRECT_EMAIL.getMessage());
        }
        if (data.containsKey("student_mark") && !isStudentMarkValid(data.get("student_mark"))) {
            errors.put("student mark", ERROR.INCORRECT_MARK.getMessage());
        }
        return errors;
    }
}