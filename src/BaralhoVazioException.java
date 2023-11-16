//excecao lançada quando o baralho esta vazio
public class BaralhoVazioException extends RuntimeException {
    public BaralhoVazioException(String message) {
        super(message);
    }
}
