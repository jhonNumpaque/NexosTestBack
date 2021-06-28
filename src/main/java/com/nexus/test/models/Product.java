package com.nexus.test.models;

import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@Table(name = "products")
public class Product {

    private int id;
    private String name;
    private int quantity;
    private String admissionDate;
    private int userRecord;
    private int userUpdate;
    private String updatedAt;

    public Product() { }

    public Product(String name, int quantity, String admissionDate, int userRecord, int userUpdate, String updatedAt) {
        this.name = name;
        this.quantity = quantity;
        this.admissionDate = admissionDate;
        this.userRecord = userRecord;
        this.userUpdate = userUpdate;
        this.updatedAt = updatedAt;
    }

    public Product(String name, int quantity, String admissionDate, int userRecord) {
        this.name = name;
        this.quantity = quantity;
        this.admissionDate = admissionDate;
        this.userRecord = userRecord;
    }

    public Product(int id, String name, int quantity, int userUpdate, String updatedAt) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.userUpdate = userUpdate;
        this.updatedAt = updatedAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "admission_date", nullable = false)
    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    @Column(name = "user_record", nullable = false)
    public int getUserRecord() {
        return userRecord;
    }

    public void setUserRecord(int userRecord) {
        this.userRecord = userRecord;
    }

    @Column(name = "user_update")
    public int getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(int userUpdate) {
        this.userUpdate = userUpdate;
    }

    @Column(name = "updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
