public class Carta {
    //atributos 
    private ValorCartas valor;
    private Naipe naipe;

    //contrutor inicializa os atributos 
    public Carta(ValorCartas valor, Naipe naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    //obtem o valor 
    public ValorCartas getValor() {
        return valor;
    }

    //e o naipe da carta
    public Naipe getNaipe() {
        return naipe;
    }

    //  usado p/ representação em string da carta
    @Override
    public String toString() {
        return valor.toString() + naipe.toString();
    }
}
