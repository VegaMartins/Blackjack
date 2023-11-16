//Valores possiveis para a enumeração
public enum ValorCartas {
    AS("A", 1),
    DOIS("2", 2),
    TRES("3", 3),
    QUATRO("4", 4),
    CINCO("5", 5),
    SEIS("6", 6),
    SETE("7", 7),
    OITO("8", 8),
    NOVE("9", 9),
    DEZ("10", 10),
    VALETE("J", 10),
    DAMA("Q", 10),
    REI("K", 10);

    //atributos
    private String simbolo;
    private int valor;

    //Construtor q associa um símbolo e um valor 
    ValorCartas(String simbolo, int valor) {
        this.simbolo = simbolo;
        this.valor = valor;
    }

    //representação em string do valor da carta
    @Override
    public String toString() {
        return simbolo;
    }

    //indica o valor numerico da carta
    public int getValor() {
        return valor;
    }
}

