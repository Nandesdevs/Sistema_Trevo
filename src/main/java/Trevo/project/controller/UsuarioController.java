package Trevo.project.controller;

import Trevo.project.model.Usuario;
import Trevo.project.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // avisa ao spring que essa classe é um controller, ou seja, ela vai receber as requisições HTTP do front-end e devolver respostas HTTP para o front-end
@RequestMapping("/api/usuarios") //Define o endereço base para todas as rotas desse controller, ou seja, todas as rotas vão começar com "/api/usuarios"
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService; // Injeta a camada de serviço 

    // 1. Rota para cadastrar um novo usuário, o "@PostMapping" é o verbo HTTP que indica que essa rota vai receber dados do front-end para criar um novo recurso no back-end
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario) { // @RequestBody indica que o corpo da requisição HTTP vai ser convertido para um objeto do tipo Usuario automaticamente pelo Spring 
        //O ResponseEntity<?>: Envelopa o resultado retornado junto com um Código de Status HTTP:
        try { // 201 CREATED: Retornado se o cadastro for bem-sucedido no MySQL.
            Usuario novoUsuario = usuarioService.salvar(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
        } catch (RuntimeException e) { // Se o cadastro falhar, retorna 400 BAD REQUEST com a mensagem de erro
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 2. Rota para login (e-mail, telefone ou apelido)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) { // loginRequest é um DTO (Data Transfer Object) que encapsula os dados do login (loginIdentificador e senha) enviados pelo front-end
        try {
            Usuario usuarioAutenticado = usuarioService.autenticar(
                loginRequest.getLoginIdentificador(), 
                loginRequest.getSenha()
            );
            return ResponseEntity.ok(usuarioAutenticado);
        } catch (RuntimeException e) { // Se a autenticação falhar, retorna 401 UNAUTHORIZED com a mensagem de erro
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    // 3. Rota para listar todos os usuários
    @GetMapping // Mapeia requisições do método HTTP GET (usado para consultas/leituras).
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    // DTO (Objeto de Transferência de Dados) auxiliar para receber o JSON do login
    public static class LoginRequest {
        private String loginIdentificador;
        private String senha;

        public LoginRequest() {}

        public String getLoginIdentificador() {
            return loginIdentificador;
        }

        public void setLoginIdentificador(String loginIdentificador) {
            this.loginIdentificador = loginIdentificador;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }
    }
}