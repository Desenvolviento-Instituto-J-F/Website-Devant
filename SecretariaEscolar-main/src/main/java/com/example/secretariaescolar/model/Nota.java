package com.example.secretariaescolar.model;

public class Nota {

    private int id_nota;
    private String titulo;
    private double valor;
    private String semestre;
    private int id_aluno;
    private int id_professorDisciplina;

    public Nota(int id_nota, String titulo, double valor, String semestre, int id_aluno, int id_professorDisciplina) {
        this.id_nota = id_nota;
        this.titulo = titulo;
        this.valor = valor;
        this.semestre = semestre;
        this.id_aluno = id_aluno;
        this.id_professorDisciplina = id_professorDisciplina;
    }

    public int getId_nota() {
        return id_nota;
    }

    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public int getId_professorDisciplina() {
        return id_professorDisciplina;
    }

    public void setId_professorDisciplina(int id_professorDisciplina) {
        this.id_professorDisciplina = id_professorDisciplina;
    }
}
