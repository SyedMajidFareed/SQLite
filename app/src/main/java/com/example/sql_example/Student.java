package com.example.sql_example;

public class Student {
    private String Student_Name;
    private String Student_Roll;

    public Student(String student_Name, String student_Roll) {
        Student_Name = student_Name;
        Student_Roll = student_Roll;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public String getStudent_Roll() {
        return Student_Roll;
    }

    public void setStudent_Roll(String student_Roll) {
        Student_Roll = student_Roll;
    }
}
