package Trevo.project.controller;

import Trevo.project.model.Usuario;
import Trevo.project.service.UsuarioService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;   
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    
    @Autowired 
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
        Usuario novoUsuario = usuarioService.cadastrar(usuario);
        return ResponseEntity.status(201).body(novoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario){
        Optional<Usuario> loginUsuario = usuarioService.logar(usuario.getEmail(), usuario.getSenha());
        if(loginUsuario.isPresent()){
            return ResponseEntity.status(200).body(loginUsuario.get());
        }
        else{
            return ResponseEntity.status(401).body("Login ou senha incorretos");
        }
    }
}
