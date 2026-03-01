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
        String sql = "INSERT INTO observacao (mensagem, data, id_aluno, id_professor, id_disciplina) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, observacao.getMensagem());
            stmt.setDate(2, Date.valueOf(observacao.getData()));
            stmt.setInt(3, observacao.getId_aluno());
            stmt.setInt(4, observacao.getId_professor());
            stmt.setInt(5, observacao.getId_disciplina());

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
                Observacao obs = new Observacao();

                obs.setId_observacao(rs.getInt("id_observacao"));
                obs.setMensagem(rs.getString("mensagem"));
                obs.setData(rs.getDate("data").toLocalDate());
                obs.setId_aluno(rs.getInt("id_aluno"));
                obs.setId_professor(rs.getInt("id_professor"));
                obs.setId_disciplina(rs.getInt("id_disciplina"));

                observacoes.add(obs);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao visualizar suas observações: " + e.getMessage());
        }

        return observacoes;
    }

    // Professor visualiza observações que enviou (opcional)
    public List<Observacao> listarPorDisciplina(int idDisciplina) {
        List<Observacao> observacoes = new ArrayList<>();

        String sql = """
            SELECT * FROM observacao
            WHERE id_disciplina = ?
            ORDER BY data DESC
        """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idDisciplina);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Observacao obs = new Observacao();

                obs.setId_observacao(rs.getInt("id_observacao"));
                obs.setMensagem(rs.getString("mensagem"));
                obs.setData(rs.getDate("data").toLocalDate());
                obs.setId_aluno(rs.getInt("id_aluno"));
                obs.setId_professor(rs.getInt("id_professor"));
                obs.setId_disciplina(rs.getInt("id_disciplina"));

                observacoes.add(obs);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao visualizar as observações enviadas: " + e.getMessage());
        }

        return observacoes;
    }
}