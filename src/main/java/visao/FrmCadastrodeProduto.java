package visao;

import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Produto;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import service.ProdutoService;
import service.CategoriaService;

public class FrmCadastrodeProduto extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmCadastrodeProduto.class.getName());
    private Produto produtoEmEdicao;

    public FrmCadastrodeProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        JCBCategoria.setEditable(false);
        carregarCategoriasDoBanco();
        setLocationRelativeTo(parent);
    }

    public FrmCadastrodeProduto(java.awt.Frame parent, boolean modal, Produto produto) {
        super(parent, modal);
        initComponents();
        this.produtoEmEdicao = produto;
        JCBCategoria.setEditable(false);
        carregarCategoriasDoBanco();

        JTFNome.setText(produto.getNome());
        JTFUnidade.setText(produto.getUnidade());
        JTFPreco.setText(String.valueOf(produto.getPreco()));
        JTFQuantidade.setText(String.valueOf(produto.getQuantidade()));
        JTFMin.setText(String.valueOf(produto.getMin()));
        JTFMax.setText(String.valueOf(produto.getMax()));
        JCBCategoria.setSelectedItem(produto.getCategoria());
        JBSalvar.setText("Atualizar");
        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JTFNome = new javax.swing.JTextField();
        JTFPreco = new javax.swing.JTextField();
        JTFMax = new javax.swing.JTextField();
        JTFUnidade = new javax.swing.JTextField();
        JTFQuantidade = new javax.swing.JTextField();
        JTFMin = new javax.swing.JTextField();
        JBSalvar = new javax.swing.JButton();
        JBCancelar = new javax.swing.JButton();
        JCBCategoria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setTitle("Cadastro de Produto");

        Nome.setText("Nome");

        jLabel2.setText("Preço");

        jLabel3.setText("Unidade");

        jLabel4.setText("Quantidade");

        jLabel5.setText("Categoria");

        jLabel6.setText("Minimo");

        jLabel7.setText("Maximo");

        JTFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomeActionPerformed(evt);
            }
        });

        JBSalvar.setText("Salvar");
        JBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalvarActionPerformed(evt);
            }
        });

        JBCancelar.setBackground(new java.awt.Color(220, 53, 69));
        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JCBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebidas", "Alimentos", "Higiene", "Limpeza" }));
        JCBCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Nome))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(JTFPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(JTFUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(JCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(JTFMin, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(JTFMax, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(278, 278, 278)
                                .addComponent(JBSalvar)
                                .addGap(39, 39, 39)
                                .addComponent(JBCancelar))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Nome)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel4))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JTFPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JTFMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JTFMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JTFUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JBSalvar)
                                        .addComponent(JBCancelar))
                                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBSalvarActionPerformed(java.awt.event.ActionEvent evt) {

        if (JTFNome.getText().isEmpty()
                || JTFUnidade.getText().isEmpty()
                || JTFPreco.getText().isEmpty()
                || JTFQuantidade.getText().isEmpty()
                || JTFMin.getText().isEmpty()
                || JTFMax.getText().isEmpty()
                || JCBCategoria.getSelectedItem() == null) {

            JOptionPane.showMessageDialog(this,
                    "preencha todos os campos antes de salvar.",
                    "Campos obrigatórios",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double preco = Double.parseDouble(JTFPreco.getText());
            int quantidade = Integer.parseInt(JTFQuantidade.getText());
            int min = Integer.parseInt(JTFMin.getText());
            int max = Integer.parseInt(JTFMax.getText());

            if (preco < 0 || quantidade < 0) {
                JOptionPane.showMessageDialog(this,
                        "Preço e quantidade não podem ser negativos.",
                        "Erro de validação",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (min > max) {
                JOptionPane.showMessageDialog(this,
                        "O valor mínimo não pode ser maior que o máximo.",
                        "Erro de validação",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nome = JTFNome.getText();
            String unidade = JTFUnidade.getText();
            String categoria = JCBCategoria.getSelectedItem().toString();

            Produto produto;

            if (produtoEmEdicao == null) {
                produto = new Produto(0, nome, unidade, preco, quantidade, min, max, categoria);
            } else {
                produto = produtoEmEdicao;
                produto.setNome(nome);
                produto.setUnidade(unidade);
                produto.setPreco(preco);
                produto.setQuantidade(quantidade);
                produto.setMin(min);
                produto.setMax(max);
                produto.setCategoria(categoria);
            }

            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            ProdutoService service = (ProdutoService) registro.lookup("EstoqueService");

            service.salvarProduto(produto);

            JOptionPane.showMessageDialog(this,
                    produtoEmEdicao == null ? "Produto cadastrado com sucesso!" : "Produto atualizado com sucesso!");

            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Preço, Quantidade, Mínimo e Máximo devem conter apenas números válidos.",
                    "Erro de validação",
                    JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao salvar produto: " + e.getMessage(),
                    "Erro de conexão",
                    JOptionPane.ERROR_MESSAGE);

            e.printStackTrace();
        }
    }


    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBCategoriaActionPerformed

    private void JTFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFNomeActionPerformed

    private void carregarCategoriasDoBanco() {
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            CategoriaService service = (CategoriaService) registro.lookup("EstoqueService");

            List<Categoria> lista = service.listarCategorias();
            JCBCategoria.removeAllItems();

            for (Categoria c : lista) {
                JCBCategoria.addItem(c.getNomeCategoria());
            }

            if (produtoEmEdicao != null) {
                String cat = produtoEmEdicao.getCategoria();
                boolean existe = false;
                for (int i = 0; i < JCBCategoria.getItemCount(); i++) {
                    if (JCBCategoria.getItemAt(i).equals(cat)) {
                        existe = true;
                        break;
                    }
                }
                if (!existe && cat != null && !cat.isBlank()) {
                    JCBCategoria.addItem(cat);
                }
                JCBCategoria.setSelectedItem(cat);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar categorias" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void limparCampos() {
        JTFNome.setText("");
        JTFPreco.setText("");
        JTFUnidade.setText("");
        JTFQuantidade.setText("");
        JTFMin.setText("");
        JTFMax.setText("");
        JCBCategoria.setSelectedIndex(-1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCancelar;
    private javax.swing.JButton JBSalvar;
    private javax.swing.JComboBox<String> JCBCategoria;
    private javax.swing.JTextField JTFMax;
    private javax.swing.JTextField JTFMin;
    private javax.swing.JTextField JTFNome;
    private javax.swing.JTextField JTFPreco;
    private javax.swing.JTextField JTFQuantidade;
    private javax.swing.JTextField JTFUnidade;
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}