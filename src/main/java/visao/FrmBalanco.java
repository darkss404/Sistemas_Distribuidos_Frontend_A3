package visao;

import dao.ProdutoDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Produto;

public class FrmBalanco extends javax.swing.JFrame {

    public FrmBalanco() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) JBTabela.getModel();
        JBTabela.setRowSorter(new javax.swing.table.TableRowSorter<>(modelo));
        preencherTabela();
        setLocationRelativeTo(null);
    }

    private void preencherTabela() {
        try {
            ProdutoDao dao = new ProdutoDao();
            List<Produto> produtos = dao.listar();

            DefaultTableModel model = (DefaultTableModel) JBTabela.getModel();
            model.setRowCount(0);

            for (Produto p : produtos) {
                model.addRow(new Object[]{
                    p.getNome(),
                    p.getQtdAtual(),
                    p.getValorUnitario(),
                    p.getValorTotal()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao preencher tabela: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        JBTabela = new javax.swing.JTable();
        voltarBalanco = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Qt Disponível", "Valor unitario", "Valor total"
            }
        ));
        jScrollPane2.setViewportView(JBTabela);

        voltarBalanco.setText("Voltar");
        voltarBalanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarBalancoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(voltarBalanco)
                        .addGap(376, 376, 376)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(voltarBalanco)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarBalancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarBalancoActionPerformed
        // TODO add your handling code here:
        new visao.FrmTelaInicial().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_voltarBalancoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBalanco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JBTabela;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton voltarBalanco;
    // End of variables declaration//GEN-END:variables
}
