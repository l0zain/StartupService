package org.project.startupservice.repository;

import org.project.startupservice.model.Slide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlideRepository extends JpaRepository<Slide, Long> {
}
