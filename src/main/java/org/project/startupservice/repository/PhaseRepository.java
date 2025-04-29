package org.project.startupservice.repository;

import org.project.startupservice.model.Phase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhaseRepository extends JpaRepository<Phase, Long> {
}
