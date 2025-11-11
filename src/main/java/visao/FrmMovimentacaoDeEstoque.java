package visao;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Produto;
import modelo.RegistroMovimentacao;
import java.time.LocalDate;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import service.EstoqueService;
import javax.swing.JPanel;

public class FrmMovimentacaoDeEstoque extends javax.swing.JFrame {

    private FrmTelaPrincipal principal;
    private EstoqueService service;

    public FrmMovimentacaoDeEstoque(FrmTelaPrincipal principal) {
        this.principal = principal;
        initComponents();
        conectarComServidor();
        carregarProdutosNoCombo();
        JTFData.setText(LocalDate.now().toString());
        JTFData.setEditable(false);
        javax.swing.ButtonGroup grupoTipoMovimentacao = new javax.swing.ButtonGroup();
        grupoTipoMovimentacao.add(JRBEntrada);
        grupoTipoMovimentacao.add(JRBSaida);
        atualizarTabelaMovimentacoesImediato(); // Método corrigido
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

    private void conectarComServidor() {
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            service = (EstoqueService) registro.lookup("EstoqueService");
            System.out.println("Conectado ao servidor RMI - Movimentação");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao conectar com o servidor: " + e.getMessage(),
                    "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private boolean registrarMovimentacao(String tipo) {
        try {
            String nomeProduto = (String) JCBProduto.getSelectedItem();
            if (nomeProduto == null || nomeProduto.trim().isEmpty() || nomeProduto.equals("Nenhum produto cadastrado")) {
                JOptionPane.showMessageDialog(this, "Selecione um produto válido.");
                return false;
            }

            int quantidade;
            try {
                quantidade = Integer.parseInt(JTFQuantidade.getText());
                if (quantidade <= 0) {
                    JOptionPane.showMessageDialog(this, "A quantidade deve ser maior que zero.");
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Informe uma quantidade válida.");
                return false;
            }

            Produto produto = service.buscarProdutoPorNome(nomeProduto);
            if (produto == null || produto.getId() == 0) {
                JOptionPane.showMessageDialog(this, "Produto não encontrado no servidor.");
                return false;
            }

            boolean sucesso;
            if (tipo.equals("Entrada")) {
                sucesso = service.registrarEntradaProduto(produto.getId(), quantidade);
            } else { // Saída
                if (produto.getQuantidade() < quantidade) {
                    JOptionPane.showMessageDialog(this,
                            "Estoque insuficiente para saída.\n" +
                                    "Estoque atual: " + produto.getQuantidade() + "\n" +
                                    "Quantidade solicitada: " + quantidade);
                    return false;
                }
                sucesso = service.registrarSaidaProduto(produto.getId(), quantidade);
            }

            return sucesso;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao registrar movimentação: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // MÉTODO CORRIGIDO - ATUALIZAÇÃO IMEDIATA
    private void atualizarTabelaMovimentacoesImediato() {
        try {
            List<RegistroMovimentacao> lista = service.listarMovimentacoes();

            DefaultTableModel model = (DefaultTableModel) JTMovimentacao.getModel();
            model.setRowCount(0); // limpa a tabela

            if (lista != null && !lista.isEmpty()) {
                for (RegistroMovimentacao reg : lista) {
                    Produto produto = service.buscarProdutoPorId(reg.getProdutoId());
                    String nomeProduto = (produto != null) ? produto.getNome() : "ID: " + reg.getProdutoId();

                    // Buscar saldo atual do produto
                    int saldoAtual = (produto != null) ? produto.getQuantidade() : 0;

                    // Formatar data
                    String dataFormatada = reg.getDataMovimentacao();

                    model.addRow(new Object[]{
                            dataFormatada,
                            nomeProduto,
                            reg.getTipoMovimentacao(),
                            reg.getQuantidade(),
                            saldoAtual
                    });
                }
                System.out.println("Tabela atualizada com " + lista.size() + " registros de movimentação.");
            } else {
                System.out.println("Nenhuma movimentação encontrada para exibir.");
            }

        } catch (Exception e) {
            System.err.println("Erro ao atualizar tabela de movimentações: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void carregarProdutosNoCombo() {
        try {
            List<Produto> lista = service.listarProdutos();
            JCBProduto.removeAllItems();
            if (lista != null && !lista.isEmpty()) {
                for (Produto p : lista) {
                    JCBProduto.addItem(p.getNome());
                }
            } else {
                JCBProduto.addItem("Nenhum produto cadastrado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void limparCampos() {
        JTFQuantidade.setText("");
        JRBEntrada.setSelected(false);
        JRBSaida.setSelected(false);
        if (JCBProduto.getItemCount() > 0) {
            JCBProduto.setSelectedIndex(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JCBProduto = new javax.swing.JComboBox<>();
        JRBEntrada = new javax.swing.JRadioButton();
        JRBSaida = new javax.swing.JRadioButton();
        JTFQuantidade = new javax.swing.JTextField();
        JTFData = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        JBRegistrar = new javax.swing.JButton();
        JBLimpar = new javax.swing.JButton();
        JBSair = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTMovimentacao = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movimentação de Estoque");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Movimentação de Estoque");

        jLabel2.setText("Produto:");

        jLabel3.setText("Tipo:");

        jLabel4.setText("Quantidade:");

        jLabel5.setText("Data:");

        JCBProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JRBEntrada.setText("Entrada");

        JRBSaida.setText("Saída");

        JBRegistrar.setText("Registrar");
        JBRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRegistrarActionPerformed(evt);
            }
        });

        JBLimpar.setText("Limpar");
        JBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimparActionPerformed(evt);
            }
        });

        JBSair.setBackground(new java.awt.Color(220, 53, 69));
        JBSair.setText("Sair");
        JBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSairActionPerformed(evt);
            }
        });

        JTMovimentacao.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "Data", "Produto", "Tipo", "Quantidade", "Saldo"
                }
        ));
        jScrollPane1.setViewportView(JTMovimentacao);

        jLabel6.setText("Movimentações recentes:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addComponent(jSeparator2)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(197, 197, 197))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(JTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(JCBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(JRBEntrada)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(JRBSaida))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(JTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(125, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JBRegistrar)
                                .addGap(18, 18, 18)
                                .addComponent(JBLimpar)
                                .addGap(18, 18, 18)
                                .addComponent(JBSair)
                                .addGap(192, 192, 192))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(2, 2, 2)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(JCBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(JRBEntrada)
                                        .addComponent(JRBSaida))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(JTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(JTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JBRegistrar)
                                        .addComponent(JBLimpar)
                                        .addComponent(JBSair))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSairActionPerformed
        principal.showPanel("Menu");
    }//GEN-LAST:event_JBSairActionPerformed

    private void JBRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRegistrarActionPerformed
        System.out.println("Botão Registrar clicado!");

        String tipo = JRBEntrada.isSelected() ? "Entrada" : JRBSaida.isSelected() ? "Saída" : "";
        if (tipo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione o tipo de movimentação.");
            return;
        }

        boolean sucesso = registrarMovimentacao(tipo);

        if (sucesso) {
            // ATUALIZAÇÃO IMEDIATA DA TABELA
            atualizarTabelaMovimentacoesImediato();

            JOptionPane.showMessageDialog(this,
                    tipo + " registrada com sucesso!\nTabela atualizada automaticamente.",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            // Limpar campos após sucesso
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Falha ao registrar " + tipo.toLowerCase() + ".",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBRegistrarActionPerformed

    private void JBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_JBLimparActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBLimpar;
    private javax.swing.JButton JBRegistrar;
    private javax.swing.JButton JBSair;
    private javax.swing.JComboBox<String> JCBProduto;
    private javax.swing.JRadioButton JRBEntrada;
    private javax.swing.JRadioButton JRBSaida;
    private javax.swing.JTextField JTFData;
    private javax.swing.JTextField JTFQuantidade;
    private javax.swing.JTable JTMovimentacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}