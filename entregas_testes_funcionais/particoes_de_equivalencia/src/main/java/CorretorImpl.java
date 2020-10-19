import java.util.List;

public class CorretorImpl implements Corretor {
    @Override
    public double corrige(List<String> gabarito, List<String> respostas) {
        if (gabarito.size() == 0) {
            throw new CorretorExceptionImpl("O gabarito precisa ter ao menos uma alternativa registrada");
        }

        double nota = 0;
        double valorPorNota = 10.0 / gabarito.size();

        for (int i = 0; i < gabarito.size(); i++) {
            String alternative = gabarito.get(i);
            if (alternative.isEmpty()) {
                throw new CorretorExceptionImpl("Nao sao permitidas alternativas em branco em gabaritos");
            }
            if (i < respostas.size()) {
                String answer = respostas.get(i);
                if (answer.equals(alternative)) {
                    nota += valorPorNota;
                }
            }
        }

        return nota;
    }
}
