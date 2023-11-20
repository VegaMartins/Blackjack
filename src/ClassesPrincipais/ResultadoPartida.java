package ClassesPrincipais;

public class ResultadoPartida {
    //atributos 
    private String nomeJogador;
    private int pontuacao;
    private String resultado; 

    //construtor  inicializa os atributos da partida
    public ResultadoPartida(String nomeJogador, int pontuacao, String resultado) {
        this.nomeJogador = nomeJogador;
        this.pontuacao = pontuacao;
        this.resultado = resultado;
    }

   // p/ indicar o nome do jogador, a pontuação e o resultado da partida

    /**
     * @return String return the nomeJogador
     */
    public String getNomeJogador() {
        return nomeJogador;
    }

    /**
     * @param nomeJogador the nomeJogador to set
     */
    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    /**
     * @return int return the pontuacao
     */
    public int getPontuacao() {
        return pontuacao;
    }

    /**
     * @param pontuacao the pontuacao to set
     */
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    /**
     * @return String return the resultado
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

}