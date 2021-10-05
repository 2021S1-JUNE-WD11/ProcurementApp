package com.example.procurementapp.models;

public class UserModel {

    //declare variables
    String firstname;
    String Lastname;
    String  nic;
    String  siteLoc;
    String mobile;
    String email;
    String Password;

    public UserModel() {
    }

    //Create getters and setters
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getSiteLoc() {
        return siteLoc;
    }

    public void setSiteLoc(String siteLoc) {
        this.siteLoc = siteLoc;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    //Create constructor
    public UserModel(String firstname, String lastname, String nic, String siteLoc, String mobile, String email, String password) {
        this.firstname = firstname;
        Lastname = lastname;
        this.nic = nic;
        this.siteLoc = siteLoc;
        this.mobile = mobile;
        this.email = email;
        Password = password;
    }
}
