package com.br.SafePlaceAPI.security;

import com.br.SafePlaceAPI.model.Usuario;
import com.br.SafePlaceAPI.repository.UsuarioRepository;
import com.br.SafePlaceAPI.dto.UsuarioLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String email, @RequestParam String senha) {
        Map<String, Object> result = new HashMap<>();
        try {
            authenticationManager.authenticate(
                new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(email, senha)
            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            String token = jwtUtil.generateToken(userDetails);
            result.put("token", token);

            Usuario usuario = usuarioRepository.findByEmailIgnoreCase(email).orElse(null);

            if (usuario == null) {
                throw new RuntimeException("Usuário não encontrado após autenticação.");
            }

            UsuarioLoginDTO dto = new UsuarioLoginDTO();
            dto.setId(usuario.getId());
            dto.setNome(usuario.getNome());
            dto.setEmail(usuario.getEmail());
            dto.setRole(usuario.getRole());
            dto.setTelefone(usuario.getTelefone());
            result.put("user", dto);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Usuário ou senha inválidos");
        }
        return result;
    }
}
