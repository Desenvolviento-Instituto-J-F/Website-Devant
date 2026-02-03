package com.example.secretariaescolar.model;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private int id_tipoUser;

    public Usuario(String nome, String email, String senha, int id_tipoUser) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.id_tipoUser = id_tipoUser;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getId_tipoUser() {
        return id_tipoUser;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setId_tipoUser(int id_tipoUser) {
        this.id_tipoUser = id_tipoUser;
    }
}
