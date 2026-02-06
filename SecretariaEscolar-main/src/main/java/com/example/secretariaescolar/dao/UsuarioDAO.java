package com.example.secretariaescolar.dao;

import com.example.secretariaescolar.model.Usuario;
import com.example.secretariaescolar.util.Conexao;

import java.sql.*;

import java.sql.Connection;

public class UsuarioDAO {
    public int inserir(Usuario user) {
        String sql = "INSERT INTO Usuario (nome, login, senha, id_tipoUser) VALUES (?, ?, ?, ?)";
        int idGerado = -1;

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getSenha());
            stmt.setInt(4, user.getId_tipoUser());
            int linhaAfetada = stmt.executeUpdate();

            if (linhaAfetada > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuário: " + e.getMessage());
        }
        return idGerado;
    }

    public Usuario autenticar(String login, String senha) {
        String sql = "SELECT id_user, nome, login, id_tipoUser FROM Usuario WHERE login = ? AND senha = ?";

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario user = new Usuario();
                    user.setId_user(rs.getInt("id_user"));
                    user.setNome(rs.getString("nome"));
                    user.setLogin(rs.getString("login"));
                    user.setId_tipoUser(rs.getInt("id_tipoUser"));
                    return user;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao autenticar usuário: " + e.getMessage());
        }
        return null;
    }
}