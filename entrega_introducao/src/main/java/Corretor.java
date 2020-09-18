import java.util.ArrayList;
import java.util.List;

public class Corretor implements CorretorInterface {
    @Override
    public double corrige(List<String> gabarito, List<String> respostas) {
        int numeroDeQuestoes = gabarito.size();
        int numeroDeRespostas = respostas.size();

        double notaPorQuestao = 10.0 / numeroDeQuestoes;

        double nota = 0.0;
        for (int i = 0; i < numeroDeQuestoes && i < numeroDeRespostas; i++) {

            String respostaCerta = gabarito.get(i);
            String respostaAluno = respostas.get(i);

            if (respostaAluno.equals(respostaCerta)) {
                nota += notaPorQuestao;
            }
        }

        return nota;
    }
}
