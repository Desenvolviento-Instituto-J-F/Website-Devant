package com.example.secretariaescolar.model;

public class Aluno extends Usuario {
    private int idAluno;
    private String matricula;
    private int idTurma;

    public Aluno(int idAluno, String matricula, int idTurma, String nome, String email, String senha, int id_tipoUser) {
        super(nome, email, senha, id_tipoUser);
        this.idAluno = idAluno;
        this.matricula = matricula;
        this.idTurma = idTurma;
    }

    public Aluno() {
    }

    public int getIdAluno() {
        return idAluno;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }
}
