package br.com.alura.screenmatch.excecao;

public class ErroConversaoDeAnoException extends RuntimeException {//extends Throwable obriga a fazer try catch
    private String mensagem;
    public ErroConversaoDeAnoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
