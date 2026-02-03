package com.example.secretariaescolar.model;

public class Observacao {

    private int id_observacao;
    private String mensagem;
    private String data;
    private int id_aluno;
    private int id_professor;

    public Observacao(int id_observacao, String mensagem, String data, int id_aluno, int id_professor) {
        this.id_observacao = id_observacao;
        this.mensagem = mensagem;
        this.data = data;
        this.id_aluno = id_aluno;
        this.id_professor = id_professor;
    }

    public int getId_observacao() {
        return id_observacao;
    }

    public void setId_observacao(int id_observacao) {
        this.id_observacao = id_observacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }
}
