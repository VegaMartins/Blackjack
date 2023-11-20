package ClassesPrincipais;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Excecoes.NumeroJogadoresInvalidoException;
import ClassesSuporte.Carta;
import ClassesSuporte.HistoricoJogo;



public class Main {
    //listas estáticas para armazenar jogadores e resultados
    protected static List<Jogador> jogadores = new ArrayList<>(); 
    protected static List<ResultadoPartida> resultados = new ArrayList<>();
    public static void main(String[] args) {
        //Criando instâncias 
        Scanner scanner = new Scanner(System.in);
        Baralho baralho = Baralho.getInstance(); 
        HistoricoJogo historico = new HistoricoJogo();
        

     ///mensagem do inicio do jogo
        System.out.println("\n--------------------------");
        System.out.println("Bem-vindo ao Blackjack 21!");
        System.out.println("--------------------------");
        

       boolean continuarJogando = true;

       while (continuarJogando) {

        //Chama o metodo para mostrar as opções.
        exibirMenu();
        if (scanner.hasNextInt()) {
            int escolha = scanner.nextInt();//Verifica se a entrada do usuário é um n inteiro.
            scanner.nextLine(); 

        switch (escolha) {//Um bloco p/ apresentar as diferentes opções do menu 
            case 1:
                iniciarJogo(scanner, baralho, jogadores, historico);
                break;
            case 2:
                historico.exibirHistoricoSalvo("historico.txt");
                break;
            case 3:
                continuarJogando = false;
                break;
            default:
                System.out.println("Opcao invalida. Tente novamente.");
                break;
        }
    }

    System.out.println("Obrigado por jogar!\n");//msg termino loop principal
}
}
// usado para exibir o menu do jogo
private static void exibirMenu() {
    System.out.println("1. Iniciar Jogo");
    System.out.println("2. Ver Historico");
    System.out.println("3. Sair");
    System.out.print("Escolha uma opcao: ");
    
}

//prepara e inicia uma nova rodada 
private static void configurarEIniciarRodada(Baralho baralho, List<Jogador> jogadores) {
    baralho.reset();
    baralho.embaralhar();

    for (Jogador jogador : jogadores) {
        jogador.limparMao();
        jogador.adicionarCarta(baralho.distribuirCarta());
        jogador.adicionarCarta(baralho.distribuirCarta());
    }
}


// usado p/ iniciar o jogo adicionar jogadores e gerenciar as rodadas
public static void iniciarJogo(Scanner scanner, Baralho baralho, List<Jogador> jogadores, HistoricoJogo historico) {
    int numJogadores = obterNumeroDeJogadores(scanner);

    jogadores.clear(); 

    for (int i = 0; i < numJogadores; i++) {
        System.out.print("Nome do jogador " + (i + 1) + ": ");
        String nomeJogador = scanner.nextLine();
        adicionarJogador(new Jogador(nomeJogador));
    }

    boolean continuarJogando = true;

    while (continuarJogando) {
    configurarEIniciarRodada(baralho, jogadores);

    for (Jogador jogador : jogadores) {
        boolean continuarComprando = true;

        while (continuarComprando) {
            System.out.println(jogador.getNome() + ", na sua mao: " + jogador.getMao() +
                    ", total: " + jogador.getValorMao());

            if (jogador.getValorMao() == 21) {
                System.out.println("Blackjack!");
                continuarComprando = false;
            } else {
                System.out.print("Deseja mais uma carta? (s/n): ");
                String escolha = scanner.nextLine();

                if (escolha.equalsIgnoreCase("s")) {
                    Carta cartaDistribuida = baralho.distribuirCarta();
                    jogador.adicionarCarta(cartaDistribuida);

                    System.out.println("Carta recebida: " + cartaDistribuida);

                    if (jogador.Estouro()) {
                        System.out.println( "Estourou! Voce ultrapassou 21. Sua pontuacao: " +
                                jogador.getValorMao() );
                        continuarComprando = false;
                    }
                } else {
                    continuarComprando = false;
                }
            }
        }
    }


        String resultado = determinarResultado(jogadores);
        System.out.println("\n----- Resultado da Partida -----");

        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getNome() + " - Pontuacao: " + jogador.getValorMao());
        }

        int pontuacaoMaxima = 0;
        int numVencedores = 0;
        List<String> vencedores = new ArrayList<>();

        for (Jogador jogador : jogadores) {
            int pontuacao = jogador.getValorMao();

            if (pontuacao <= 21) {
                if (pontuacao > pontuacaoMaxima) {
                    pontuacaoMaxima = pontuacao;
                    numVencedores = 1;
                    vencedores.clear();
                    vencedores.add(jogador.getNome());
                } else if (pontuacao == pontuacaoMaxima) {
                    numVencedores++;
                    vencedores.add(jogador.getNome());
                }
            }
        }

        if (numVencedores > 0) {
            for (String vencedor : vencedores) {
                System.out.println("Vencedor: " + vencedor);
                historico.adicionarResultado(vencedor, pontuacaoMaxima, resultado);
            }
        } else {
            System.out.println("Jogadores empataram.");

            for (Jogador jogador : jogadores) {
                historico.adicionarResultado(jogador.getNome(), jogador.getValorMao(), resultado);
            }
        }

        System.out.print("\nDeseja continuar jogando? (s/n): ");
        String jogarNovamente = scanner.nextLine();
        continuarJogando = jogarNovamente.equalsIgnoreCase("s");
    }

    System.out.println("\n----- Resultado Final do Jogo -----");
    for (Jogador jogador : jogadores) {
        System.out.println(jogador.getNome() + " - Pontuacao Total: " + jogador.getPontuacaoTotal());
    }

  
    historico.salvarHistorico("historico.txt");
}

    //adiciona jogadores a lista 
    private static void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    // usado p/ resultado da partida e retorna uma mensagem
    private static String determinarResultado(List<Jogador> jogadores) {
        int pontuacaoMaxima = 0;
        List<String> vencedores = new ArrayList<>();
    
        for (Jogador jogador : jogadores) {
            int pontuacao = jogador.getValorMao();
    
            if (pontuacao <= 21) {
                if (pontuacao > pontuacaoMaxima) {
                    pontuacaoMaxima = pontuacao;
                    vencedores.clear();
                    vencedores.add(jogador.getNome());
                } else if (pontuacao == pontuacaoMaxima) {
                    vencedores.add(jogador.getNome());
                }
            }
        }
    
        StringBuilder resultado = new StringBuilder();
   
    resultado.append("-")
            .append(vencedores.size() == 1 ? "Vitória do " + vencedores.get(0) :
                    (vencedores.size() > 1 ? "Empate" : "Houve empate"));

    for (Jogador jogador : jogadores) {
        resultados.add(new ResultadoPartida(jogador.getNome(), jogador.getValorMao(), resultado.toString()));
    }

    
        return resultado.toString();
    }
    
     //  valida e obtem o n de jogadores.   
    public static int obterNumeroDeJogadores(Scanner scanner) {
        int numJogadores = 0;

        do {
            try {
                System.out.print("\nIndique a quantidade de jogadores: ");
                numJogadores = Integer.parseInt(scanner.nextLine());

                if (numJogadores < 2) {
                    throw new NumeroJogadoresInvalidoException("Numero de jogadores invalido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Numero invalido. Tente novamente.");
            } catch (NumeroJogadoresInvalidoException e) {
                System.out.println(e.getMessage());
            }
        } while (numJogadores < 2);

        return numJogadores;
    }
}
