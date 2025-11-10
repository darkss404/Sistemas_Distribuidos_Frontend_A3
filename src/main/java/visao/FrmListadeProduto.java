package visao;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import service.EstoqueService;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import modelo.Categoria;
import modelo.Produto;

public class FrmListadeProduto extends javax.swing.JFrame {

    public FrmListadeProduto() {
        initComponents();
        carregarTabelaProdutos();
        carregarCategoriasNoFiltro();
    }

    private void carregarCategoriasNoFiltro() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            EstoqueService service = (EstoqueService) registry.lookup("EstoqueService");
            List<Categoria> categorias = service.listarCategorias();

            JCBCategoria.removeAllItems();
            JCBCategoria.addItem("Todas");

            for (Categoria c : categorias) {
                JCBCategoria.addItem(c.getNomeCategoria());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar categorias: " + e.getMessage());
        }
    }

    private JFrame janelaAnterior;

    public FrmListadeProduto(JFrame janelaAnterior) {
        this.janelaAnterior = janelaAnterior;
        initComponents();
        carregarCategoriasNoFiltro();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JLBuscar = new javax.swing.JLabel();
        JLCategoria = new javax.swing.JLabel();
        JTFBuscar = new javax.swing.JTextField();
        JCBCategoria = new javax.swing.JComboBox<>();
        JBFiltrar = new javax.swing.JButton();
        JSPTabeladeProdutos = new javax.swing.JScrollPane();
        JTTabelaProdutos = new javax.swing.JTable();
        JBNovoProduto = new javax.swing.JButton();
        JBEditar = new javax.swing.JButton();
        JBExcluir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        JBVoltarLP = new javax.swing.JButton();
        JBReajustar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Lista de Produtos");

        JLBuscar.setText("Buscar:");

        JLCategoria.setText("Categoria:");

        JTFBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFBuscarActionPerformed(evt);
            }
        });

        JCBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JCBCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBCategoriaActionPerformed(evt);
            }
        });

        JBFiltrar.setText("Filtrar");
        JBFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBFiltrarActionPerformed(evt);
            }
        });

        JTTabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Quantidade", "Unidade", "Categoria"
            }
        ));
        JSPTabeladeProdutos.setViewportView(JTTabelaProdutos);

        JBNovoProduto.setText("Novo Produto");
        JBNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBNovoProdutoActionPerformed(evt);
            }
        });

        JBEditar.setText("Editar");
        JBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEditarActionPerformed(evt);
            }
        });

        JBExcluir.setBackground(new java.awt.Color(220, 53, 69));
        JBExcluir.setText("Excluir");
        JBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExcluirActionPerformed(evt);
            }
        });

        JBVoltarLP.setText("Voltar");
        JBVoltarLP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarLPActionPerformed(evt);
            }
        });

        JBReajustar.setText("Reajustar Preços");
        JBReajustar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBReajustarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JLBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JLCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(JBFiltrar)
                        .addGap(185, 185, 185))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JSPTabeladeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(JBNovoProduto)
                        .addGap(40, 40, 40)
                        .addComponent(JBEditar)
                        .addGap(34, 34, 34)
                        .addComponent(JBExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(JBVoltarLP)
                        .addGap(18, 18, 18)
                        .addComponent(JBReajustar)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBuscar)
                    .addComponent(JLCategoria)
                    .addComponent(JTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBFiltrar))
                .addGap(31, 31, 31)
                .addComponent(JSPTabeladeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBReajustar)
                    .addComponent(JBVoltarLP)
                    .addComponent(JBExcluir)
                    .addComponent(JBEditar)
                    .addComponent(JBNovoProduto))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFBuscarActionPerformed

    private void JCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBCategoriaActionPerformed

    private void JBFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBFiltrarActionPerformed
        String nomeBuscado = JTFBuscar.getText().trim().toLowerCase();
        String categoriaSelecionada = JCBCategoria.getSelectedItem().toString();

        try {
            // Conecta ao RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            EstoqueService service = (EstoqueService) registry.lookup("EstoqueService");

            // Busca todos os produtos via RMI
            List<Produto> produtos = service.listarProdutos();

            // Filtra localmente
            List<Produto> produtosFiltrados = new ArrayList<>();
            for (Produto p : produtos) {
                boolean nomeConfere = nomeBuscado.isEmpty() || p.getNome().toLowerCase().contains(nomeBuscado);
                boolean categoriaConfere = categoriaSelecionada.equals("Todas") || p.getCategoria().equalsIgnoreCase(categoriaSelecionada);
                if (nomeConfere && categoriaConfere) {
                    produtosFiltrados.add(p);
                }
            }

            // Atualiza tabela
            DefaultTableModel modelo = (DefaultTableModel) JTTabelaProdutos.getModel();
            modelo.setRowCount(0);

            for (Produto p : produtosFiltrados) {
                modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getQuantidade(),
                    p.getUnidade(),
                    p.getCategoria()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao filtrar produtos: " + e.getMessage());
            e.printStackTrace();

        }
    }//GEN-LAST:event_JBFiltrarActionPerformed

    private void JBNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBNovoProdutoActionPerformed
        FrmCadastrodeProduto cadastro = new FrmCadastrodeProduto(this);
        cadastro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JBNovoProdutoActionPerformed

    private void JBVoltarLPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarLPActionPerformed
        janelaAnterior.setVisible(true);
        dispose();
    }//GEN-LAST:event_JBVoltarLPActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        carregarTabelaProdutos();
    }//GEN-LAST:event_formWindowOpened

    private void JBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEditarActionPerformed
        int linhaSelecionada = JTTabelaProdutos.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para editar.");
            return;
        }

        try {
            int idProduto = Integer.parseInt(JTTabelaProdutos.getValueAt(linhaSelecionada, 0).toString());

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            EstoqueService service = (EstoqueService) registry.lookup("EstoqueService");

            Produto produto = service.buscarProdutoPorId(idProduto);

            if (produto != null) {
                FrmCadastrodeProduto editarProduto = new FrmCadastrodeProduto(this, produto);
                editarProduto.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Produto não encontrado.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao editar produto: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_JBEditarActionPerformed

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded

    }//GEN-LAST:event_formComponentAdded

    private void JBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExcluirActionPerformed
      int linhaSelecionada = JTTabelaProdutos.getSelectedRow();

    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um produto para excluir.");
        return;
    }

    int confirmacao = JOptionPane.showConfirmDialog(
            this,
            "Tem certeza que deseja excluir este produto?",
            "Confirmar Exclusão",
            JOptionPane.YES_NO_OPTION);

    if (confirmacao != JOptionPane.YES_OPTION) {
        return;
    }

    try {
        int idProduto = (int) JTTabelaProdutos.getValueAt(linhaSelecionada, 0);

        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        EstoqueService service = (EstoqueService) registry.lookup("EstoqueService");

        // Chama o método RMI que retorna boolean
        boolean sucesso = service.DeletarProdutoID(idProduto);

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
            carregarTabelaProdutos(); // ou carregarTabela(), conforme o seu método
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao excluir o produto.");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao excluir produto: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_JBExcluirActionPerformed

    private void JBReajustarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBReajustarActionPerformed
        FrmReajustarPreco reajuste = new FrmReajustarPreco(this);
        reajuste.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JBReajustarActionPerformed

   public void carregarTabelaProdutos() {
    try {
        // Conecta ao servidor RMI
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        EstoqueService service = (EstoqueService) registry.lookup("EstoqueService");

        // Busca lista de produtos via RMI
        List<Produto> lista = service.listarProdutos();

        // Prepara a tabela
        DefaultTableModel modelo = (DefaultTableModel) JTTabelaProdutos.getModel();
        modelo.setRowCount(0);

        // Preenche os dados
        for (Produto p : lista) {
            System.out.println("Categoria do produto carregado: " + p.getCategoria());
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getQuantidade(),
                p.getUnidade(),
                p.getCategoria()
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage());
        e.printStackTrace();
    }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmListadeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListadeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListadeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListadeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListadeProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEditar;
    private javax.swing.JButton JBExcluir;
    private javax.swing.JButton JBFiltrar;
    private javax.swing.JButton JBNovoProduto;
    private javax.swing.JButton JBReajustar;
    private javax.swing.JButton JBVoltarLP;
    private javax.swing.JComboBox<String> JCBCategoria;
    private javax.swing.JLabel JLBuscar;
    private javax.swing.JLabel JLCategoria;
    private javax.swing.JScrollPane JSPTabeladeProdutos;
    private javax.swing.JTextField JTFBuscar;
    private javax.swing.JTable JTTabelaProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
