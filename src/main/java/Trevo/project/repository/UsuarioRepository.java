package com.seuprojeto.trevo.repository;

import com.seuprojeto.trevo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Busca se o texto informado for igual ao e-mail OU ao telefone OU ao apelido
    Optional<Usuario> findByEmailOrTelefoneOrApelido(String email, String telefone, String senha);

    Optional<Usuario> findByEmail(String email);
}
