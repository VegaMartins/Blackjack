package ClassesPrincipais;
import java.util.ArrayList;
import java.util.List;

import ClassesSuporte.Carta;
import ClassesSuporte.ValorCartas;

public class Jogador {
    //atributos 
    private String nome; //nome do jogador.
    private List<Carta> mao; //lista p/ as cartas na mão do jogador
    private int pontuacaoTotal; 

    public Jogador(String nome) {  // parametro nome do jogador 
        this.nome = nome; // inicia os atributos
        this.mao = new ArrayList<>();
        this.pontuacaoTotal = 0;
    }

    //indica o nome do jogador.
    public String getNome() {
        return nome;
    }

    //indica as cartas na mao do jogador
    public List<Carta> getMao() {
        return mao;
    }

    //limpa as cartas 
    public void limparMao() {
        mao.clear();
    }

    //adiciona carta a mao e atualiza a pontuação 
    public void adicionarCarta(Carta carta) {
        mao.add(carta);
        pontuacaoTotal += carta.getValor().getValor();
    }

    //valor atual da mão do jogador
    public int getValorMao() {
        int valor = 0;
        int numAs = 0;
        for (Carta carta : mao) {
            if (carta.getValor() == ValorCartas.AS) {
                numAs++;
            }
            valor += carta.getValor().getValor();
        }
        while (valor > 21 && numAs > 0) {
            valor -= 10;
            numAs--;
        }
        return valor;
    }

    //indicar a pontuação total 
    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    // retorna verdadeiro se o valor atual da mão do jogador ultrapassar 21
    public boolean Estouro() {
        return getValorMao() > 21;
    }
}
