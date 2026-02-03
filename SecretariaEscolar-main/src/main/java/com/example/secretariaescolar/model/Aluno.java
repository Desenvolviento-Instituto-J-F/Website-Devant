package com.example.secretariaescolar.model;

public class Aluno {
    private int idAluno;
    private int matricula;
    private int idTurma;

    public Aluno(int idAluno, int matricula, int idTurma) {
        this.idAluno = idAluno;
        this.matricula = matricula;
        this.idTurma = idTurma;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }
}
