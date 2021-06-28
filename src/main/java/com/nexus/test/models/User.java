package com.nexus.test.models;

import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@Table(name = "users")
public class User {

    private int id;
    private String names;
    private int age;
    private int role;
    private String admissionDate;

    public User() { }

    public User(String names, int age, int role, String admissionDate) {
        this.names = names;
        this.age = age;
        this.role = role;
        this.admissionDate = admissionDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "names", nullable = false)
    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "role", nullable = false)
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Column(name = "admission_date", nullable = false)
    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }
}
