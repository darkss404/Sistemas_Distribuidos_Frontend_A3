package visao;

import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Classe responsável por exibir e controlar a tela principal do sistema de
 * controle de estoque. Esta tela funciona como um menu central, permitindo
 * navegar entre diferentes funcionalidades através de um CardLayout.
 *
 * A tela principal contém: - Botão para acessar a tela de produtos - Botão para
 * acessar a tela de categorias - Botão para acessar a tela de relatórios -
 * Botão para acessar a tela de movimentação de estoque - Botão para encerrar a
 * aplicação
 *
 * O CardLayout permite alternar dinamicamente entre várias telas sem abrir
 * novas janelas, melhorando a navegação e organização do sistema.
 */
public class FrmTelaPrincipal extends javax.swing.JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    /**
     * Construtor da classe. Inicializa os componentes da interface gráfica e
     * configura o CardLayout utilizado para alternar entre as telas.
     */
    public FrmTelaPrincipal() {
        initComponents();
        initCardLayout();
    }

    /**
     * Inicializa e configura o CardLayout utilizado para gerenciar e alternar
     * entre os painéis das principais funcionalidades do sistema.
     *
     * Esta configuração registra todas as telas internas no painel principal: -
     * Menu inicial - Listagem de produtos - Listagem de categorias - Relatórios
     * - Balanço físico - Lista de preços - Produtos abaixo do mínimo -
     * Quantidade de produtos por categoria - Tela de movimentação de estoque
     *
     * Após a configuração, o painel "Menu" é exibido por padrão.
     */
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

    /**
     * Cria e retorna o painel do menu principal, responsável por exibir os
     * botões de navegação do sistema.
     *
     * O painel utiliza GridBagLayout para organizar os elementos.
     *
     * @return JPanel contendo os elementos do menu principal
     */
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

    /**
     * Exibe no CardLayout o painel cujo nome foi informado.
     *
     * @param panelName nome do painel registrado no CardLayout
     */
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

    /**
     * Ação executada ao clicar no botão "Produtos". Exibe a tela de listagem de
     * produtos.
     *
     * @param evt evento do botão
     */
    private void JBProdutosActionPerformed(java.awt.event.ActionEvent evt) {
        showPanel("Produtos");
    }

    /**
     * Ação executada ao clicar no botão "Categorias". Exibe a tela de listagem
     * de categorias.
     *
     * @param evt evento do botão
     */
    private void JBCategoriasActionPerformed(java.awt.event.ActionEvent evt) {
        showPanel("Categorias");
    }

    /**
     * Ação executada ao clicar no botão "Movimentação de Estoque". Exibe a tela
     * de movimentação de produtos.
     *
     * @param evt evento do botão
     */
    private void JBMovimentaçãoActionPerformed(java.awt.event.ActionEvent evt) {
        showPanel("Movimentacao");
    }

    /**
     * Ação executada ao clicar no botão "Relatórios". Exibe a tela de
     * relatórios do sistema.
     *
     * @param evt evento do botão
     */
    private void JBRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {
        showPanel("Relatorios");
    }

    /**
     * Ação executada ao clicar no botão "Sair". Encerra a aplicação por
     * completo.
     *
     * @param evt evento do botão
     */
    private void JBSairActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    /**
     * Método principal que inicializa a aplicação exibindo a tela principal.
     *
     * @param args argumentos da linha de comando
     */
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
