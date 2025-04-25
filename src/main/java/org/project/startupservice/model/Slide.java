package org.project.startupservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "slide")
public class Slide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_slide")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_startup_fk")
    private Startup startup;
    @Column(name = "url_slide", nullable = false, length = 256)
    private String url;
    @Column(name = "order_slide", nullable = false)
    private Short order;
    @Enumerated(EnumType.STRING)
    private Status status;

}
