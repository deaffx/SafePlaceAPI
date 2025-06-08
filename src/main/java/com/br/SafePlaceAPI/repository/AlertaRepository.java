package com.br.SafePlaceAPI.repository;

import com.br.SafePlaceAPI.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {

}
