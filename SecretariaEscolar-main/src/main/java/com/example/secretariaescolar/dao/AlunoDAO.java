package com.example.secretariaescolar.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.example.secretariaescolar.model.Aluno;
import com.example.secretariaescolar.model.Usuario;
import com.example.secretariaescolar.util.Conexao;

public class AlunoDAO {
    // cadastrar(Aluno): Insere o nome, matrícula, e-mail e senha.
    public void cadastrar(Aluno aluno) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        int idGerado = usuarioDAO.inserir(aluno);
        if (idGerado > 0) {
            String sql = "INSERT INTO Aluno (id_user, matricula) VALUES (?, ?)";

            try (Connection conn = Conexao.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, idGerado);
                pstmt.setString(2, aluno.getMatricula());

                pstmt.executeUpdate();
                System.out.println("Aluno cadastrado");
            } catch (SQLException e) {
                System.err.println("Erro ao inserir na tabela Aluno: " + e.getMessage());
            }
        } else {
            System.err.println("Não foi possível criar o usuário, por isso o aluno não foi cadastrado.");
        }
    }
    // buscarPorMatricula(matricula): Método essencial para o professor encontrar o
    // aluno.

    public Aluno buscarPorMatricula(String matricula) {
        String sql = "SELECT u.id_user, u.nome, u.email, a.matricula " +
                "FROM Usuario u " +
                "INNER JOIN Aluno a ON u.id_user = a.id_user " +
                "WHERE a.matricula = ?";

        try (Connection conn = Conexao.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, matricula);

            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    Aluno aluno = new Aluno();
                    aluno.setId_user(rset.getInt("id_user"));
                    aluno.setNome(rset.getString("nome"));
                    aluno.setEmail(rset.getString("email"));
                    aluno.setMatricula(rset.getString("matricula"));

                    return aluno;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar o aluno: " + e.getMessage());
        }

        return null;
    }

    // listarTodos(): Para o caso de listagens gerais.
    public List<Aluno> listarTodos() {
        List<Aluno> listaAlunos = new ArrayList<>();
        String sql = "SELECT u.id_user, u.nome, u.email, a.matricula " +
                "FROM Usuario u " +
                "INNER JOIN Aluno a ON u.id_user = a.id_user";
        try (Connection conn = Conexao.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rset = pstmt.executeQuery()) {
            while (rset.next()) {
                Aluno aluno = new Aluno();
                aluno.setId_user(rset.getInt("id_user"));
                aluno.setNome(rset.getString("nome"));
                aluno.setEmail(rset.getString("email"));
                aluno.setMatricula(rset.getString("matricula"));
                listaAlunos.add(aluno);
            }
            return listaAlunos;
        } catch (SQLException e) {
            System.err.println("Erro ao listar os alunos: " + e.getMessage());
        }
    }
}
