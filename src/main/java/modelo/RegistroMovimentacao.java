package modelo;

import java.io.Serializable;

/**
 * Representa um registro de movimentação de estoque, contendo informações sobre
 * o tipo de movimentação, quantidade, data e observações. Pode representar
 * entradas, saídas ou ajustes.
 */
public class RegistroMovimentacao implements Serializable {

    /**
     * Identificador único para fins de serialização.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador do registro de movimentação.
     */
    private int id;

    /**
     * Identificador do produto relacionado à movimentação.
     */
    private int produtoId;

    /**
     * Tipo de movimentação, como Entrada, Saída ou Ajuste.
     */
    private String tipoMovimentacao;

    /**
     * Quantidade movimentada.
     */
    private int quantidade;

    /**
     * Observações adicionais sobre a movimentação.
     */
    private String observacao;

    /**
     * Data em que a movimentação foi realizada.
     */
    private String dataMovimentacao;

    /**
     * Construtor padrão da classe.
     */
    public RegistroMovimentacao() {
    }

    /**
     * Construtor completo da classe.
     *
     * @param id identificador da movimentação
     * @param produtoId identificador do produto
     * @param tipoMovimentacao tipo da movimentação
     * @param quantidade quantidade movimentada
     * @param observacao texto adicional
     * @param dataMovimentacao data da movimentação
     */
    public RegistroMovimentacao(int id, int produtoId, String tipoMovimentacao,
            int quantidade, String observacao, String dataMovimentacao) {
        this.id = id;
        this.produtoId = produtoId;
        this.tipoMovimentacao = tipoMovimentacao;
        this.quantidade = quantidade;
        this.observacao = observacao;
        this.dataMovimentacao = dataMovimentacao;
    }

    /**
     * Retorna o ID do registro.
     *
     * @return id do registro
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do registro.
     *
     * @param id novo identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o ID do produto.
     *
     * @return id do produto
     */
    public int getProdutoId() {
        return produtoId;
    }

    /**
     * Define o ID do produto relacionado.
     *
     * @param produtoId novo id do produto
     */
    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    /**
     * Retorna o tipo de movimentação.
     *
     * @return tipo da movimentação
     */
    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    /**
     * Define o tipo de movimentação.
     *
     * @param tipoMovimentacao novo tipo
     */
    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    /**
     * Retorna a quantidade movimentada.
     *
     * @return quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade movimentada.
     *
     * @param quantidade nova quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Retorna uma observação da movimentação.
     *
     * @return texto de observação
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * Define uma observação para a movimentação.
     *
     * @param observacao nova observação
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * Retorna a data da movimentação.
     *
     * @return data em formato string
     */
    public String getDataMovimentacao() {
        return dataMovimentacao;
    }

    /**
     * Define a data da movimentação.
     *
     * @param dataMovimentacao nova data
     */
    public void setDataMovimentacao(String dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    /**
     * Retorna uma representação textual do registro.
     *
     * @return texto contendo informações da movimentação
     */
    @Override
    public String toString() {
        return "RegistroMovimentacao{"
                + "id=" + id
                + ", produtoId=" + produtoId
                + ", tipoMovimentacao='" + tipoMovimentacao + '\''
                + ", quantidade=" + quantidade
                + ", observacao='" + observacao + '\''
                + ", dataMovimentacao='" + dataMovimentacao + '\''
                + '}';
    }
}
