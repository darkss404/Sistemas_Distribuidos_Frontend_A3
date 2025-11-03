package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;

public class CategoriaDao {

    public void inserir(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categorias (nome, tamanho, embalagem) VALUES (?, ?, ?)";
        try (Connection conn = DB.get(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getTamanho());
            stmt.setString(3, categoria.getEmbalagem());

            stmt.executeUpdate();
        }
    }

    public List<Categoria> listar() throws SQLException {
        String sql = "SELECT * FROM categorias ORDER BY nome";
        List<Categoria> lista = new ArrayList<>();

        try (Connection conn = DB.get(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("tamanho"),
                        rs.getString("embalagem"));
                lista.add(categoria);
            }
        }
        return lista;
    }

    public Categoria buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM categorias WHERE id = ?";
        try (Connection conn = DB.get(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Categoria(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("tamanho"),
                            rs.getString("embalagem"));
                }
            }
        }
        return null;
    }

    public void atualizar(Categoria categoria) throws SQLException {
        String sql = "UPDATE categorias SET nome=?, tamanho=?, embalagem=? WHERE id=?";
        try (Connection conn = DB.get(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getTamanho());
            ps.setString(3, categoria.getEmbalagem());
            ps.setInt(4, categoria.getId());

            ps.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM categorias WHERE id=?";
        try (Connection conn = DB.get(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
