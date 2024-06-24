package com.uniparthenope.innervision.service.impl;

import com.uniparthenope.innervision.entity.Utente;
import com.uniparthenope.innervision.repository.UtenteRepository;
import com.uniparthenope.innervision.service.UtenteService;
import com.uniparthenope.innervision.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

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

    @Override
    public String login(Utente utente) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(utente.getUsername(), utente.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(utente.getUsername());
        return jwtUtil.generateToken(userDetails);
    }
}
