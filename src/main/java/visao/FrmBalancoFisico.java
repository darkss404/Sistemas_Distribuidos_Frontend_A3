package visao;

import modelo.Produto;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JPanel;
import service.ProdutoService;

public class FrmBalancoFisico extends javax.swing.JFrame {

    private FrmTelaPrincipal principal;

    public FrmBalancoFisico(FrmTelaPrincipal principal) {
        this.principal = principal;
        initComponents();
        carregarTabelaBalanco();
    }

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

    private void JBFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBFecharActionPerformed
        principal.showPanel("Relatorios");
    }//GEN-LAST:event_JBFecharActionPerformed

    private void JTFBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFBuscarActionPerformed

    }//GEN-LAST:event_JTFBuscarActionPerformed

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

    public class BalancoFisico {

        public int id;
        public String nome;
        public String categoria;
        public int quantidadeInicial;
        public int entrada;
        public int Saida;
        public int quantidadeFinal;
        public String unidade;
        public double custoUnitario;
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