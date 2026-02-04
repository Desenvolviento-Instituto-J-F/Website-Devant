package com.example.secretariaescolar.dao;
import com.example.secretariaescolar.model.Usuario;
import com.example.secretariaescolar.util.Conexao;

import java.net.FileNameMap;
import java.sql.*;

import java.sql.Connection;

public class UsuarioDAO {
    public int inserir(Usuario user) {
        String sql = "INSERT INTO Usuario (nome, email, senha, id_tipo_user) VALUES (?, ?, ?, ?)";
        int idGerado = -1;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getSenha());
            stmt.setInt(4, user.getId_tipoUser());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
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

    public Usuario autenticar(String email, String senha) {
        String sql = "SELECT id_user, nome, email, id_tipo_user FROM Usuario WHERE email = ? AND senha = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario user = new Usuario();
                    user.setId_user(rs.getInt("id_user"));
                    user.setNome(rs.getString("nome"));
                    user.setEmail(rs.getString("email"));
                    user.setId_tipoUser(rs.getInt("id_tipo_user"));
                    return user;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao autenticar usuário: " + e.getMessage());
        }

        return null;
    }
}
