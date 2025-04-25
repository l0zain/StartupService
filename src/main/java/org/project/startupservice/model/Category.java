package org.project.startupservice.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id_category")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false, length = 20)
    private String title;
    @ManyToMany
    @JoinTable(
            name = "startup_category",
            joinColumns = @JoinColumn(name = "id_category_fk"),
            inverseJoinColumns = @JoinColumn(name = "id_startup_fk")

    )
    private List<Startup> startups;
}
