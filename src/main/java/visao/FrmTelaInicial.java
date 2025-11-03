package visao;

import java.util.ArrayList;
import modelo.Produto;

public class FrmTelaInicial extends javax.swing.JFrame {

    private ArrayList<Produto> estoque;

    public FrmTelaInicial(ArrayList<Produto> estoque) {
        this.estoque = estoque;
        initComponents();
    }

    FrmTelaInicial() {
        this.estoque = new ArrayList<>();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        JBCadastrarCategoria = new javax.swing.JMenuItem();
        JBCadastrarProduto = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        JBEditarCategoria = new javax.swing.JMenuItem();
        JBEditarProduto = new javax.swing.JMenuItem();
        JBEntradaSaida = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        JBBalanço = new javax.swing.JMenuItem();
        JBLista = new javax.swing.JMenuItem();
        JBRelatorios = new javax.swing.JMenuItem();
        JBSituacaoEstoque = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenu3.setText("Cadastrar");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        JBCadastrarCategoria.setText("Categoria");
        JBCadastrarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarCategoriaActionPerformed(evt);
            }
        });
        jMenu3.add(JBCadastrarCategoria);

        JBCadastrarProduto.setText("Produto");
        JBCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarProdutoActionPerformed(evt);
            }
        });
        jMenu3.add(JBCadastrarProduto);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Editar");

        JBEditarCategoria.setText("Categoria");
        JBEditarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEditarCategoriaActionPerformed(evt);
            }
        });
        jMenu4.add(JBEditarCategoria);

        JBEditarProduto.setText("Produto");
        JBEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEditarProdutoActionPerformed(evt);
            }
        });
        jMenu4.add(JBEditarProduto);

        JBEntradaSaida.setText("Entrada e saida");
        JBEntradaSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEntradaSaidaActionPerformed(evt);
            }
        });
        jMenu4.add(JBEntradaSaida);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Consultar");

        JBBalanço.setText("Balanço");
        JBBalanço.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBalançoActionPerformed(evt);
            }
        });
        jMenu2.add(JBBalanço);

        JBLista.setText("Lista de Preços");
        JBLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBListaActionPerformed(evt);
            }
        });
        jMenu2.add(JBLista);

        JBRelatorios.setText("Relátorio Produtos Por Categoria");
        JBRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRelatoriosActionPerformed(evt);
            }
        });
        jMenu2.add(JBRelatorios);

        JBSituacaoEstoque.setText("Situação do estoque");
        JBSituacaoEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSituacaoEstoqueActionPerformed(evt);
            }
        });
        jMenu2.add(JBSituacaoEstoque);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(466, 458));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JBCadastrarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarCategoriaActionPerformed
        FrmCadastroCategoria objeto = new FrmCadastroCategoria();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBCadastrarCategoriaActionPerformed

    private void JBEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEditarProdutoActionPerformed
        FrmEditarProduto objeto = new FrmEditarProduto();
        this.dispose();
        objeto.setVisible(true);      }//GEN-LAST:event_JBEditarProdutoActionPerformed

    private void JBCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarProdutoActionPerformed
        FrmCadastrarProduto objeto = new FrmCadastrarProduto();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBCadastrarProdutoActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

    }//GEN-LAST:event_jMenu3ActionPerformed

    private void JBEditarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEditarCategoriaActionPerformed
        FrmEditarCategoria objeto = new FrmEditarCategoria();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBEditarCategoriaActionPerformed

    private void JBListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBListaActionPerformed
        FrmListadePrecos objeto = new FrmListadePrecos();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBListaActionPerformed

    private void JBRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRelatoriosActionPerformed
        FrmRelatorios objeto = new FrmRelatorios();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBRelatoriosActionPerformed

    private void JBBalançoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBalançoActionPerformed
        FrmBalanco objeto = new FrmBalanco();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBBalançoActionPerformed

    private void JBSituacaoEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSituacaoEstoqueActionPerformed
        FrmSituacaoEstoque objeto = new FrmSituacaoEstoque();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBSituacaoEstoqueActionPerformed

    private void JBEntradaSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEntradaSaidaActionPerformed
        FrmEntradaSaida objeto = new FrmEntradaSaida();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBEntradaSaidaActionPerformed

    public static void main(String args[]) {
        ArrayList<Produto> estoque = new ArrayList<>();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmTelaInicial(estoque).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JBBalanço;
    private javax.swing.JMenuItem JBCadastrarCategoria;
    private javax.swing.JMenuItem JBCadastrarProduto;
    private javax.swing.JMenuItem JBEditarCategoria;
    private javax.swing.JMenuItem JBEditarProduto;
    private javax.swing.JMenuItem JBEntradaSaida;
    private javax.swing.JMenuItem JBLista;
    private javax.swing.JMenuItem JBRelatorios;
    private javax.swing.JMenuItem JBSituacaoEstoque;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
