package Testes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import ClassesPrincipais.Baralho;
import ClassesPrincipais.Main;
import ClassesSuporte.HistoricoJogo;

public class TestMain {

@Test // simula a execução do loop interno do jogo
public void testLoopInterno() {
   
    String input = "2\nJogador1\nJogador2\nJogador3\ns\nn\n3\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Chama metodo iniciarJogo para testar a logica interna.
    Main.iniciarJogo(new Scanner(System.in), Baralho.getInstance(), new ArrayList<>(), new HistoricoJogo());

    
}

    
    @Test
    // simula a opçao de sair no menu principal do jogo
    public void testOpcaoSair() {
        String input = "3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.main(null);

        assertFalse(outContent.toString().contains("----- Resultado da Partida -----"));
    }

     @Test // verifica se o metodo obterNumeroDeJogadores retorna o valor esperado
    void testObterNumeroDeJogadores() {
        //simula a interaçao do usuario para obter o n de jogadores
        String input = "3\n";
        InputStream testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        Scanner scanner = new Scanner(System.in);
        int numJogadores = Main.obterNumeroDeJogadores(scanner);

        assertEquals(3, numJogadores);
    }

   





    

}



