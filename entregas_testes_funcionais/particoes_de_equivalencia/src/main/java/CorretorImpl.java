import java.util.List;

public class CorretorImpl implements Corretor {
    @Override
    public double corrige(List<String> template, List<String> answers) {

        int numberOfQuestions = template.size();
        int numberOfAnswers = answers.size();

        if (numberOfQuestions == 0) {
            throw new CorretorExceptionImpl("O gabarito precisa ter ao menos uma alternativa registrada");
        }

        double grade = 0;
        double valueByQuestion = 10.0 / numberOfQuestions;

        for (int index = 0; index < numberOfQuestions && index < numberOfAnswers; index++) {
            String rightAnswer = template.get(index);
            if (rightAnswer.isEmpty()) {
                throw new CorretorExceptionImpl("Nao sao permitidas alternativas em branco em gabaritos");
            }
            String answer = answers.get(index);
            if (answer.equals(rightAnswer)) {
                grade += valueByQuestion;
            }
        }

        return grade;
    }
}
