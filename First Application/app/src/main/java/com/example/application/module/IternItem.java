package com.example.application.module;

public class IternItem {
    private String title;
    private String publishedDate;
    private String role;
    private String address;
    private String companyName;
    private String appliedByNo;

    public IternItem(){

    }

    public IternItem(String title, String publishedDate, String role, String address, String companyName, String appliedByNo) {
        this.title = title;
        this.publishedDate = publishedDate;
        this.role = role;
        this.address = address;
        this.companyName = companyName;
        this.appliedByNo = appliedByNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAppliedByNo() {
        return appliedByNo;
    }

    public void setAppliedByNo(String appliedByNo) {
        this.appliedByNo = appliedByNo;
    }
}
