package org.project.startupservice.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "phase")
public class Phase {
    @Id
    @Column(name = "id_phase")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false, length = 25)
    private String title;
    @ManyToOne
    @JoinColumn(name = "id_startup_fk")
    private Startup startup;
    @Column(name = "url_document", nullable = false, length = 256)
    private String url;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "started_date", nullable = false)
    private LocalDateTime started;
    @Column(name = "ended_date", nullable = false)
    private LocalDateTime ended;
}
