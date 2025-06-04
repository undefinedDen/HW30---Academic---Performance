package org.example.app.entity;

import java.util.Map;

public class Mapper {
    public Student mapData(Map<String, String> data){
        Student student = new Student();
        if(data.containsKey("id")){
            student.setStudentId(Long.parseLong(data.get("id")));
        }
        if(data.containsKey("student_name")){
            student.setStudentName(data.get("student_name"));
        }
        if(data.containsKey("student_email")){
            student.setStudentEmail(data.get("student_email"));
        }
        if(data.containsKey("student_mark")){
            student.setStudentMark(Short.parseShort(data.get("student_mark")));
        }
        return student;
    }

}
