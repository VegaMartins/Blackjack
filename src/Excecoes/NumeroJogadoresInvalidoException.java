package Excecoes;

// exce�ao espec�fica lan�ada quando o n de jogadores �  invalido
public class NumeroJogadoresInvalidoException extends RuntimeException {
    public NumeroJogadoresInvalidoException(String message) {
        super(message);
    }
}
