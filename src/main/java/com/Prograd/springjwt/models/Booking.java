package com.Prograd.springjwt.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "info", nullable = false)
    private String info;
    @Column(name = "amount", nullable = false)
    private String amount;

    @Column(name = "city", nullable = false)
    private String city;

//    @Column(name = "status", nullable = false)
//    private int status;

//    public int getStatus() {
//        return status;
//    }

//    public void setStatus(int status) {
//        this.status = status;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Booking() {

    }
}