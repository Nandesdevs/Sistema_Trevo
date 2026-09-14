package com.seuprojeto.trevo.service; // definição de pacote

import com.seuprojeto.trevo.model.Usuario; // importa a classe de modelo Usuario
import com.seuprojeto.trevo.repository.UsuarioRepository; // importa o repositorio UsuarioRepository
// importa as anotações do spring abaixo(Autowired e Service assim como esta no final de cada comando)
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

// importa as classes utilitárias do java(List e Optional)
import java.util.List;
import java.util.Optional;

@Service // avisa ao spring que essa classe contém as regras de negócio do sistema. O spring passa a gerenciar o ciclo de vida dessa classe automaticamente na memória RAM
public class UsuarioService {

    @Autowired // o spring cria e configura o new UsuarioRepository() sozinho, e nos entrega a instância do "usuarioRepository" pronta para uso.
    private UsuarioRepository usuarioRepository;

    // 1. Regra de Negócio: Salvar/Cadastrar um novo Usuário
    public Usuario salvar(Usuario usuario) {
        // Verifica se o e-mail já existe no banco antes de cadastrar
        Optional<Trevo.project.model.Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail()); // optional é uma caixa que vai armazenar o valor desejado ou nada, é apenas para resolver o erro de valor nulo quando não tem nada para devolver, sem o optional o sistema quebra

        if (usuarioExistente.isPresent()){ // ve se o usuario esta guardado dentro da caixa(é um metodo do optional)
            throw new RuntimeException("E-mail já cadastrado no sistema!");
        }

        return usuarioRepository.save(usuario); // o sistema libera o cadastro e executa o "usuarioRepository.save(usuario)"" para criar a conta no MySQL.
    }

    //2. Regra de Negócio: Autenticar o usuário no login(por e-mail, telefone ou usuario)
    // LoginIndentificador é o texto digitado no campo de login para fazer o comparativo
    public Usuario autenticar(String loginIdentificador, String senha) {
        // LoginIndentificador é o texto digitado no campo de login para fazer o comparativo
        Optional<Trevo.project.model.Usuario> usuarioOpt = usuarioRepository.findByEmailOrTelefoneOrApelido(
            // 3 parametros para comparar com e-mail, telefone e apelido
            loginIdentificador,
            loginIdentificador,
            loginIdentificador
        );

        // Se encontrou algum registro E a senha bater
        if (usuarioOpt.isPresent() && usuarioOpt.get().getSenha().equals(senha)) { // .getSenha() Pega o texto da senha que veio do MySQL, .equals Compara se o texto da senha salva no banco é exatamente igual ao texto da senha que o usuário digitou no login.
            return usuarioOpt.get(); //usuarioOpt.get() é a ação de abrir a caixa e tirar o usuario,
        }

        throw new RuntimeException("Credenciais inválidas! Verifique seu login e senha.");
    }

    // 3. Buscar todos os usuários cadastrados
    // Para que serve?
    // Permitir que um administrador do sistema veja uma tabela com todos os usuários cadastrados; 
    //Permitir que os administradores do sistema testem via Postman se os dados gravados pelo formulário estão realmente chegando ao MySQL.
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
}