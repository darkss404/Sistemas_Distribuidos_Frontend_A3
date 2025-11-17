package service;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Classe responsável por estabelecer a conexão com o servidor RMI. Fornece um
 * método utilitário para consultar o registro RMI e obter uma referência remota
 * ao serviço de estoque.
 */
public class ConexaoRMI {

    /**
     * Obtém a referência remota ao serviço registrado no RMI.
     *
     * Tenta se conectar ao registro RMI usando o host "localhost" e a porta
     * 1099. Em caso de sucesso, retorna o objeto remoto registrado como
     * "EstoqueService". Caso ocorra qualquer erro na conexão ou busca, retorna
     * null.
     *
     * @return o objeto remoto associado a "EstoqueService" ou null caso haja
     * falha
     */
    public static Object getService() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Object service = registry.lookup("EstoqueService");
            System.out.println("Conectado ao servidor RMI com sucesso!");
            return service;
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao servidor RMI: " + e.getMessage());
            return null;
        }
    }
}
