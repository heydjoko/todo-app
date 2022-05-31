package com.example.todoapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "todos_tbl")

public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String content;
    private String status;

    @Column(name = "username")
    private String username;

    public ToDo() {
    }

    public ToDo(int id, String name, String content, String status, String username) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.status = status;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
