package com.br.SafePlaceAPI.controller;

import com.br.SafePlaceAPI.dto.UsuarioDTO;
import com.br.SafePlaceAPI.model.Usuario;
import com.br.SafePlaceAPI.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody UsuarioDTO dto) {
        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("E-mail já cadastrado.");
        }
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha())); // Criptografa a senha!
        usuario.setRole(dto.getRole());
        usuario.setTelefone(dto.getTelefone());
        usuarioRepository.save(usuario);
        return ResponseEntity.status(201).body(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email) {
        Map<String, Object> result = new HashMap<>();
        Usuario usuario = usuarioRepository.findByEmailIgnoreCase(email).orElse(null);
        if (usuario == null) {
            return ResponseEntity.badRequest().body("Usuário não encontrado.");
        }
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setRole(usuario.getRole());
        dto.setTelefone(usuario.getTelefone());
        result.put("user", dto);
        return ResponseEntity.ok(result);
    }
}
