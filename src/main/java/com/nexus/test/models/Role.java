package com.nexus.test.models;

import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@Table(name = "roles")
public class Role {

    private int id;
    private String name;

    public Role () {}

    public Role (String name) {
        this.name = name;
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
}
