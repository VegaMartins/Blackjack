package Testes; 

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ClassesPrincipais.Baralho;
import Excecoes.BaralhoVazioException;
import ClassesSuporte.Carta;

public class TestBaralho {

    // Ele cria uma nova inst?ncia da classe p/ garantir independencia entre os testes
    private Baralho baralho;
    @Before
    public void setUp() {
        baralho = new Baralho();  
    }

    //saber se o baralho e criado com 52 cartas
    @Test
    public void testCriacaoBaralho() {
    Baralho baralho = new Baralho();
    assertEquals(52, baralho.getCartas().size());//comparar o tamanho do baralho com o valor esperado
}

 @Test
public void testDistribuicaoCarta() {
    // Garanta que uma carta seja distribuída corretamente
    assertEquals(52, baralho.getCartas().size()); 

    Carta carta = baralho.distribuirCarta();

    // saber se  a carta distribuida esta no baralho original
    assertFalse(baralho.getCartas().contains(carta));
    assertEquals(51, baralho.getCartas().size()); 
}

  

 @Test// Cria dois baralhos, um original e outro embaralhado, e verifica se as listas de cartas sao diferentes
 public void testEmbaralhamento() {
    Baralho baralhoOriginal = new Baralho();
    List<Carta> cartasOriginal = new ArrayList<>(baralhoOriginal.getCartas());

    Baralho baralhoEmbaralhado = new Baralho();
    baralhoEmbaralhado.embaralhar();

    assertFalse(cartasOriginal.equals(baralhoEmbaralhado.getCartas()));
}


   // saber se o metodo distribuirCarta lan?a a exce??o BaralhoVazioException quando o baralho est? vazio
   @Test(expected = BaralhoVazioException.class)
   public void testBaralhoVazio() {
    while (!baralho.getCartas().isEmpty()) {
        baralho.distribuirCarta();
    }


    baralho.distribuirCarta();
}


    

}
