package com.br.SafePlaceAPI.service;

import com.br.SafePlaceAPI.model.Alerta;
import com.br.SafePlaceAPI.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    public List<Alerta> listarTodos() {
        return alertaRepository.findAll();
    }

    public Optional<Alerta> buscarPorId(Long id) {
        return alertaRepository.findById(id);
    }

    public Alerta salvar(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    public void deletar(Long id) {
        alertaRepository.deleteById(id);
    }
}
