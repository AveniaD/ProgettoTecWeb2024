package com.uniparthenope.innervision.repository;

import com.uniparthenope.innervision.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
