package com.example.secretariaescolar.model;

public class ProfessorDisciplina {

    private int id_professorDisciplina;
    private int id_professor;
    private int id_disciplina;

    public ProfessorDisciplina(int id_professorDisciplina, int id_professor, int id_disciplina) {
        this.id_professorDisciplina = id_professorDisciplina;
        this.id_professor = id_professor;
        this.id_disciplina = id_disciplina;
    }

    public int getId_professorDisciplina() {
        return id_professorDisciplina;
    }

    public void setId_professorDisciplina(int id_professorDisciplina) {
        this.id_professorDisciplina = id_professorDisciplina;
    }

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }
}
