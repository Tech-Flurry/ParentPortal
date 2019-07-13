package com.example.parentportal.ViewModels;

import java.util.Date;

public class DairyViewModel {
    String body, subjectName;
    long id;
    String date;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DairyViewModel(String body, String subjectName,String date, long id) {
        this.body = body;
        this.subjectName = subjectName;
        this.id = id;
        this.date = date;
    }
}
