package com.seuprojeto.trevo.model; // declaração do pacote para organizar

import jakarta.persistence.*; // importa as ferramentas JPA(basicamente usa as anotações feitas com o "@" e gera comandos SQL como inserts e selects automaticamente)

@Entity // avisa ao java que é uma classe que pertence ao DB
@Table(name = "usuario") //tabela
public class Usuario {
    
    // @Column é coluna do DB, e o "private Integer idUser;" por exemplo, é como vai ficar em java quando trazer do DB
    
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    @Column(name = "id_user") 
    private Integer idUser;
    
    //nullable = false é notnull
    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto; 
    
    @Column(nullable = false, unique = true) 
    private String email; 
    private String telefone; 
    private Integer idade; 
    private String apelido; 
    private String biografia; 
    
    @Column(name = "foto_perfil") 
    private String fotoPerfil;
    @Column(nullable = false) 
    private String senha; 

    public Usuario() {} // construtor para inicializar o estado inicial desse objeto

    // --- GETTERS E SETTERS ---

    public Integer getIdUser() {
        return idUser; 
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser; 
    }

    public String getNomeCompleto() {
        return nomeCompleto; 
    } 

    public void setNomeCompleto(String nomeCompleto) {
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