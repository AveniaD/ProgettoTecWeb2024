package com.uniparthenope.innervision.repository;

import com.uniparthenope.innervision.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    Utente findByUsername(String username);

    Utente getUtenteByIdUtente(Long idUtente);

    Utente getUtenteByUsername(String username);
}
