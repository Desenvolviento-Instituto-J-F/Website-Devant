package com.example.secretariaescolar.model;

public class Professor extends Usuario {

    private int id_professor;

    public Professor() {
        super();
    }

    public Professor(int id_professor) {
        this.id_professor = id_professor;
    }

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }
