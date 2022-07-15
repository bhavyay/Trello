package com.bhavya.trello.model;

public class Card extends BaseModel {
    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                '}';
    }

    private final String id;
    private String name;
    private String description;
    private String assignedTo;

    public Card(String assignedTo) {
        this.id = generateId();
        this.assignedTo = assignedTo;
    }

    public void assign(String userId)
    {
        this.assignedTo = userId;
    }

    public void unAssign()
    {
        this.assignedTo = null;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
