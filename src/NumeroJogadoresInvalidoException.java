// exce�ao espec�fica lan�ada quando o n de jogadores �  invalido
class NumeroJogadoresInvalidoException extends RuntimeException {
    public NumeroJogadoresInvalidoException(String message) {
        super(message);
    }
}
