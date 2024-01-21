package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;


import java.sql.Array;
import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso Chefão",1970);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar",2023);
        outroFilme.avalia(6);
        var filmeDoPaulo = new Filme("DogVille",2003);
        filmeDoPaulo.avalia(10);
        Serie lost = new Serie("Lost",2000);

        /*CRIAR OBJETO: APENAS COM O VALOR (*NEW*) */

        List<Titulo> lista = new LinkedList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if(item instanceof Filme filme && filme.getClassificacao() > 2){ /*SE O ITEM é UM FILME, e se tiver classificacao maior que 2 PRINTA*/
                System.out.println("Classificacao: " + filme.getClassificacao());
            }
        }

        ArrayList<String>buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");

        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista); /*Collections.sort() -> ordena em ordem alfabetica*/
        System.out.println("Depois da ordenação: ");
        System.out.println(buscaPorArtista);
        /*Por meio de interfaces resolve o problema de ordenacao de objetos de uma classe especifica*/
        System.out.println("Lista de Titulos ordenados: ");
        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento)); /*(Comparator.comparing() ->COMPARADOR COM ALGUM CRITERIO, NESSE CASO POR ANO*/
        System.out.println("Lista de Ano de Lancamento ordenado: ");
        System.out.println(lista);
    }
}
