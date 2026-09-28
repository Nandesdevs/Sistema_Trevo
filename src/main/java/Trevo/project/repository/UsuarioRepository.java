package Trevo.project.repository;

import Trevo.project.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;   

@Repository 
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmailOrTelefoneOrApelido (String email, String telefone, String apelido);
}
