package Testes;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

import ClassesPrincipais.Baralho;
import Excecoes.BaralhoVazioException;

public class TestExcecoes {

    private Baralho baralho;

    @Before// executado antes de cada teste
    public void setUp() {
    baralho = Baralho.getInstance();
    baralho.clearInstance(); // garante um estado limpo para cada teste
}

//verifica se a distribui??o de uma carta em um baralho vazio lan?a a exce?ao BaralhoVazioException
    @Test(expected = BaralhoVazioException.class)//indica q a exce??o esperada deve ser lan?ada
    public void testDistribuicaoCartaComBaralhoVazio() {
        
        while (!baralho.getCartas().isEmpty()) {
            baralho.distribuirCarta();
        }

        baralho.distribuirCarta();
    }

    // ele esvazia o baralho da  reset embaralha
    //ent?o usa  assertFalse para verificar se o baralho n esta vazio
@Test
public void testBaralhoNaoVazioAposEmbaralhar() {
    
    while (!baralho.getCartas().isEmpty()) {
        baralho.distribuirCarta();
    }

    baralho.reset();

    baralho.embaralhar();

    assertFalse(baralho.getCartas().isEmpty());
}
}