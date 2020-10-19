import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    partições:
        - gabarito invalido: ["A", "C", "F", "", "D", "E"]
        - gabarito valido: ["B", "C", "Z", "D", "J"]
        - resposta valida:
            - Digitos strings: ["D", "D", "D", "D", "D", "D", "D"]
            - Digitos vazios: ["D", "", "", "D", "", "D"]
            - Sem resposta: []
        - gabarito invalido baixo: []
 */

import static org.junit.jupiter.api.Assertions.*;

public class CorretorTest {

    private Corretor corretor = new Corretor();

    @Test
    public void testeUsuarioComGabaritoInvalidoComDigitoVazio() {
        List<String> gabarito = Arrays.asList("C", "D", "", "A", "C", "C", "B", "A", "A", "B");
        List<String> resposta = Arrays.asList("A", "B", "A", "B");
        Exception exception = assertThrows(CorretorException.class, () -> {
            corretor.corrige(gabarito, resposta);
        });

        String expectedMessage = "Nao sao permitidas alternativas em branco em gabaritos";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void testeUsuarioComGabaritoInvalidoBaixo() {
        List<String> gabarito = Collections.emptyList();
        List<String> resposta = Arrays.asList("A", "B", "A", "B");
        Exception exception = assertThrows(CorretorException.class, () -> {
            corretor.corrige(gabarito, resposta);
        });

        String expectedMessage = "O gabarito precisa ter ao menos uma alternativa registrada";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void testeUsuarioComGabaritoValido() {
        List<String> gabarito = Arrays.asList("B", "C", "Z", "D", "J");
        List<String> resposta = Arrays.asList("F", "C", "Z", "D", "A");
        double nota = corretor.corrige(gabarito, resposta);
        assertEquals(6.0, nota);
    }

    @Test
    public void testeUsuarioComRespostaValidaBaixa() {
        List<String> gabarito = Arrays.asList("B", "C", "Z", "D", "J", "A", "B", "C", "D", "E");
        List<String> resposta = Collections.emptyList();
        corretor.corrige(gabarito, resposta);
        double nota = corretor.corrige(gabarito, resposta);
        assertEquals(0.0, nota);
    }

    @Test
    public void testeUsuarioComRespostaValida() {
        List<String> gabarito = Arrays.asList("B", "C", "Z", "D", "J", "A", "B", "C", "D", "E");
        List<String> resposta = Arrays.asList("D", "D", "D", "D", "D", "D", "D", "D", "", "", "D", "", "D");
        double nota = corretor.corrige(gabarito, resposta);
        assertEquals(1.0, nota);
    }
}
