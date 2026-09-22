package Trevo.project.model;

import jakarta.persistence.*;

@Entity 
@Table (name = "usuario")
public class Usuario {

    // Columns
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_user")
    private Integer idUser;

    @Column (name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column (name = "email", nullable = false, unique = true)
    private String email;

    private String telefone;
    private Integer idade;
    private String apelido;
    private String biografia;

    @Column (name = "foto_perfil")
    private String fotoPerfil;

    @Column (name = "senha", nullable = false)
    private String senha;

    public Usuario(){} //Constructor

    // Getters e Setters
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNomeCompleto(){
        return this.nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
