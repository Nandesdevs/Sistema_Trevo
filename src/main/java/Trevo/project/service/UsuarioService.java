package Trevo.project.service;

import Trevo.project.model.Usuario;
import Trevo.project.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service 
public class UsuarioService {
    
    @Autowired 
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> logar (String login, String senha){
        Optional<Usuario> userResp = usuarioRepository.findByEmailOrTelefoneOrApelido(login, login, login);
        
        if (userResp.isPresent() && userResp.get().getSenha().equals(senha)){
            return userResp;
        }
        else{
            return Optional.empty();
        }
    }
}
