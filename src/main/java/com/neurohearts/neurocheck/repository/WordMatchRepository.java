package com.neurohearts.neurocheck.repository;

import com.neurohearts.neurocheck.model.WordMatchResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WordMatchRepository extends JpaRepository<WordMatchResult, Long> {
    Optional<WordMatchResult> findByScreeningId(String screeningId);
}
