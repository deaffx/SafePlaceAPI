package com.br.SafePlaceAPI.repository;

import com.br.SafePlaceAPI.model.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {
    List<Abrigo> findByUsuarioId(Long usuarioId);
}