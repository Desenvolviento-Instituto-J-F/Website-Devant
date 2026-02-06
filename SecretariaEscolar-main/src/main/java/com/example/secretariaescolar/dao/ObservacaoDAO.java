package com.example.secretariaescolar.dao;

import com.example.secretariaescolar.model.Observacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ObservacaoDAO {
    private Connection conn;

    public ObservacaoDAO(Connection conn) {
        this.conn = conn;
    }

    // Professor envia observação para o aluno
    public void salvar(Observacao observacao) {
        String sql = """
            INSERT INTO observacao (mensagem, data, id_aluno, id_professor)
            VALUES (?, ?, ?, ?)
        """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, observacao.getMensagem());
            stmt.setDate(2, Date.valueOf(observacao.getData()));
            stmt.setInt(3, observacao.getId_aluno());
            stmt.setInt(4, observacao.getId_professor());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao enviar a observação: " + e.getMessage());
        }
    }

    // Aluno visualiza suas observações
    public List<Observacao> listarPorAluno(int idAluno) {
        List<Observacao> observacoes = new ArrayList<>();

        String sql = """
            SELECT * FROM observacao
            WHERE id_aluno = ?
            ORDER BY data DESC
        """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idAluno);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Observacao obs = new Observacao(
                        rs.getInt("id_observacao"),
                        rs.getString("mensagem"),
                        rs.getDate("data").toLocalDate(),
                        rs.getInt("id_aluno"),
                        rs.getInt("id_professor")
                );
                observacoes.add(obs);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao visualizar suas observações: " + e.getMessage());
        }

        return observacoes;
    }

    // Professor visualiza observações que enviou (opcional)
    public List<Observacao> listarPorProfessor(int idProfessor) {
        List<Observacao> observacoes = new ArrayList<>();

        String sql = """
            SELECT * FROM observacao
            WHERE id_professor = ?
            ORDER BY data DESC
        """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProfessor);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Observacao obs = new Observacao(
                        rs.getInt("id_observacao"),
                        rs.getString("mensagem"),
                        rs.getDate("data").toLocalDate(),
                        rs.getInt("id_aluno"),
                        rs.getInt("id_professor")
                );
                observacoes.add(obs);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao visualizar as observações enviadas: " + e.getMessage());
        }

        return observacoes;
    }
}