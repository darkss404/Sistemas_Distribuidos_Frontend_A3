package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.Produto;

/**
 * Interface remota responsável pelas operações relacionadas a produtos no
 * sistema de estoque. Permite salvar, excluir, buscar e registrar movimentações
 * de entrada e saída via RMI.
 */
public interface ProdutoService extends Remote {

    /**
     * Salva um novo produto ou atualiza um produto existente.
     *
     * @param produto Objeto Produto contendo os dados a serem salvos.
     * @throws RemoteException Caso ocorra erro de comunicação via RMI.
     */
    void salvarProduto(Produto produto) throws RemoteException;

    /**
     * Exclui um produto com base no seu ID.
     *
     * @param id Identificador único do produto.
     * @return true se o produto foi excluído com sucesso, false caso contrário.
     * @throws RemoteException Caso ocorra erro de comunicação via RMI.
     */
    boolean DeletarProdutoID(int id) throws RemoteException;

    /**
     * Retorna uma lista contendo todos os produtos cadastrados.
     *
     * @return Lista de objetos Produto.
     * @throws RemoteException Caso ocorra erro de comunicação via RMI.
     */
    List<Produto> listarProdutos() throws RemoteException;

    /**
     * Busca um produto com base no seu ID.
     *
     * @param id Identificador único do produto.
     * @return Objeto Produto correspondente ao ID informado, ou null caso não
     * encontrado.
     * @throws RemoteException Caso ocorra erro de comunicação via RMI.
     */
    Produto buscarProdutoPorId(int id) throws RemoteException;

    /**
     * Busca um produto com base no nome informado.
     *
     * @param nome Nome do produto a ser pesquisado.
     * @return Objeto Produto correspondente ao nome informado, ou null caso não
     * encontrado.
     * @throws RemoteException Caso ocorra erro de comunicação via RMI.
     */
    Produto buscarProdutoPorNome(String nome) throws RemoteException;

    /**
     * Registra uma entrada de estoque para um produto específico.
     *
     * @param idProduto ID do produto que sofrerá a entrada.
     * @param quantidade Quantidade a ser adicionada ao estoque.
     * @return true se o processo foi concluído com sucesso, false caso
     * contrário.
     * @throws RemoteException Caso ocorra erro de comunicação via RMI.
     */
    boolean registrarEntradaProduto(int idProduto, int quantidade) throws RemoteException;

    /**
     * Registra uma saída de estoque para um produto específico.
     *
     * @param idProduto ID do produto que sofrerá a saída.
     * @param quantidade Quantidade a ser removida do estoque.
     * @return true se o processo foi concluído com sucesso, false caso
     * contrário.
     * @throws RemoteException Caso ocorra erro de comunicação via RMI.
     */
    boolean registrarSaidaProduto(int idProduto, int quantidade) throws RemoteException;
}
