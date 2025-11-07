package service;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ConexaoRMI {

    private static EstoqueService service;

    public static EstoqueService getService() {
        if (service == null) {
            try {

                Registry registry = LocateRegistry.getRegistry("localhost", 1099);
                service = (EstoqueService) registry.lookup("EstoqueService");
                System.out.println("Conectado ao servidor RMI");
            } catch (Exception e) {
                System.err.println("Erro ao conectar ao servidor RMI: " + e.getMessage());
            }
        }
        return service;
    }
}
