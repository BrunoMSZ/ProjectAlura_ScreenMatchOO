package br.com.alura.screenmatch.modelos;

public class Serie extends Titulo { /*No Java, a herança é realizada através da palavra-chave extends. A classe que herda é chamada de subclasse, e a classe que é herdada é chamada de superclasse.*/
    private int temporadas;
    private boolean ativa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;

    /*CRIA CONSTRUTOR CHAMANDO CLASSE MAE -> CONSTRUTOR NAO POSSUI HERANCA*/
    public Serie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    /*GETTERS*/

    public int getTemporadas() {
        return temporadas;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    /*SETTERS*/

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    /*SOBRESCRITA DO METODO (SERIE É DIFERENTE DE FILME)
    * Superclasse/mãe = herança maior*/


    /*No Java, as anotações são definidas com o uso do símbolo "@" seguido do nome da anotação. Por exemplo, a anotação @Deprecated é usada para indicar que um método ou classe está obsoleto e não deve ser mais utilizado. Outra anotação muito útil é a @Override, conforme foi demonstrado no último vídeo, que indica que um método está
    sobrescrevendo o mesmo método definido na sua classe mãe.
     */
    @Override
    public int getDuracaoEmMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;
    }

    @Override
    public String toString() {
        return "Série: " + this.getNome() + " (" + this.getAnoDeLancamento() + ") ";
    }
}


