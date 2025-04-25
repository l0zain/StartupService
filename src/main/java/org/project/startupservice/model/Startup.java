package org.project.startupservice.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "startup")
public class Startup {
    @Id
    @Column(name = "id_startup")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(name = "id_user", nullable = false)
    private Long userId;
    @Column(name = "short_desc", nullable = false, length = 128)
    private String shortDescription;
    @Column(name = "full_desc", nullable = false, length = 512)
    private String longDescription;
    @Column(name = "url_img", nullable = false, length = 256)
    private String url;
    @Column(name = "stage", nullable = false, length = 7)
    @Enumerated(EnumType.STRING)
    private Stage stage;
    @Column(name = "promotion", nullable = false)
    private Integer promotion;
    @Column(name = "flag_like", nullable = false)
    private boolean flag;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime created;
    @Column(name = "updated_date")
    private LocalDateTime updated;

    @OneToMany(mappedBy = "startup")
    private List<Slide> slides;
    @OneToOne(mappedBy = "startup")
    private Likes likes;
    @OneToMany(mappedBy = "startup")
    private List<Phase> phases;
    @ManyToMany(mappedBy = "startups")
    private List<Category> categories;
}
