package com.example.secretariaescolar.dao;

import java.security.DrbgParameters.Reseed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Predicate;

import javax.naming.spi.DirStateFactory.Result;

import com.example.secretariaescolar.model.Aluno;
import com.example.secretariaescolar.model.Disciplina;
import com.example.secretariaescolar.model.Professor;
import com.example.secretariaescolar.model.Usuario;
import com.example.secretariaescolar.util.Conexao;

public class ProfessorDAO {
    // buscarPorUsuario(id_user): Retorna os dados do professor logado.
    public Professor buscaPorUsuario(int id_user) {
        String sql = "SELECT u.id_user, u.nome, u.email, u.senha, p.id_professor, p.user " +
                "FROM Usuario u " +
                "INNER JOIN Professor p ON u.id_user = p.id_user " +
                "WHERE u.id_user = ?";

        try (Connection conn = Conexao.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id_user);

            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    Professor professor = new Professor();
                    professor.setId_user(rset.getInt("id_user"));
                    professor.setNome(rset.getString("nome"));
                    professor.setEmail(rset.getString("email"));
                    professor.setSenha(rset.getString("senha"));
                    professor.setId_professor(rset.getInt("id_professor"));
                    professor.setLogin(rset.getString("login"));

                    return professor;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar professor: " + e.getMessage());
        }
        return null;
    }

    // getDisciplina(id_professor): Retorna a disciplina pela qual aquele professor
    // é responsável.
    public Disciplina getDisciplina(int id_professor) {
        String sql = "SELECT id_disciplina, nome_disciplina FROM Disciplina WHERE id_professor = ?";

        try (Connection conn = Conexao.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id_professor);

            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    Disciplina disciplina = new Disciplina();
                    disciplina.setId_disciplina(rset.getInt("id_disciplina"));
                    disciplina.setNome(rset.getString("nome_disciplina"));
                    return disciplina;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao pegar a disciplina do professor: " + e.getMessage());
        }

        return null;
    }

}
