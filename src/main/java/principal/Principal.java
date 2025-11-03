package principal;

import java.util.ArrayList;
import javax.swing.UIManager;
import visao.FrmTelaInicial;
import modelo.Produto;

public class Principal {

    public static void main(String[] args) {
        ArrayList<Produto> estoque = new ArrayList<>();
        FrmTelaInicial objetotela = new FrmTelaInicial(estoque);
        objetotela.setVisible(true);
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
    }
}
