package org.project.startupservice.repository;

import org.project.startupservice.model.Startup;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface StartupRepository extends JpaRepository<Startup, Long> {
//    Page<Startup> findAllByOrderByPromotionDescTitleAsc(Pageable pageable);
    List<Startup> findAllByUserId(Long userId);
}
