package com.example.parentportal.ViewModels;

public class StudentProgressViewModel {
    String studentName, studentClass;
    int attendance, progress, studentId;

    public StudentProgressViewModel(String studentName, String studentClass, int attendance, int progress, int studentId) {
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.attendance = attendance;
        this.progress = progress;
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
