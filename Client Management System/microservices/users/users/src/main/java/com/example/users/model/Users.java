package com.example.users.model;

import jakarta.persistence.*;

// Creating an Entity (i.e. Users Entity) And Inside the Entity Create Table annotation where we
// are specifying which table it has to create
@Entity
@Table(name = "users")

public class Users {
    // ID is annotation and provided by jakarta which does all the properties of ID's
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // Generated Value is used to Auto Increment the ID and generate the ID Value
    private long id;
    @Column(name = "username")
    private String userName;
    @Column(name = "useremail")
    private String useremail;

    @Column(name = "userphonenumber")
    private String userphonenumber;

    @Column(name = "userage")
    private int userage;
    @Column(name = "userinfo")
    private String userinfo;
    @Column(name = "password")
    private String password;

    // Default Constructor which has nothing to call
    public Users() {
    }

    // Parameterized Constructors which has username and password as the parameters

    public Users(String userName, String useremail, String userphonenumber, int userage, String userinfo, String password) {
        this.userName = userName;
        this.useremail = useremail;
        this.userphonenumber = userphonenumber;
        this.userage = userage;
        this.userinfo = userinfo;
        this.password = password;
    }


    // Getters And Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserphonenumber() {
        return userphonenumber;
    }

    public void setUserphonenumber(String userphonenumber) {
        this.userphonenumber = userphonenumber;
    }

    public int getUserage() {
        return userage;
    }

    public void setUserage(int userage) {
        this.userage = userage;
    }

    public String getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // To extract the object details while printing the Object, we need toString Method


    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", useremail='" + useremail + '\'' +
                ", userphonenumber='" + userphonenumber + '\'' +
                ", userage=" + userage +
                ", userinfo='" + userinfo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
