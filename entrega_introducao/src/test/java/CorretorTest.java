import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CorretorTest {

    private CorretorInterface corretor;

    @Test
    public void deveCorrigirProvaSemTodasAsQuestoesRespondidas() {
        List<String> gabarito = Arrays.asList("C", "D", "A", "E", "C", "C", "B", "A", "A", "B");
        List<String> resposta = Arrays.asList("A", "B", "A", "B");
        assertEquals(1.0, corretor.corrige(gabarito, resposta));
    }

    @Test
    public void deveCorrigirProvaComVariasRespostas() {
        List<String> gabarito = Arrays.asList("E", "E", "E", "A", "B", "C", "B", "A", "D", "B");
        List<String> resposta = Arrays.asList("E", "E", "B", "C", "B", "C", "B", "A", "A", "C");
        assertEquals(6.0, corretor.corrige(gabarito, resposta));
    }
}
