package com.uniparthenope.innervision.service.diz;

import com.uniparthenope.innervision.entity.diz.DizGenere;

import java.util.List;

public interface DizGenereService {

    List<DizGenere> findAllByAttivo();
}
