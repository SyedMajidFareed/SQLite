package com.example.sql_example;

public class Student {
    private int Id;
    private String Student_Name;
    private String Student_Roll;

    public Student(int id, String student_Name, String student_Roll) {
        Id = id;
        Student_Name = student_Name;
        Student_Roll = student_Roll;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
