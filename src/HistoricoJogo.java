import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class HistoricoJogo {
    //atributo privado que armazena  lista de objetos
    private List<ResultadoPartida> resultados;

    //inicializa a lista 
    public HistoricoJogo() {
        this.resultados = new ArrayList<>();
    }
    
    //adicionar um novo resultado a lista
    public void adicionarResultado(String nomeJogador, int pontuacao, String resultado) {
        resultados.add(new ResultadoPartida(nomeJogador, pontuacao, resultado));
    }

    //exibir o historico de resultados na saida 
    public void exibirHistorico() {
        if (resultados.isEmpty()) {
            System.out.println("Nenhum resultado no historico.");
        } else {
            System.out.println("----- Historico de Partidas -----");
            for (ResultadoPartida resultado : resultados) {
                System.out.println(String.format("%s - Pontuação: %d - Resultado: %s",
                        resultado.getNomeJogador(), resultado.getPontuacao(), resultado.getResultado()));
            }
        }
    }
    

    //indica  a lista de resultados
    public List<ResultadoPartida> getResultados() {
        return resultados;
    }

    //salva o historico em um arquivo
    public void salvarHistorico(String nomeArquivo) {
        //try-with-resources q garante que o recurso PrintWriter seja fechado 
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            for (ResultadoPartida resultado : resultados) {
                writer.println(String.format("%s - Pontuação: %d - Resultado: %s",
                        resultado.getNomeJogador(), resultado.getPontuacao(), resultado.getResultado()));
            }
            System.out.println("Histórico salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o histórico: " + e.getMessage());
        }
    }
    
    
    
     // exibir o historico salvo
     public void exibirHistoricoSalvo(String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            System.out.println("----- Historico Salvo -----");
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o histórico salvo: " + e.getMessage());
        }
    }
}
