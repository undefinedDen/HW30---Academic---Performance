package org.example.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long studentId;
    @Column(name = "name")
    private String studentName;
    @Column(name = "email")
    private String studentEmail;
    @Column(name = "mark")
    private short studentMark;


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public short getStudentMark() {
        return studentMark;
    }

    public void setStudentMark(short studentMark) {
        this.studentMark = studentMark;
    }

    @Override
    public String toString() {
        return "name: " + studentName +
                ", email: " + studentEmail +
                ", mark: " + studentMark;
    }
}
