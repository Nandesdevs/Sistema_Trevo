package Trevo.project.service;

import Trevo.project.model.Usuario;
import Trevo.project.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service 
public class UsuarioService {
    
    @Autowired 
    UsuarioRepository usuarioRepository;
}
