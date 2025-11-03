package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RelatorioCategoriasDao {

    public List<Object[]> listarQuantidadeProdutosPorCategoria() {
        List<Object[]> lista = new ArrayList<>();
        String sql = """
    SELECT 
        c.nome AS categorias, 
        COUNT(p.id) AS total_produtos,
        COUNT(DISTINCT p.nome) AS produtos_diferentes
    FROM categorias c
    LEFT JOIN produtos p ON p.id_categoria = c.id
    GROUP BY c.nome
    ORDER BY c.nome;
""";

        try (Connection conn = DB.get(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nomeCategoria = rs.getString("categorias");
                int totalProdutos = rs.getInt("total_produtos");
                int produtosDiferentes = rs.getInt("produtos_diferentes");

                lista.add(new Object[]{nomeCategoria, totalProdutos, produtosDiferentes});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
