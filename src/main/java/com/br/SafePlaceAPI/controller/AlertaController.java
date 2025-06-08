package com.br.SafePlaceAPI.controller;

import com.br.SafePlaceAPI.model.Alerta;
import com.br.SafePlaceAPI.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertaRepository alertaRepository;

    @GetMapping
    public List<Alerta> listarTodos() {
        return alertaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Alerta> buscarPorId(@PathVariable Long id) {
        return alertaRepository.findById(id);
    }

    @PostMapping
    public Alerta criar(@RequestBody Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    @PutMapping("/{id}")
    public Alerta atualizar(@PathVariable Long id, @RequestBody Alerta alerta) {
        alerta.setId(id);
        return alertaRepository.save(alerta);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        alertaRepository.deleteById(id);
    }
}
