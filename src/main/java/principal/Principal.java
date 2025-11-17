package principal;

import visao.FrmTelaPrincipal;

/**
 * Classe principal do sistema. Responsável por iniciar a interface gráfica
 * exibindo a tela principal.
 */
public class Principal {

    /**
     * Método responsável por iniciar o sistema.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        FrmTelaPrincipal telaPrincipal = new FrmTelaPrincipal();
        telaPrincipal.setVisible(true);
    }
}
