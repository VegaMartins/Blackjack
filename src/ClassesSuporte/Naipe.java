package ClassesSuporte;

//Quatro valores possiveis que representam os naipes de um baralho
public enum Naipe {
    COPAS(" de Copas"),
    OUROS(" de Ouros"),
    PAUS(" de Paus"),
    ESPADAS(" de Espadas");

    // atributo privado que armazena o simbolo  de cada naipe
    private String simbolo;

    //Construtor que associa um simbolo a cada valor 
    Naipe(String simbolo) {
        this.simbolo = simbolo;
    }

    //fornece uma representação em string do naipe
    @Override
    public String toString() {
        return simbolo;
    }
}

