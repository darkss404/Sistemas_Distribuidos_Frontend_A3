package visao;

import modelo.Categoria;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import service.CategoriaService;
import javax.swing.JPanel;

/**
 * Tela responsável por listar, filtrar e gerenciar categorias cadastradas no
 * sistema. Permite adicionar, editar e excluir categorias usando comunicação
 * RMI.
 */
public class FrmListadeCategoria extends javax.swing.JFrame {

    private FrmTelaPrincipal principal;

    /**
     * Construtor da tela de listagem de categorias.
     *
     * @param principal referência da tela principal para permitir retorno ao
     * menu.
     */
    public FrmListadeCategoria(FrmTelaPrincipal principal) {
        this.principal = principal;
        initComponents();
        carregarTabela();
    }

    /**
     * Retorna o painel contendo todos os componentes visuais da janela. Usado
     * para trocar telas dentro do JFrame principal.
     *
     * @return JPanel contendo o conteúdo atual da janela.
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
     * Carrega todas as categorias do servidor RMI e popula a tabela da
     * interface. Atualiza a JTable com ID, Nome, Tamanho e Embalagem.
     */
    public void carregarTabela() {

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            CategoriaService service = (CategoriaService) registry.lookup("EstoqueService");

            List<Categoria> lista = service.listarCategorias();

            DefaultTableModel modelo = (DefaultTableModel) JTListaCategoria.getModel();
            modelo.setRowCount(0);

            for (Categoria c : lista) {
                modelo.addRow(new Object[]{
                    c.getId(),
                    c.getNomeCategoria(),
                    c.getTamanho(),
                    c.getEmbalagem()
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar categorias: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTListaCategoria = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        JBVoltarLC = new javax.swing.JButton();
        JBAdicionar = new javax.swing.JButton();
        JBEditar = new javax.swing.JButton();
        JBExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Categoria");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Lista de Categoria");

        JTListaCategoria.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "ID", "Nome", "Tamanho", "Embalagem"
                }
        ));
        jScrollPane1.setViewportView(JTListaCategoria);

        JBVoltarLC.setText("Voltar");
        JBVoltarLC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarLCActionPerformed(evt);
            }
        });

        JBAdicionar.setText("Adicionar");
        JBAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAdicionarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(JBAdicionar)
                                                .addGap(42, 42, 42)
                                                .addComponent(JBEditar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(JBVoltarLC)
                                                .addGap(42, 42, 42)
                                                .addComponent(JBExcluir)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(230, 230, 230))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JBVoltarLC)
                                        .addComponent(JBAdicionar)
                                        .addComponent(JBEditar)
                                        .addComponent(JBExcluir))
                                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Ação do botão "Voltar". Retorna para o painel principal exibindo o menu.
     *
     * @param evt evento de clique do botão
     */
    private void JBVoltarLCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarLCActionPerformed
        principal.showPanel("Menu");
    }//GEN-LAST:event_JBVoltarLCActionPerformed
    /**
     * Ação do botão "Adicionar". Abre a tela de cadastro de categoria no modo
     * de criação e após o fechamento recarrega a tabela de categorias.
     *
     * @param evt evento de clique do botão
     */
    private void JBAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAdicionarActionPerformed
        FrmCadastroDeCategoria dialog = new FrmCadastroDeCategoria(null, true);
        dialog.setVisible(true);
        carregarTabela();
    }//GEN-LAST:event_JBAdicionarActionPerformed
    /**
     * Ação do botão "Editar". Verifica se uma categoria foi selecionada. Caso
     * sim, obtém os dados da linha selecionada, cria um objeto Categoria e abre
     * a tela de cadastro no modo edição. Ao finalizar, atualiza a tabela.
     *
     * @param evt evento de clique do botão
     */
    private void JBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEditarActionPerformed
        int linhaSelecionada = JTListaCategoria.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma categoria para editar.");
            return;
        }

        int id = (int) JTListaCategoria.getValueAt(linhaSelecionada, 0);
        String nome = (String) JTListaCategoria.getValueAt(linhaSelecionada, 1);
        String tamanho = (String) JTListaCategoria.getValueAt(linhaSelecionada, 2);
        String embalagem = (String) JTListaCategoria.getValueAt(linhaSelecionada, 3);

        Categoria categoria = new Categoria(id, nome, tamanho, embalagem);

        FrmCadastroDeCategoria dialog = new FrmCadastroDeCategoria(null, true, categoria);
        dialog.setVisible(true);
        carregarTabela();
    }//GEN-LAST:event_JBEditarActionPerformed
    /**
     * Ação do botão "Excluir". Verifica se uma categoria foi selecionada. Caso
     * sim, solicita confirmação ao usuário e envia a requisição ao servidor
     * para excluir a categoria pelo ID. Em seguida atualiza a tabela.
     *
     * @param evt evento de clique do botão
     */
    private void JBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExcluirActionPerformed
        int linhaSelecionada = JTListaCategoria.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma categoria para excluir.");
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir essa categoria?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        int idCategoria = (int) JTListaCategoria.getValueAt(linhaSelecionada, 0);

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            CategoriaService service = (CategoriaService) registry.lookup("EstoqueService");

            service.excluirCategoria(idCategoria);
            JOptionPane.showMessageDialog(this, "Categoria excluída com sucesso!");
            carregarTabela();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao excluir categoria: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAdicionar;
    private javax.swing.JButton JBEditar;
    private javax.swing.JButton JBExcluir;
    private javax.swing.JButton JBVoltarLC;
    private javax.swing.JTable JTListaCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
