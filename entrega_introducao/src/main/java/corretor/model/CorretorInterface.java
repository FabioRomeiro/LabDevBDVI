package corretor.model;

import java.util.List;

public interface CorretorInterface {
    public double corrige(List<String> gabarito, List<String> respostas);
}
