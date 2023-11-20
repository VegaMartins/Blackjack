package Testes;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ClassesPrincipais.Jogador;
import ClassesSuporte.Carta;
import ClassesSuporte.Naipe;
import ClassesSuporte.ValorCartas;

public class TestResultado {
    @Test //verifica se a pontua??o de um jogador estoura ao adicionar cartas (especifico)
    public void testPontuacaoComEstouro() {
        Jogador jogador = new Jogador("Teste de  Estouro");
    
        jogador.adicionarCarta(new Carta(ValorCartas.DEZ, Naipe.COPAS));
        jogador.adicionarCarta(new Carta(ValorCartas.VALETE, Naipe.ESPADAS));
        jogador.adicionarCarta(new Carta(ValorCartas.TRES, Naipe.PAUS));
    
       
          assertTrue(jogador.Estouro());
    }
   
   
    @Test//verifica o resultado da partida entre dois jogadores (especifico)
    public void testResultadoPartida() {
        Jogador jogador1 = new Jogador("Jogador1");
        Jogador jogador2 = new Jogador("Jogador2");

       
        jogador1.adicionarCarta(new Carta(ValorCartas.DEZ, Naipe.COPAS));
        jogador1.adicionarCarta(new Carta(ValorCartas.DEZ, Naipe.PAUS));

       
        jogador2.adicionarCarta(new Carta(ValorCartas.NOVE, Naipe.COPAS));
        jogador2.adicionarCarta(new Carta(ValorCartas.NOVE, Naipe.PAUS));

        
        assertEquals(20, jogador1.getPontuacaoTotal());
        assertEquals(18, jogador2.getPontuacaoTotal());


        String resultado = determinarResultado(jogador1, jogador2);
        
        
        assertEquals("Vitoria do Jogador1", resultado);
    }

    // metodo q determina o resultado da partida com base nas pontua??es dos jogadores
    private String determinarResultado(Jogador jogador1, Jogador jogador2) {
        int pontuacaoJogador1 = jogador1.getPontuacaoTotal();
        int pontuacaoJogador2 = jogador2.getPontuacaoTotal();

        if (pontuacaoJogador1 > 21 && pontuacaoJogador2 > 21) {
            return "Empate"; 
        } else if (pontuacaoJogador1 > 21) {
            return "Vitoria do Jogador2";  
        } else if (pontuacaoJogador2 > 21) {
            return "Vitoria do Jogador1"; 
        } else if (pontuacaoJogador1 > pontuacaoJogador2) {
            return "Vitoria do Jogador1"; 
        } else if (pontuacaoJogador2 > pontuacaoJogador1) {
            return "Vitoria do Jogador2";
        } else {
            return "Empate"; 
        }

    }


    
}
