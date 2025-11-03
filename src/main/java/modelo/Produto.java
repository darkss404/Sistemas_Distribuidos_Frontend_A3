package modelo;

public class Produto {

    private int id;
    private String nome;
    private String unidade;
    private Double valorUnitario;
    private int qtdMin;
    private int qtdMax;
    private int qtdAtual;
    private Categoria categoria;
    private Double valorTotal;
    private int qtdEntrada;
    private int qtdSaida;

    public double getValorTotal() {
        return valorUnitario * qtdAtual;
    }

    public Produto(int id, String nome, String unidade, Double valorUnitario, int qtdMin, int qtdMax, int qtdAtual, Categoria categoria, Double valorTotal, int qtdEntrada, int qtdSaida) {
        this.id = id;
        this.nome = nome;
        this.unidade = unidade;
        this.valorUnitario = valorUnitario;
        this.qtdMin = qtdMin;
        this.qtdMax = qtdMax;
        this.qtdAtual = qtdAtual;
        this.categoria = categoria;
        this.valorTotal = valorTotal;
        this.qtdEntrada = qtdEntrada;
        this.qtdSaida = qtdSaida;
    }

    public Produto(String nome, String unidade, Double valorUnitario,
            int qtdMin, int qtdMax, int qtdAtual, Categoria categoria, int qtdEntrada, int qtdSaida) {
        this.nome = nome;
        this.unidade = unidade;
        this.valorUnitario = valorUnitario;
        this.qtdMin = qtdMin;
        this.qtdMax = qtdMax;
        this.qtdAtual = qtdAtual;
        this.categoria = categoria;
        this.qtdEntrada = qtdEntrada;
        this.qtdSaida = qtdSaida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQtdMin() {
        return qtdMin;
    }

    public void setQtdMin(int qtdMin) {
        this.qtdMin = qtdMin;
    }

    public int getQtdMax() {
        return qtdMax;
    }

    public void setQtdMax(int qtdMax) {
        this.qtdMax = qtdMax;
    }

    public int getQtdAtual() {
        return qtdAtual;
    }

    public void setQtdAtual(int qtdAtual) {
        this.qtdAtual = qtdAtual;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNomeCategoria() {
        return categoria != null ? categoria.getNome() : "Sem categoria";
    }

    @Override
    public String toString() {
        return nome + " (" + unidade + ")";
    }

    public Double getValor() {
        return getValorUnitario();
    }

    public int getQtMax() {
        return getQtdMax();
    }

    public int getQtEstoque() {
        return getQtdAtual();
    }

    public int getQtMin() {
        return getQtdMin();
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQtdEntrada() {
        return qtdEntrada;
    }

    public void setQtdEntrada(int qtdEntrada) {
        this.qtdEntrada = qtdEntrada;
    }

    public int getQtdSaida() {
        return qtdSaida;
    }

    public void setQtdSaida(int qtdSaida) {
        this.qtdSaida = qtdSaida;
    }

}
