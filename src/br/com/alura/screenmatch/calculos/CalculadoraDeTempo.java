package br.com.alura.screenmatch.calculos;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return this.tempoTotal;
    }

    /*public void inclui(Filme f){
        this.tempoTotal += f.getDuracaoEmMinutos();
    }
    public void inclui(Serie s){
        this.tempoTotal += s.getDuracaoEmMinutos();
    }*/

    /*POLIMORFISMO: PASSSAR APENAS PELA SUPERCLASSE PARA CAPTURAR FILMES E SERIES DURACAO DE MINUTOS*/
    public void inclui(Titulo titulo){
        System.out.println("Adicionando duracao em minutos= " + titulo);
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
