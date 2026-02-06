package com.example.secretariaescolar.model;

public class Disciplina {

    private int id_disciplina;
    private String nome;

    public Disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public Disciplina(int id_disciplina, String nome) {
        this.id_disciplina = id_disciplina;
        this.nome = nome;
    }

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}