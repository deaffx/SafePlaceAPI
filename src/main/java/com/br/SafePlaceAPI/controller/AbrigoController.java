package com.br.SafePlaceAPI.controller;

import com.br.SafePlaceAPI.dto.AbrigoDTO;
import com.br.SafePlaceAPI.model.Abrigo;
import com.br.SafePlaceAPI.model.Usuario;
import com.br.SafePlaceAPI.repository.UsuarioRepository;
import com.br.SafePlaceAPI.service.AbrigoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {
    private final AbrigoService service;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public AbrigoController(AbrigoService service) {
        this.service = service;
    }

    @GetMapping
    public List<AbrigoDTO> listarTodos() {
        return service.listarTodos().stream().map(this::toDTO).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbrigoDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
            .map(this::toDTO)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/meus")
    @PreAuthorize("hasRole('CONTRIBUTOR')")
    public List<AbrigoDTO> listarMeusAbrigos() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuarioRepository.findByEmail(auth.getName()).orElseThrow();
        return service.listarPorUsuario(usuario.getId()).stream().map(this::toDTO).toList();
    }

    @PreAuthorize("hasRole('CONTRIBUTOR')")
    @PostMapping
    public ResponseEntity<Abrigo> criar(@Valid @RequestBody Abrigo abrigo) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuarioRepository.findByEmail(auth.getName()).orElseThrow();
        abrigo.setUsuario(usuario);
        Abrigo salvo = service.salvar(abrigo);
        return ResponseEntity.status(201).body(salvo);
    }

    @PreAuthorize("hasRole('CONTRIBUTOR')")
    @PutMapping("/{id}")
    public ResponseEntity<Abrigo> atualizar(@PathVariable Long id, @Valid @RequestBody Abrigo abrigo) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuarioRepository.findByEmail(auth.getName()).orElseThrow();
        return service.buscarPorId(id)
            .filter(a -> a.getUsuario().getId().equals(usuario.getId()))
            .map(a -> {
                abrigo.setId(id);
                abrigo.setUsuario(usuario);
                return ResponseEntity.ok(service.salvar(abrigo));
            })
            .orElse(ResponseEntity.status(403).build());
    }

    @PreAuthorize("hasRole('CONTRIBUTOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuarioRepository.findByEmail(auth.getName()).orElseThrow();
        return service.buscarPorId(id)
            .filter(a -> a.getUsuario().getId().equals(usuario.getId()))
            .map(a -> {
                service.deletar(id);
                return ResponseEntity.ok().<Void>build();
            })
            .orElse(ResponseEntity.status(403).build());
    }

    // Método auxiliar para converter entidade em DTO
    private AbrigoDTO toDTO(Abrigo abrigo) {
        AbrigoDTO dto = new AbrigoDTO();
        dto.setId(abrigo.getId());
        dto.setNome(abrigo.getNome());
        dto.setEndereco(abrigo.getEndereco());
        dto.setCapacidade(abrigo.getCapacidade());
        dto.setOcupacaoAtual(abrigo.getOcupacaoAtual());
        dto.setContato(abrigo.getContato());
        dto.setCnpj(abrigo.getCnpj());
        dto.setDescription(abrigo.getDescription());
        if (abrigo.getUsuario() != null) {
            dto.setUsuarioId(abrigo.getUsuario().getId());
            dto.setUsuarioNome(abrigo.getUsuario().getNome());
        }
        return dto;
    }
}