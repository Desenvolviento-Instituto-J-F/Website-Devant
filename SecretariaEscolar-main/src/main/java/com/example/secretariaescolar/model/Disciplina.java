package com.example.secretariaescolar.model;

public class Disciplina {

    private int id_disciplina;
    private String nome_disciplina;

    public Disciplina() {
    }

    public Disciplina(int id_disciplina, String nome_disciplina) {
        this.id_disciplina = id_disciplina;
        this.nome_disciplina = nome_disciplina;
    }

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public String getNome() {
        return nome_disciplina;
    }

    public void setNome(String nome_disciplina) {
        this.nome_disciplina = nome_disciplina;
    }
}