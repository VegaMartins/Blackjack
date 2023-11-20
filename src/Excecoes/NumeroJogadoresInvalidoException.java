package Excecoes;

// exceçao específica lançada quando o n de jogadores é  invalido
public class NumeroJogadoresInvalidoException extends RuntimeException {
    public NumeroJogadoresInvalidoException(String message) {
        super(message);
    }
}
