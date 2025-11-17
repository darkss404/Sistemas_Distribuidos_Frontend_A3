package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.RegistroMovimentacao;

/**
 * Interface remota responsável pelos serviços de movimentação de produtos no
 * sistema. Define operações para registrar movimentações e consultar registros
 * existentes.
 *
 * Esta interface é utilizada através de chamadas RMI, portanto todos os métodos
 * devem lançar RemoteException.
 */
public interface MovimentacaoService extends Remote {

    /**
     * Retorna uma lista contendo todas as movimentações registradas no sistema.
     *
     * @return lista de objetos RegistroMovimentacao contendo todas as
     * movimentações
     * @throws RemoteException caso ocorra erro de comunicação no RMI
     */
    List<RegistroMovimentacao> listarMovimentacoes() throws RemoteException;

    /**
     * Registra uma nova movimentação no sistema.
     *
     * @param registro objeto RegistroMovimentacao com todos os dados da
     * movimentação
     * @return true se o registro for salvo com sucesso, false caso contrário
     * @throws RemoteException caso ocorra erro de comunicação no RMI
     */
    boolean registrarMovimentacao(RegistroMovimentacao registro) throws RemoteException;

    /**
     * Lista todas as movimentações relacionadas a um produto específico.
     *
     * @param produtoId identificador do produto desejado
     * @return lista de movimentações associadas ao produto informado
     * @throws RemoteException caso ocorra erro de comunicação no RMI
     */
    List<RegistroMovimentacao> listarMovimentacoesPorProduto(int produtoId) throws RemoteException;
}
