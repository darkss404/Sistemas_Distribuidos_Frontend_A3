package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.Categoria;

/**
 * Interface remota que define operações de serviço relacionadas à categoria no
 * sistema de estoque. Utilizada para comunicação via RMI.
 */
public interface CategoriaService extends Remote {

    /**
     * Salva uma nova categoria no sistema.
     *
     * @param categoria categoria a ser salva
     * @throws RemoteException caso ocorra erro na comunicação RMI
     */
    void salvarCategoria(Categoria categoria) throws RemoteException;

    /**
     * Retorna uma lista com todas as categorias cadastradas.
     *
     * @return lista de categorias
     * @throws RemoteException caso ocorra erro na comunicação RMI
     */
    List<Categoria> listarCategorias() throws RemoteException;

    /**
     * Exclui uma categoria com base no ID informado.
     *
     * @param id identificador da categoria
     * @throws RemoteException caso ocorra erro na comunicação RMI
     */
    void excluirCategoria(int id) throws RemoteException;
}
