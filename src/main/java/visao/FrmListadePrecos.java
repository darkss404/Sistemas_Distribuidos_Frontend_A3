package visao;

import dao.ProdutoDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Produto;

public class FrmListadePrecos extends javax.swing.JFrame {

    public FrmListadePrecos() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) JBTabela.getModel();
        JBTabela.setRowSorter(new javax.swing.table.TableRowSorter<>(modelo));
        preencherTabela();
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
                    p.getValorUnitario(),
                    p.getUnidade(),
                    p.getCategoria().getNome()

                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao preencher tabela: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JBTabela = new javax.swing.JTable();
        JBVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Valor Unitário", "Unidade", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(JBTabela);

        JBVoltar.setText("Voltar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBVoltar)
                .addContainerGap(538, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(JBVoltar)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(636, 468));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
        FrmTelaInicial objeto = new FrmTelaInicial();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBVoltarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListadePrecos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JBTabela;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
