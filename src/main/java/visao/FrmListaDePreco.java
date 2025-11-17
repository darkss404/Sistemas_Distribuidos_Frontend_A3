package visao;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Produto;
import service.ProdutoService;
import javax.swing.JPanel;

/**
 * Tela responsável por exibir a lista de preços dos produtos cadastrados.
 * Permite visualizar informações básicas dos produtos e abrir a tela de edição.
 *
 * Os dados são obtidos através de uma conexão RMI com o serviço ProdutoService.
 */
public class FrmListaDePreco extends javax.swing.JFrame {

    private FrmTelaPrincipal principal;

    /**
     * Construtor que inicializa a interface e carrega os dados da tabela.
     *
     * @param principal referência da tela principal
     */
    public FrmListaDePreco(FrmTelaPrincipal principal) {
        this.principal = principal;
        initComponents();
        carregarTabela();
    }

    /**
     * Retorna o painel que contém os componentes da janela. Esse método permite
     * que o painel seja integrado a outro container externo.
     *
     * @return o painel com os componentes do formulário
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
     * Carrega os produtos na tabela a partir do serviço remoto. Em caso de
     * falha na comunicação ou outro erro, apresenta mensagem ao usuário.
     */
    public void carregarTabela() {
        List<Produto> lista = null;

        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            ProdutoService service = (ProdutoService) registro.lookup("EstoqueService");
            lista = service.listarProdutos();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar lista de preços: " + e.getMessage());
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) JTListaDePreco.getModel();
        modelo.setRowCount(0);

        for (Produto p : lista) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getUnidade(),
                p.getCategoria(),
                String.format("R$ %.2f", p.getPreco())
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTListaDePreco = new javax.swing.JTable();
        JBEditar = new javax.swing.JButton();
        JBFechar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Lista de Preços");

        JTListaDePreco.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "ID", "Nome", "Unidade", "Categoria", "Preço Unitário"
                }
        ));
        jScrollPane1.setViewportView(JTListaDePreco);

        JBEditar.setText("Editar");
        JBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEditarActionPerformed(evt);
            }
        });

        JBFechar.setBackground(new java.awt.Color(220, 53, 69));
        JBFechar.setText("Fechar");
        JBFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(JBEditar)
                                                .addGap(85, 85, 85)
                                                .addComponent(JBFechar)
                                                .addGap(138, 138, 138))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(194, 194, 194))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JBFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JBEditar))
                                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 /**
     * Ação executada ao clicar no botão Editar. Recupera o produto selecionado
     * na tabela, busca seus dados no serviço remoto e abre a tela de edição
     * para o usuário modificar as informações.
     *
     * @param evt evento disparado ao clicar no botão
     */
    private void JBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEditarActionPerformed
        int linhaSelecionada = JTListaDePreco.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para editar.");
            return;
        }

        int idProduto = Integer.parseInt(JTListaDePreco.getValueAt(linhaSelecionada, 0).toString());

        Produto produto = null;

        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            ProdutoService service = (ProdutoService) registro.lookup("EstoqueService");
            produto = service.buscarProdutoPorId(idProduto);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao buscar produto: " + e.getMessage());
            return;
        }

        FrmCadastrodeProduto dialog = new FrmCadastrodeProduto(null, true, produto);
        dialog.setVisible(true);
        carregarTabela();

    }//GEN-LAST:event_JBEditarActionPerformed
    /**
     * Ação executada ao clicar no botão Fechar. Retorna o usuário para o painel
     * de Relatórios na tela principal.
     *
     * @param evt evento disparado ao clicar no botão
     */
    private void JBFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBFecharActionPerformed
        principal.showPanel("Relatorios");
    }//GEN-LAST:event_JBFecharActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEditar;
    private javax.swing.JButton JBFechar;
    private javax.swing.JTable JTListaDePreco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
