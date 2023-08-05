package com.websitespring.AppConsole.models;

import jakarta.persistence.*;


@Entity
@Table(name = "administradores")//nome da tabela do banco de dados
public class Administrador {

    //atributos do banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "email", length = 180, nullable = false)
    private String email;

    @Column(name = "senha", length = 255, nullable = false)
    private String senha;

    @Column(name = "observacao", length = 255, nullable = true)
    private String observacao;

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha.substring(0, 3) + "****";
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
