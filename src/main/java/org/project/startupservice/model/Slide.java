package org.project.startupservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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
    private int order;
    @Enumerated(EnumType.STRING)
    private Status status;

}
