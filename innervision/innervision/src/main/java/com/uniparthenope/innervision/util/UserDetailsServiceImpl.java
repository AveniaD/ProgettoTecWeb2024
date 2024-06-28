package com.uniparthenope.innervision.util;

import com.uniparthenope.innervision.entity.Utente;
import com.uniparthenope.innervision.mapper.UtenteMapper;
import com.uniparthenope.innervision.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private UtenteMapper utenteMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente utenteTrovato = utenteRepository.findByUsername(username);
        if (utenteTrovato == null) {
            throw new UsernameNotFoundException("Utente non trovato: " + username);
        }
        return new UserDetailsImpl(utenteTrovato, utenteMapper, utenteTrovato.getTipologiaUtente());
    }
}
