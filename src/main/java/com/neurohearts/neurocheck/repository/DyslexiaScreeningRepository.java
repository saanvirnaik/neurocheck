package com.neurohearts.neurocheck.repository;

import com.neurohearts.neurocheck.model.DyslexiaScreeningData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DyslexiaScreeningRepository extends JpaRepository<DyslexiaScreeningData, Long>{
    Optional<DyslexiaScreeningData> findByScreeningId(String screeningId);
}
