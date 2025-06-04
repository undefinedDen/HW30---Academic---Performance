package org.example.app.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeleteStudentView {
    Scanner scanner = new Scanner(System.in);

    public Map<String, String> getData() {
        Map<String, String> data = new HashMap<>();
        System.out.print("Input student id for delete: ");
        data.put("id", scanner.nextLine());
        return data;
    }
    public void getOutput(String output) {
        System.out.println(output);
    }
}
