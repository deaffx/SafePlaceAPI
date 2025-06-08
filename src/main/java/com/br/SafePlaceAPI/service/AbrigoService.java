package com.br.SafePlaceAPI.service;

import com.br.SafePlaceAPI.model.Abrigo;
import com.br.SafePlaceAPI.repository.AbrigoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AbrigoService {
    private final AbrigoRepository repository;

    public AbrigoService(AbrigoRepository repository) {
        this.repository = repository;
    }

    public List<Abrigo> listarTodos() {
        return repository.findAll();
    }

    public Optional<Abrigo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Abrigo> listarPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public Abrigo salvar(Abrigo abrigo) {
        return repository.save(abrigo);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}