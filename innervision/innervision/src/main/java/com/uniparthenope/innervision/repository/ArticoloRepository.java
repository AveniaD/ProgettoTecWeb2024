package com.uniparthenope.innervision.repository;

import com.uniparthenope.innervision.entity.Articolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticoloRepository extends JpaRepository<Articolo, Long> {

    @Query(value = "SELECT * FROM articolo a WHERE a.nome = LIKE '%?1%'",nativeQuery = true)
    List<Articolo> findArticoloByNome(@Param("nome") String nome);
}
