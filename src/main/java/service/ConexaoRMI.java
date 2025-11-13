package service;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ConexaoRMI {

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