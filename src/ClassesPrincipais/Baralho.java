package ClassesPrincipais;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Excecoes.BaralhoVazioException;
import ClassesSuporte.Carta;
import ClassesSuporte.Naipe;
import ClassesSuporte.ValorCartas;

public class Baralho {
    //garante que haja apenas uma instância da classe Baralho e uma lista de cartas
    private static Baralho instance;
    private List<Carta> cartas;

    //Construtor que chama o metodo abaixo para inicializar o baralho
    public Baralho() {
        reset();
    }

    // retorna a instancia do baralho e seja criada apenas uma instancia
    public static Baralho getInstance() { 
        if (instance == null) {
            instance = new Baralho();
        }
        return instance;
    }

  

    //embaralha as cartas no baralho
    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    //distribui uma carta e lança uma exceção se o baralho estiver vazio
    public Carta distribuirCarta() {
        if (cartas.isEmpty()) {
            throw new BaralhoVazioException("Baralho vazio. Não há cartas disponíveis.");
        }
        return cartas.remove(0);
    }

    //indica a lista de cartas no baralho
    public List<Carta> getCartas() {
        return cartas;
    }

    //redefinir o baralho e com todas as cartas possíveis
    public void reset() {
        cartas = new ArrayList<>();
        for (Naipe naipe : Naipe.values()) {
            for (ValorCartas valor : ValorCartas.values()) {
                cartas.add(new Carta(valor, naipe));
            }
        }
    }

    //pode ser usado para limpar a instância do baralho
    public void clearInstance() {
        instance = null;
    }

}

