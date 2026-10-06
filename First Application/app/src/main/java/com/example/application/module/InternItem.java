package com.example.application.module;

public class InternItem {

    private String title;
    private String date;
    private String role;
    private String location;
    private String companyName;

    public InternItem(String title, String date, String role,
                      String location, String companyName) {

        this.title = title;
        this.date = date;
        this.role = role;
        this.location = location;
        this.companyName = companyName;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getRole() {
        return role;
    }

    public String getLocation() {
        return location;
    }

    public String getCompanyName() {
        return companyName;
    }

}
