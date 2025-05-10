package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "movements")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    @ElementCollection
    @CollectionTable(name = "movement_body_parts", joinColumns = @JoinColumn(name = "movement_id"))
    @Column(name = "body_part")
    private List<String> bodyParts;
    public Movement() {}

    public Movement(String title, String description) {
        this.title = title;
        this.description = description;
        this.bodyParts = bodyParts;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getBodyParts() {
        return bodyParts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBodyParts(List<String> bodyParts) {
        this.bodyParts = bodyParts;
    }
}
