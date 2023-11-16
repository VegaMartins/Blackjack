// exceçao específica lançada quando o n de jogadores é  invalido
class NumeroJogadoresInvalidoException extends RuntimeException {
    public NumeroJogadoresInvalidoException(String message) {
        super(message);
    }
}
