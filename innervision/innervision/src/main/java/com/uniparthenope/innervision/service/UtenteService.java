package com.uniparthenope.innervision.service;

import com.uniparthenope.innervision.common.RequestLogin;
import com.uniparthenope.innervision.entity.Utente;

public interface UtenteService {

    Long registrazione(Utente utente);

    String login(RequestLogin requestLogin);
}
