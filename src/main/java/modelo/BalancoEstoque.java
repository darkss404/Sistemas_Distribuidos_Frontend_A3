package modelo;

import dao.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BalancoEstoque {

    public static String gerarBalancoTexto() {
        List<Produto> produtos = new ArrayList<>();
        double valorTotalEstoque = 0.0;
        StringBuilder relatorio = new StringBuilder();

        try {
            Connection conn = DB.get();
            String sql = "SELECT nome, qtd_atual, valor_unitario FROM produtos WHERE ativo = 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                int quantidade = rs.getInt("qtd_atual");
                double valorUnitario = rs.getDouble("valor_unitario");

                Produto produto = new Produto(nome, quantidade, valorUnitario);
                produtos.add(produto);
                valorTotalEstoque += produto.getValorTotal();
            }

            rs.close();
            stmt.close();
            conn.close();

            if (produtos.isEmpty()) {
                return "Não há produtos cadastrados no estoque para gerar o balanço.";
            }

            Collections.sort(produtos);

            relatorio.append(String.format("%-30s %-10s %-15s %-15s\n", "Produto", "Qtde", "Valor Unitário", "Valor Total"));
            relatorio.append("---------------------------------------------------------------------------\n");

            for (Produto p : produtos) {
                relatorio.append(String.format("%-30s %-10d R$ %-12.2f R$ %-12.2f\n",
                        p.getNome(), p.getQuantidade(), p.getValorUnitario(), p.getValorTotal()));
            }

            relatorio.append("---------------------------------------------------------------------------\n");
            relatorio.append(String.format("Valor total do estoque: R$ %.2f\n", valorTotalEstoque));

        } catch (Exception e) {
            return "Erro ao gerar balanço: " + e.getMessage();
        }

        return relatorio.toString();
    }

    static class Produto implements Comparable<Produto> {

        private String nome;
        private int quantidade;
        private double valorUnitario;

        public Produto(String nome, int quantidade, double valorUnitario) {
            this.nome = nome;
            this.quantidade = quantidade;
            this.valorUnitario = valorUnitario;
        }

        public String getNome() {
            return nome;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public double getValorUnitario() {
            return valorUnitario;
        }

        public double getValorTotal() {
            return quantidade * valorUnitario;
        }

        @Override
        public int compareTo(Produto outro) {
            return this.nome.compareToIgnoreCase(outro.nome);
        }
    }
}
