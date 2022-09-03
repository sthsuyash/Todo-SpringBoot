package com.suyash.todo.Entity;

import javax.persistence.*;

@Entity
public class Todo {

    @Id
    private Long id;
    private String title;
    private String description;
    private boolean completed = Boolean.FALSE;

    public Todo() {
    }

    public Todo(Long id,
                String title,
                String description,
                boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
