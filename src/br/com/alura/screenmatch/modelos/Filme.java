package br.com.alura.screenmatch.modelos;/*pertence a este package*/

import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel { /*HERANCA -> TODO FILME É UM TITULO*/
    private String diretor;

   /*CONSTRUTOR*/
   public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    /*Getter*/
    public String getDiretor() {
        return diretor;
    }

    /*SETTER*/
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int)pegaMedia() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ") ";
    }
}
