package modelo;

import java.io.Serializable;
/**
 * Representa uma categoria de produto no sistema.
 * Contém informações como nome, tamanho e tipo de embalagem.
 * A classe implementa Serializable para permitir transporte via RMI.
 */
public class Categoria implements Serializable {
 /**
     * Identificador utilizado para controle de versão da serialização.
     */
    private static final long serialVersionUID = 1L; // Identificador de serialização
    private int id; // Identificador da categoria
    private String nomeCategoria; // Nome da categoria
    private String tamanho; // Tamanho associado
    private String embalagem; // Tipo de embalagem

    /**
     * Construtor completo.
     *
     * @param id identificador
     * @param nomeCategoria nome da categoria
     * @param tamanho tamanho
     * @param embalagem tipo de embalagem
     */
    public Categoria(int id, String nomeCategoria, String tamanho, String embalagem) {
        this.id = id;
        this.nomeCategoria = nomeCategoria;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
    }

    /**
     * Construtor sem id.
     *
     * @param nomeCategoria nome da categoria
     * @param tamanho tamanho
     * @param embalagem tipo de embalagem
     */
    public Categoria(String nomeCategoria, String tamanho, String embalagem) {
        this(0, nomeCategoria, tamanho, embalagem);
    }

    /**
     * @return id da categoria
     */
    public int getId() {
        return id;
    }

    /**
     * @param id define o id da categoria
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return nome da categoria
     */
    public String getNomeCategoria() {
        return nomeCategoria;
    }

    /**
     * @param nome define o nome da categoria
     */
    public void setNomeCategoria(String nome) {
        this.nomeCategoria = nome;
    }

    /**
     * @return tamanho da categoria
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho define o tamanho da categoria
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * @return embalagem da categoria
     */
    public String getEmbalagem() {
        return embalagem;
    }

    /**
     * @param embalagem define a embalagem da categoria
     */
    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    /**
     * @return nome da categoria como texto
     */
    @Override
    public String toString() {
        return nomeCategoria;
    }
}
