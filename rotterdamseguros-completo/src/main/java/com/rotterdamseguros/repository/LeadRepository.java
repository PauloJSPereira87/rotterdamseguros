package com.rotterdamseguros.repository;

import com.rotterdamseguros.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<Lead, Long> {
}