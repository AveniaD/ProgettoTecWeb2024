package com.uniparthenope.innervision.repository;

import com.uniparthenope.innervision.entity.Articolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticoloRepository extends JpaRepository<Articolo, Long> {
}
