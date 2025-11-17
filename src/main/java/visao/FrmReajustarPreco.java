package visao;

import javax.swing.JDialog;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Produto;
import service.ProdutoService;

/**
 * JDialog responsável por realizar o reajuste de preço dos produtos cadastrados
 * no sistema de estoque. Permite selecionar um produto, visualizar seu preço
 * atual e aplicá-lo a um aumento ou redução percentual.
 *
 * A classe se conecta ao servidor RMI para obter, buscar e salvar os produtos.
 */
public class FrmReajustarPreco extends javax.swing.JDialog {

    /**
     * Serviço remoto para operações relacionadas a produtos.
     */
    private ProdutoService service;
    /**
     * Produto atualmente selecionado para reajuste.
     */
    private Produto produto;

    /**
     * Construtor padrão do formulário de reajuste de preço. Inicializa os
     * componentes, conecta ao servidor e carrega os produtos.
     */
    public FrmReajustarPreco() {
        super((java.awt.Frame) null, true);
        initComponents();
        setLocationRelativeTo(null);
        conectarComServidor();
        carregarProdutosNoCombo();
        JTFPrecoAtual.setEditable(false);

        JCBProduto.addActionListener(evt -> atualizarPrecoAtual());
    }

    /**
     * Conecta a interface ao servidor RMI responsável por fornecer o serviço de
     * produtos.
     */
    private void conectarComServidor() {
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            service = (ProdutoService) registro.lookup("EstoqueService");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao conectar com o servidor: " + e.getMessage(),
                    "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Construtor utilizado quando já existe um produto definido para reajuste.
     *
     * @param produto Produto previamente selecionado para ter seu preço
     * ajustado.
     */
    public FrmReajustarPreco(Produto produto) {
        super((java.awt.Frame) null, true);
        initComponents();
        setLocationRelativeTo(null);
        this.produto = produto;

        JCBProduto.setSelectedItem(produto.getNome());
        JTFPrecoAtual.setText(String.format("R$ %.2f", produto.getPreco()));
    }

    /**
     * Carrega no ComboBox todos os produtos obtidos via serviço remoto.
     */
    private void carregarProdutosNoCombo() {
        try {
            List<Produto> lista = service.listarProdutos();
            JCBProduto.removeAllItems();
            for (Produto p : lista) {
                JCBProduto.addItem(p.getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage());
        }
    }

    /**
     * Atualiza o campo de preço atual conforme o produto selecionado no
     * ComboBox.
     */
    private void atualizarPrecoAtual() {
        try {
            String nomeSelecionado = (String) JCBProduto.getSelectedItem();
            if (nomeSelecionado != null) {
                produto = service.buscarProdutoPorNome(nomeSelecionado);
                if (produto != null) {
                    JTFPrecoAtual.setText(String.format("R$ %.2f", produto.getPreco()));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar preço atual: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTFPrecoAtual = new javax.swing.JTextField();
        JTFPercentual = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        JBAumentar = new javax.swing.JButton();
        JBReduzir = new javax.swing.JButton();
        JCBProduto = new javax.swing.JComboBox<>();
        JBVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reajuste de Preço");
        setModal(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Reajuste de Preço");

        jLabel2.setText("Produto:");

        jLabel3.setText("Preço atual:");

        jLabel4.setText("Percentual:");

        JBAumentar.setText("➕ Aumentar");
        JBAumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAumentarActionPerformed(evt);
            }
        });

        JBReduzir.setText("➖ Reduzir");
        JBReduzir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBReduzirActionPerformed(evt);
            }
        });

        JCBProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(JTFPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addComponent(JBAumentar)
                                                .addGap(30, 30, 30)
                                                .addComponent(JBReduzir)
                                                .addGap(35, 35, 35)
                                                .addComponent(JBVoltar))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(JTFPrecoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(JCBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(41, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(134, 134, 134))
                        .addComponent(jSeparator1)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(JCBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(JTFPrecoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(JTFPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JBAumentar)
                                        .addComponent(JBReduzir)
                                        .addComponent(JBVoltar))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 /**
     * Evento do botão de aumento de preço. Calcula o aumento percentual e salva
     * no servidor.
     *
     * @param evt Evento de clique.
     */
    private void JBAumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAumentarActionPerformed
        try {
            double percentual = Double.parseDouble(JTFPercentual.getText());
            double precoAtual = produto.getPreco();
            double novoPreco = precoAtual + (precoAtual * percentual / 100);

            produto.setPreco(novoPreco);
            service.salvarProduto(produto);

            JOptionPane.showMessageDialog(null, "Preço aumentado com sucesso!");
            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite um percentual válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o preço: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_JBAumentarActionPerformed
    /**
     * Evento do botão de redução de preço. Calcula a redução percentual e
     * impede resultado negativo.
     *
     * @param evt Evento de clique.
     */
    private void JBReduzirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBReduzirActionPerformed
        try {
            double percentual = Double.parseDouble(JTFPercentual.getText());
            double precoAtual = produto.getPreco();
            double novoPreco = precoAtual - (precoAtual * percentual / 100);

            if (novoPreco < 0) {
                JOptionPane.showMessageDialog(null, "O novo preço não pode ser negativo.");
                return;
            }

            produto.setPreco(novoPreco);
            service.salvarProduto(produto);

            JOptionPane.showMessageDialog(null, "Preço reduzido com sucesso!");
            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite um percentual válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o preço: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_JBReduzirActionPerformed
    /**
     * Fecha a janela quando o botão Voltar é clicado.
     *
     * @param evt Evento de clique.
     */
    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_JBVoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAumentar;
    private javax.swing.JButton JBReduzir;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JComboBox<String> JCBProduto;
    private javax.swing.JTextField JTFPercentual;
    private javax.swing.JTextField JTFPrecoAtual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
