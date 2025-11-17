package visao;

import modelo.Produto;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JPanel;
import service.ProdutoService;

/**
 * Tela de relatório que exibe o balanço físico e financeiro do estoque. Lista
 * todos os produtos cadastrados e calcula o valor total em estoque. A tela
 * permite filtrar produtos por nome e acessar o total atualizado.
 */
public class FrmBalancoFisico extends javax.swing.JFrame {

    /**
     * Referência para a tela principal, usada para navegação entre telas.
     */
    private FrmTelaPrincipal principal;

    /**
     * Construtor padrão que recebe a tela principal como referência e
     * inicializa os componentes gráficos da interface.
     *
     * @param principal tela principal do sistema
     */
    public FrmBalancoFisico(FrmTelaPrincipal principal) {
        this.principal = principal;
        initComponents();
        carregarTabelaBalanco();
    }

    /**
     * Retorna o painel atual de conteúdo da janela. Esse método é usado pela
     * tela principal para permitir o encaixe desta interface no painel central.
     *
     * @return painel contendo os componentes da tela
     */
    public JPanel getContentPanel() {
        JPanel wrapper = new JPanel(new java.awt.BorderLayout());

        if (getContentPane() instanceof JPanel) {
            return (JPanel) getContentPane();
        }

        java.awt.Component[] components = getContentPane().getComponents();
        for (java.awt.Component comp : components) {
            wrapper.add(comp);
        }

        getContentPane().removeAll();

        return wrapper;
    }

    /**
     * Carrega os produtos do servidor RMI e preenche a tabela de balanço.
     * Calcula o valor total em estoque e exibe no rodapé.
     */
    private void carregarTabelaBalanco() {
        List<Produto> lista = null;

        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            ProdutoService service = (ProdutoService) registro.lookup("EstoqueService");
            lista = service.listarProdutos();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) JTBalanco.getModel();
        modelo.setRowCount(0);

        double totalEstoque = 0.0;

        for (Produto p : lista) {
            double valorTotal = p.getQuantidade() * p.getPreco();
            totalEstoque += valorTotal;

            modelo.addRow(new Object[]{
                p.getNome(),
                p.getCategoria(),
                p.getQuantidade(),
                String.format("R$ %.2f", p.getPreco()),
                String.format("R$ %.2f", valorTotal)
            });
        }

        JLTotal.setText("Total do estoque: R$ " + String.format("%.2f", totalEstoque));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JBFechar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBalanco = new javax.swing.JTable();
        JTFBuscar = new javax.swing.JTextField();
        JBFiltrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        JLTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Balanço Físico/Financeiro");

        JBFechar.setBackground(new java.awt.Color(220, 53, 69));
        JBFechar.setText("Fechar");
        JBFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBFecharActionPerformed(evt);
            }
        });

        JTBalanco.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "Nome", "Categoria", "Quantidade Disponivel", "Preço Unitário", "Valor Total"
                }
        ));
        jScrollPane1.setViewportView(JTBalanco);

        JTFBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFBuscarActionPerformed(evt);
            }
        });

        JBFiltrar.setText("Filtrar");
        JBFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBFiltrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar:");

        JLTotal.setText("Total do Estoque: R$ 0,00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator2)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(242, 242, 242)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(JBFiltrar)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(194, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(131, 131, 131))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(416, 416, 416))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(JLTotal)
                                                .addGap(468, 468, 468))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(JBFechar)
                                                .addGap(503, 503, 503))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(JBFiltrar))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JLTotal)
                                .addGap(13, 13, 13)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JBFechar)
                                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Ação do botão Fechar. Retorna o usuário para o painel de relatórios.
     *
     * @param evt evento disparado pelo botão
     */
    private void JBFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBFecharActionPerformed
        principal.showPanel("Relatorios");
    }//GEN-LAST:event_JBFecharActionPerformed
    /**
     * Ação do campo de busca ao pressionar Enter. Atualmente não possui
     * implementação adicional.
     *
     * @param evt evento disparado
     */
    private void JTFBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFBuscarActionPerformed

    }//GEN-LAST:event_JTFBuscarActionPerformed
    /**
     * Filtra os produtos exibidos na tabela com base no texto digitado. A
     * filtragem considera apenas produtos cujo nome contenha o texto.
     *
     * @param evt evento disparado pelo botão Filtrar
     */
    private void JBFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBFiltrarActionPerformed
        String texto = JTFBuscar.getText().trim().toLowerCase();
        List<Produto> lista = null;
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            ProdutoService service = (ProdutoService) registro.lookup("EstoqueService");
            lista = service.listarProdutos();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) JTBalanco.getModel();
        modelo.setRowCount(0);

        double totalEstoque = 0.0;

        for (Produto p : lista) {
            if (p.getNome().toLowerCase().contains(texto)) {
                double valorTotal = p.getQuantidade() * p.getPreco();
                totalEstoque += valorTotal;

                modelo.addRow(new Object[]{
                    p.getNome(),
                    p.getCategoria(),
                    p.getQuantidade(),
                    String.format("R$ %.2f", p.getPreco()),
                    String.format("R$ %.2f", valorTotal)
                });
            }
        }

        JLTotal.setText("Total do estoque: R$ " + String.format("%.2f", totalEstoque));
    }//GEN-LAST:event_JBFiltrarActionPerformed
    /**
     * Classe auxiliar usada como estrutura para representar o balanço físico.
     * Essa classe não está integrada com o restante do sistema, mas pode ser
     * usada para cálculos e relatórios futuros.
     */
    public class BalancoFisico {

        /**
         * Identificador do produto.
         */
        public int id;

        /**
         * Nome do produto.
         */
        public String nome;

        /**
         * Categoria do produto.
         */
        public String categoria;

        /**
         * Quantidade inicial em estoque.
         */
        public int quantidadeInicial;

        /**
         * Quantidade de entradas.
         */
        public int entrada;

        /**
         * Quantidade de saídas.
         */
        public int Saida;

        /**
         * Quantidade final em estoque.
         */
        public int quantidadeFinal;

        /**
         * Unidade de medida do produto.
         */
        public String unidade;

        /**
         * Custo unitário do produto.
         */
        public double custoUnitario;

        /**
         * Custo total calculado.
         */
        public double custoFinal;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBFechar;
    private javax.swing.JButton JBFiltrar;
    private javax.swing.JLabel JLTotal;
    private javax.swing.JTable JTBalanco;
    private javax.swing.JTextField JTFBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
