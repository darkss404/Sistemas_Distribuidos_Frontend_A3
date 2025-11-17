package modelo;

import java.io.Serializable;

/**
 * Representa um produto cadastrado no sistema de estoque. Armazena informações
 * como nome, unidade de medida, preço, quantidades mínima, máxima e atual, além
 * da categoria.
 *
 * Implementa Serializable para permitir persistência do objeto.
 */
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador único do produto.
     */
    private int id;

    /**
     * Nome do produto.
     */
    private String nome;

    /**
     * Unidade de medida do produto, como "kg", "un" ou "L".
     */
    private String unidade;

    /**
     * Preço unitário do produto.
     */
    private double preco;

    /**
     * Quantidade atual do produto em estoque.
     */
    private int quantidade;

    /**
     * Quantidade mínima permitida em estoque.
     */
    private int min;

    /**
     * Quantidade máxima permitida em estoque.
     */
    private int max;

    /**
     * Categoria do produto.
     */
    private String categoria;

    /**
     * Construtor padrão da classe Produto. Inicializa os atributos com valores
     * padrão.
     */
    public Produto() {
        this(0, "", "", 0.0, 0, 0, 1000, "");
    }

    /**
     * Construtor completo da classe Produto.
     *
     * @param id identificador único do produto
     * @param nome nome do produto
     * @param unidade unidade de medida do produto
     * @param preco preço unitário do produto
     * @param quantidade quantidade atual em estoque
     * @param min quantidade mínima permitida
     * @param max quantidade máxima permitida
     * @param categoria categoria a que o produto pertence
     */
    public Produto(int id, String nome, String unidade, double preco, int quantidade, int min, int max, String categoria) {
        this.id = id;
        this.nome = nome;
        this.unidade = unidade;
        this.preco = preco;
        this.quantidade = quantidade;
        this.min = min;
        this.max = max;
        this.categoria = categoria;
    }

    /**
     * @return o identificador do produto
     */
    public int getId() {
        return id;
    }

    /**
     * @param id define o identificador do produto
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return o nome do produto
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome define o nome do produto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return a unidade de medida do produto
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade define a unidade de medida do produto
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * @return o preço unitário do produto
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco define o preço unitário do produto
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return a quantidade atual em estoque
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade define a quantidade atual em estoque
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return a quantidade mínima permitida
     */
    public int getMin() {
        return min;
    }

    /**
     * @param min define a quantidade mínima permitida
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * @return a quantidade máxima permitida
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max define a quantidade máxima permitida
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return a categoria do produto
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param nomeCategoria define a categoria do produto
     */
    public void setCategoria(String nomeCategoria) {
        this.categoria = nomeCategoria;
    }

    /**
     * Retorna o nome do produto como representação textual.
     *
     * @return nome do produto
     */
    @Override
    public String toString() {
        return this.nome;
    }

    /**
     * Realiza a verificação da quantidade atual em relação aos valores mínimo e
     * máximo definidos para o produto.
     *
     * @return mensagem informando se a quantidade está baixa, alta ou adequada
     */
    public String VerificacaoDeQuantidade() {
        if (this.getQuantidade() < this.getMin()) {
            return "A quantidade do produto " + getNome()
                    + " está muito baixa, a quantidade mínima é "
                    + getMin() + " unidades.";
        } else if (this.getQuantidade() > this.getMax()) {
            return "A quantidade do produto " + getNome()
                    + " é muito alta, a quantidade máxima é "
                    + getMax() + " unidades.";
        } else {
            return "Produto registrado com sucesso. A quantidade é "
                    + getQuantidade() + " unidades.";
        }
    }
}
