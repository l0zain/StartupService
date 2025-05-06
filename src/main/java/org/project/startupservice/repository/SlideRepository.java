package org.project.startupservice.repository;

import org.project.startupservice.model.Slide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SlideRepository extends JpaRepository<Slide, Long> {

    @Query(value = "SELECT url_slide FROM slide ORDER BY order_slide", nativeQuery = true)
    List<String> getAllSlidePath();
}
