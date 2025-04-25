package org.project.startupservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "startup_likes")
public class Likes {
    @Id
    @Column(name = "id_startup_likes")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_startup_fk")
    private Startup startup;
    @Column(name = "counter", nullable = false)
    private Integer counter;
}
