package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodios;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.lang.reflect.Array;
import java.util.ArrayList;
/*IMPORT: é a forma que uma classe se referencia a outra quando estão em pacotes diferentes*/


public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso Chefão",1970); /*Criando um objeto,em que são atribuido atributos do objeto
        (caracteristicas da classe br.com.alura.screenmatch.modelos.Filme)*/
        //meuFilme.setNome("O poderoso Chefão");
        meuFilme.setDuracaoEmMinutos(180);

        System.out.println("Duracao do filme: " + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println("Total de avaliações: " + meuFilme.getTotalAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        Serie lost = new Serie("Lost",2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duracao para maratonar Lost: " + lost.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("Avatar",2023); /*Criando um objeto,em que são atribuido atributos do objeto
        (caracteristicas da classe br.com.alura.screenmatch.modelos.Filme)*/
        //outroFilme.setNome("Avatar");
        outroFilme.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodios episodios = new Episodios();
        episodios.setNumero(1);
        episodios.setSerie(lost);
        episodios.setTotalVisualizacoes(300);
        filtro.filtra(episodios);

        var filmeDoPaulo = new Filme("DogVille",2003);
        //filmeDoPaulo.setNome("DogVille");
        filmeDoPaulo.setDuracaoEmMinutos(200);
        filmeDoPaulo.avalia(10);

        /*LISTA*/
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();

        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);

        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());/*lista.get(primeiro filme da lista).getNome*/
        System.out.println("toString do filme: " + listaDeFilmes.get(0).toString());/*lista.get(primeiro filme da lista).getNome*/

        System.out.println(listaDeFilmes);


    }
}