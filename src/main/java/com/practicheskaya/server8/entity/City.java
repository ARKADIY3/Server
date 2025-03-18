package com.practicheskaya.server8.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cities")

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Publisher> publisher;

    public City() {
    }

    public City(String title, List<Publisher> publisher) {
        this.title = title;
        this.publisher = publisher;
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

    public List<Publisher> getPublisher() {
        return publisher;
    }

    public void setPublisher(List<Publisher> publisher) {
        this.publisher = publisher;
    }
}
