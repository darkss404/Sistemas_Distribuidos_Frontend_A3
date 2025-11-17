package visao;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Produto;
import service.ProdutoService;
import javax.swing.JPanel;
/**
 * Tela responsável por exibir a quantidade total de produtos agrupados por categoria.
 * Recupera os dados do servidor RMI e apresenta os resultados em uma tabela.
 * 
 * Esta janela faz parte do módulo de relatórios do sistema de estoque.
 */
public class FrmQuantidadeDeProduto extends javax.swing.JFrame {

    private FrmTelaPrincipal principal;
    private ProdutoService service;

    /**
     * Construtor da classe. Inicializa a interface, conecta ao servidor e carrega os dados.
     *
     * @param principal referência da tela principal para navegação.
     */
    public FrmQuantidadeDeProduto(FrmTelaPrincipal principal) {
        this.principal = principal;
        initComponents();
        conectarComServidor();
        carregarDados();
    }
   /**
     * Retorna o painel de conteúdo desta janela para ser exibido dentro de outra
     * interface (padrão usado na troca de telas da tela principal).
     *
     * @return JPanel contendo os componentes da janela.
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
     * Realiza a conexão com o servidor RMI e obtém a referência do serviço ProdutoService.
     * Apresenta mensagem caso ocorra alguma falha.
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
     * Carrega as quantidades de produtos agrupadas por categoria e preenche a tabela.
     * Caso ocorra algum erro, uma mensagem é exibida ao usuário.
     */
    private void carregarDados() {
        try {
            List<Produto> lista = service.listarProdutos();
 // Mapa para acumular quantidade por categoria
            Map<String, Integer> contagemPorCategoria = new HashMap<>();
            for (Produto p : lista) {
                String categoria = (p.getCategoria() != null && !p.getCategoria().isEmpty())
                        ? p.getCategoria()
                        : "Sem categoria";
                contagemPorCategoria.put(categoria,
                        contagemPorCategoria.getOrDefault(categoria, 0) + p.getQuantidade());
            }

            DefaultTableModel modelo = (DefaultTableModel) JTQuantidadeProdutoCategoria.getModel();
            modelo.setRowCount(0);
            for (Map.Entry<String, Integer> entry : contagemPorCategoria.entrySet()) {
                modelo.addRow(new Object[]{entry.getKey(), entry.getValue()});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar dados: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTQuantidadeProdutoCategoria = new javax.swing.JTable();
        JBAtualizar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        JBFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quantidade de Produtos por Categoria");

        JTQuantidadeProdutoCategoria.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String [] {
                        "Categoria", "Quantidade"
                }
        ));
        jScrollPane1.setViewportView(JTQuantidadeProdutoCategoria);

        JBAtualizar.setText("Atualizar");
        JBAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAtualizarActionPerformed(evt);
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
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(75, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(63, 63, 63))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(80, 80, 80)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(117, 117, 117)
                                                .addComponent(JBAtualizar)
                                                .addGap(64, 64, 64)
                                                .addComponent(JBFechar)))
                                .addContainerGap(86, Short.MAX_VALUE))
                        .addComponent(jSeparator2)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JBAtualizar)
                                        .addComponent(JBFechar))
                                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  /**
     * Botão de atualização. Recarrega os dados da tabela consultando o servidor.
     *
     * @param evt o evento disparado pelo clique no botão
     */
    private void JBAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAtualizarActionPerformed
        carregarDados();
    }//GEN-LAST:event_JBAtualizarActionPerformed
    /**
     * Botão de fechar. Retorna à tela de relatórios da tela principal.
     *
     * @param evt o evento disparado pelo clique no botão
     */
    private void JBFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBFecharActionPerformed
        principal.showPanel("Relatorios");
    }//GEN-LAST:event_JBFecharActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAtualizar;
    private javax.swing.JButton JBFechar;
    private javax.swing.JTable JTQuantidadeProdutoCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}