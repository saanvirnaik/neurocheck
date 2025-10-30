package com.neurohearts.neurocheck.repository;

import com.neurohearts.neurocheck.model.ConsentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsentRepository extends JpaRepository<ConsentEntity, Long> {
}
