package Testes;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ClassesPrincipais.Jogador;
import ClassesSuporte.Carta;
import ClassesSuporte.Naipe;
import ClassesSuporte.ValorCartas;


class TestJogador { // verifica se alguns metodos da classe jogador estão como esperado 

    @Test //verifica se a carta da mão do jogador esta correta
    void testAdicionarCarta() {
        Jogador jogador = new Jogador("Test");
        Carta carta = new Carta(ValorCartas.AS, Naipe.COPAS);

        jogador.adicionarCarta(carta);

        assertEquals(1, jogador.getMao().size());
        assertTrue(jogador.getMao().contains(carta));
    }

    @Test //verifica o metodo limpar a mao 
    void testLimparMao() {
        Jogador jogador = new Jogador("Test");
        Carta carta = new Carta(ValorCartas.AS, Naipe.COPAS);

        jogador.adicionarCarta(carta);
        jogador.limparMao();

        assertTrue(jogador.getMao().isEmpty());
    }

    @Test //verifica se retorna o valor  da mao do jogador corretamente
    void testGetValorMao() {
        Jogador jogador = new Jogador("Test");
        Carta carta1 = new Carta(ValorCartas.AS, Naipe.COPAS);
        Carta carta2 = new Carta(ValorCartas.DAMA, Naipe.ESPADAS);

        jogador.adicionarCarta(carta1);
        jogador.adicionarCarta(carta2);

        
        assertEquals(11, jogador.getValorMao());
    }

    @Test //verifica se retorna a pontuacao do jogador de forma correta (especifico) 
    void testGetPontuacaoTotal() {
        Jogador jogador = new Jogador("Test");
        Carta carta1 = new Carta(ValorCartas.AS, Naipe.COPAS);
        Carta carta2 = new Carta(ValorCartas.DAMA, Naipe.ESPADAS);

        jogador.adicionarCarta(carta1);
        jogador.adicionarCarta(carta2);

        
        assertEquals(11, jogador.getPontuacaoTotal());
    }


    
}

