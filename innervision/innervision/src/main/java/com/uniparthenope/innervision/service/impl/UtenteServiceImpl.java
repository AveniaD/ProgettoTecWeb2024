package com.uniparthenope.innervision.service.impl;

import com.uniparthenope.innervision.entity.Utente;
import com.uniparthenope.innervision.repository.UtenteRepository;
import com.uniparthenope.innervision.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Long registrazione(Utente utente) {
        if (utenteRepository.existsByUsername(utente.getUsername())) {
            throw new RuntimeException("Username già esistente");
        }
        if (utenteRepository.existsByEmail(utente.getEmail())) {
            throw new RuntimeException("Email già esistente");
        }

        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        return utenteRepository.save(utente).getIdUtente();
    }
}
