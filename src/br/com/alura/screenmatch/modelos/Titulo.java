package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErroConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{/*PARA IMPLEMENTAR A ORDENACAO DE STRINGS*/
    /*Classe: especifica o conteúdo de um objeto, nesse caso, verificar o quê
        um filme tem*/
    private String nome; /*Todo film tem um nome*/
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        if(meuTituloOmdb.year().length() > 4){
            //Nova exceção personalizada
            throw new ErroConversaoDeAnoException("Não conseguiu converter o ano, porque tem mais de 04 caracteres!");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year()); // CONVERTER STRING PARA INT
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0,2)); //Substring(define onde comeca e termina o campo capturado
    }

    /*Somente para consultar valor e não para alterar este dado*/
    public int getTotalAvaliacoes(){
        return totalAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    /*SETTERS*/
    public void setNome(String nome) {
        this.nome = nome; /*this = nome desse objeto*/
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }


/*MODIFICADORES:
                PRIVATE: privar algum metodo
                PUBLIC: Deixar público
                Default (Package-private) : O modificador de acesso default é aquele que não especifica nenhum modificador de acesso. Quando nenhum modificador de acesso é especificado, a classe, atributo ou método pode ser acessado apenas pelas classes que estão no mesmo pacote

     */

    /* GET: Pega valor
       SET: atribui valor*/
    /*Metodo: "todo filme consegue fazer isso aqui, uma funcao
     *
     *       Encapsulamento(esconder): método para não deixar a facil alteração do código, privar certas funcoes e variaveis
     * */
    /*shift + F6 = altera todos os valores com o mesmo nome */
    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lancamento: " + anoDeLancamento);
        System.out.println("Duracao Em Minutos: " + duracaoEmMinutos);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalAvaliacoes ++;
    }

    @Override
    public String toString() {
        return "(nome: " + nome + '\'' + ", anoDeLancamento: " + anoDeLancamento + " , duração: " + duracaoEmMinutos + ") ";
    }

    public double pegaMedia(){
        return somaDasAvaliacoes/totalAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome()); /*COMPARA get.nome() com o outroTitulo.getNome()*/
    }
}
