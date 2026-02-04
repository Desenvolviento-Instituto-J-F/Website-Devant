package com.example.secretariaescolar.util;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final Dotenv dotenv = Dotenv.load();

    public static Connection conectar() {
        Connection conexao = null;

        try {
            String url = dotenv.get("DB_URL");
            String usuario = dotenv.get("DB_USER");
            String senha = dotenv.get("DB_PASS");

            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado!");

        } catch (SQLException e) {
            System.out.println("Erro ao conectar");
            e.printStackTrace();
        }

        return conexao;
    }

    public static void desconectar(Connection conexao) {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Desconectado!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}