package com.example.secretariaescolar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.secretariaescolar.model.Turma;
import com.example.secretariaescolar.util.Conexao;

public class TurmaDAO {

    public int inserir(Turma turma) {

        String sql = "INSERT INTO Turma (nome) VALUES (?)";
        int idGerado = -1;

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, turma.getNome());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getInt(1);
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao inserir turma: " + e.getMessage());
        }

        return idGerado;
    }

    public List<Turma> listarTodas() {
        List<Turma> turmas = new ArrayList<>();

        String sql = "SELECT * FROM Turma";

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Turma turma = new Turma();

                turma.setId_turma(rs.getInt("id_turma"));
                turma.setNome(rs.getString("nome"));

                turmas.add(turma);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar todas as turmas: " + e.getMessage());
        }

        return turmas;
    }

    public Turma buscarPorId(int idTurma) {
        String sql = "SELECT * FROM Turma WHERE id_turma = ?";

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idTurma);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Turma turma = new Turma();

                    turma.setId_turma(rs.getInt("id_turma"));
                    turma.setNome(rs.getString("nome"));

                    return turma;
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar turma por ID: " + e.getMessage());
        }

        return null;
    }

    public boolean atualizar(Turma turma) {
        String sql = "UPDATE Turma SET nome = ? WHERE id_turma = ?";

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, turma.getNome());
            stmt.setInt(2, turma.getId_turma());

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar as turmas: " + e.getMessage());
            return false;
        }

    }

    public boolean deletar(int idTurma) {
        String sql = "DELETE FROM Turma WHERE id_turma = ?";

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idTurma);

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao deletar turma: " + e.getMessage());
            return false;
        }
    }

}