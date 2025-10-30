package com.neurohearts.neurocheck.repository;

import com.neurohearts.neurocheck.model.PatternRecognitionResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatternRecognitionRepository extends JpaRepository<PatternRecognitionResult, Long> {
    Optional<PatternRecognitionResult> findByScreeningId(String screeningId);
}
