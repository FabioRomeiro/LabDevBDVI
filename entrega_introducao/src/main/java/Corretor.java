import java.util.ArrayList;
import java.util.List;

public class Corretor implements CorretorInterface {
    @Override
    public double corrige(List<String> gabarito, List<String> respostas) {
        double notaPorQuestao = 10 / gabarito.size();
        double nota = 0.0;
        for (int i = 0; i < gabarito.size() && i < respostas.size(); i++) {
            if (respostas.get(i).equals(gabarito.get(i))) {
                nota += notaPorQuestao;
            }
        }
        return nota;
    }
}
