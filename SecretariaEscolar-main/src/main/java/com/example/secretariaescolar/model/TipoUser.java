package com.example.secretariaescolar.model;

public class TipoUser {

    private int id_tipoUser;
    private String nome;

    public TipoUser(int id_tipoUser, String nome) {
        this.id_tipoUser = id_tipoUser;
        this.nome = nome;
    }

    public int getId_tipoUser() {
        return id_tipoUser;
    }

    public String getNome() {
        return nome;
    }

    public void setId_tipoUser(int id_tipoUser) {
        this.id_tipoUser = id_tipoUser;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
