package org.example.app.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreateStudentView {
    Scanner scanner = new Scanner(System.in);
    public Map<String, String> getData(){
        Map<String, String> data = new HashMap<>();
        System.out.print("Input student name(only letters): ");
        data.put("student_name", scanner.nextLine());
        System.out.print("Input student email(example: x@x): ");
        data.put("student_email", scanner.nextLine());
        System.out.print("Input student mark(from 1 - 5): ");
        data.put("student_mark", scanner.nextLine());
        return data;
    }
    public void getOutput(String output) {
        System.out.println(output);
    }
}
