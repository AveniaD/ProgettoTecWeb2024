package com.uniparthenope.innervision.service.impl;

import com.uniparthenope.innervision.common.RequestLogin;
import com.uniparthenope.innervision.entity.Articolo;
import com.uniparthenope.innervision.entity.Carrello;
import com.uniparthenope.innervision.entity.Utente;
import com.uniparthenope.innervision.entity.diz.DizStatoCarrello;
import com.uniparthenope.innervision.repository.CarrelloRepository;
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

import java.util.ArrayList;

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
    @Autowired
    private CarrelloRepository carrelloRepository;

    public Long registrazione(Utente utente) {
        if (utenteRepository.existsByUsername(utente.getUsername())) {
            throw new RuntimeException("Username già esistente");
        }
        if (utenteRepository.existsByEmail(utente.getEmail())) {
            throw new RuntimeException("Email già esistente");
        }

        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        Long idUtenteSalvato = utenteRepository.save(utente).getIdUtente();

        DizStatoCarrello statoCarrelloIniziale = new DizStatoCarrello(1L, "Bozza","S");
        Long idCarrello = carrelloRepository.save(new Carrello(null, new ArrayList<>(), statoCarrelloIniziale)).getIdCarrello();
        utente.setCarrelloUtente(carrelloRepository.getCarrelloByIdCarrello(idCarrello));

        utenteRepository.save(utente);

        return idUtenteSalvato;
    }

    @Override
    public String login(RequestLogin requestLogin) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestLogin.getUsername(), requestLogin.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(requestLogin.getUsername());
        return jwtUtil.generateToken(userDetails);
    }
}
