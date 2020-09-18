package corretor.model;

import java.util.List;

public class Corretor implements CorretorInterface {
    @Override
    public double corrige(List<String> gabarito, List<String> respostas) {
        // Coletando numero de questões no gabarito e nas respostas
        int numeroDeQuestoes = gabarito.size();
        int numeroDeRespostas = respostas.size();

        // Calculando quanto de nota vale cada questão
        double notaPorQuestao = 10.0 / numeroDeQuestoes;

        double nota = 0.0;
        // Correção será feita enquanto tiver questões a serem revisadas no gabarito e enquanto houver respostas
        for (int i = 0; i < numeroDeQuestoes && i < numeroDeRespostas; i++) {

            String respostaCerta = gabarito.get(i);
            String respostaAluno = respostas.get(i);

            // Caso a resposta do aluno seja igual a resposta certa, ele soma o valor da questao na nota
            if (respostaAluno.equals(respostaCerta)) {
                nota += notaPorQuestao;
            }
        }

        return nota;
    }
}
