package visao;

import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class FrmTelaPrincipal extends javax.swing.JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public FrmTelaPrincipal() {
        initComponents();
        initCardLayout();
    }

    private void initCardLayout() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Tela do menu
        cardPanel.add(createMenuPanel(), "Menu");

        // Telas que possuem getContentPanel()
        FrmListadeProduto produtos = new FrmListadeProduto(this);
        cardPanel.add(produtos.getContentPanel(), "Produtos");

        FrmListadeCategoria categorias = new FrmListadeCategoria(this);
        cardPanel.add(categorias.getContentPanel(), "Categorias");

        FrmRelatorio relatorios = new FrmRelatorio(this);
        cardPanel.add(relatorios.getContentPanel(), "Relatorios");

        FrmBalancoFisico balanco = new FrmBalancoFisico(this);
        cardPanel.add(balanco.getContentPanel(), "Balanco");

        FrmListaDePreco listaPreco = new FrmListaDePreco(this);
        cardPanel.add(listaPreco.getContentPanel(), "ListaPreco");

        FrmProdutoAbaixoDoMin produtoAbaixo = new FrmProdutoAbaixoDoMin(this);
        cardPanel.add(produtoAbaixo.getContentPanel(), "ProdutoAbaixo");

        FrmQuantidadeDeProduto quantidadeProduto = new FrmQuantidadeDeProduto(this);
        cardPanel.add(quantidadeProduto.getContentPanel(), "QuantidadeProduto");

        // Tela Movimentação — SEM getContentPanel()
        FrmMovimentacaoDeEstoque movimentacao = new FrmMovimentacaoDeEstoque(this);
        cardPanel.add(movimentacao.getContentPane(), "Movimentacao");

        // finaliza o CardLayout
        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().add(cardPanel, java.awt.BorderLayout.CENTER);

        showPanel("Menu");
        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(jLabel1, gbc);

        // Separador
        gbc.gridy = 1;
        panel.add(jSeparator1, gbc);

        // Botões
        gbc.gridwidth = 1;
        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(JBProdutos, gbc);

        gbc.gridx = 1;
        panel.add(JBRelatorios, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(JBCategorias, gbc);

        gbc.gridx = 1;
        panel.add(JBMovimentação, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(JBSair, gbc);

        // Separador inferior
        gbc.gridy = 5;
        panel.add(jSeparator2, gbc);

        // Versão
        gbc.gridy = 6;
        panel.add(jLabel2, gbc);

        return panel;
    }

    public void showPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JBProdutos = new javax.swing.JButton();
        JBCategorias = new javax.swing.JButton();
        JBMovimentação = new javax.swing.JButton();
        JBRelatorios = new javax.swing.JButton();
        JBSair = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Controle de Estoque");

        JBProdutos.setText("Produtos");
        JBProdutos.addActionListener(evt -> JBProdutosActionPerformed(evt));

        JBCategorias.setText("Categorias");
        JBCategorias.addActionListener(evt -> JBCategoriasActionPerformed(evt));

        JBMovimentação.setText("Movimentação de Estoque");
        JBMovimentação.addActionListener(evt -> JBMovimentaçãoActionPerformed(evt));

        JBRelatorios.setText("Relatórios");
        JBRelatorios.addActionListener(evt -> JBRelatoriosActionPerformed(evt));

        JBSair.setBackground(new java.awt.Color(220, 53, 69));
        JBSair.setText("Sair");
        JBSair.addActionListener(evt -> JBSairActionPerformed(evt));

        jLabel2.setText("Versão 9.9 | 2025");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator1)
                .addComponent(jSeparator2)
                .addGroup(layout.createSequentialGroup()
                    .addGap(128)
                    .addComponent(jLabel1))
                .addGroup(layout.createSequentialGroup()
                    .addGap(160)
                    .addComponent(jLabel2))
                .addGroup(layout.createSequentialGroup()
                    .addGap(140)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(JBProdutos)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JBRelatorios)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(JBCategorias))
                        .addComponent(JBMovimentação)
                        .addComponent(JBSair)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(5)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(25)
                    .addComponent(JBProdutos)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JBRelatorios)
                        .addComponent(JBCategorias))
                    .addGap(18)
                    .addComponent(JBMovimentação)
                    .addGap(18)
                    .addComponent(JBSair)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel2)
                    .addContainerGap())
        );

        pack();
    }

    private void JBProdutosActionPerformed(java.awt.event.ActionEvent evt) {
        showPanel("Produtos");
    }

    private void JBCategoriasActionPerformed(java.awt.event.ActionEvent evt) {
        showPanel("Categorias");
    }

    private void JBMovimentaçãoActionPerformed(java.awt.event.ActionEvent evt) {
        showPanel("Movimentacao");
    }

    private void JBRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {
        showPanel("Relatorios");
    }

    private void JBSairActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmTelaPrincipal().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton JBCategorias;
    private javax.swing.JButton JBMovimentação;
    private javax.swing.JButton JBProdutos;
    private javax.swing.JButton JBRelatorios;
    private javax.swing.JButton JBSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
}
