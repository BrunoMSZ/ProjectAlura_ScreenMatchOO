package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().
                setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create(); //PARA BUSCAR EM LETRA MAIUSCULA PARA CONSEGUIR BUSCAR O TITULO CORRETAMENTE (TRADUZ OS CAMPOS)
        Scanner leitura = new Scanner(System.in);
        while(!busca.equals("sair")){

            System.out.println("Digite um filme para busca: ");
            busca = leitura.nextLine();
            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ","+") + "&apikey=66418c3a";
            try{
                /*CLIENT*/
                HttpClient client = HttpClient.newHttpClient();

                /*REQUEST API*/
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                /*HTTP RESPONSE (RESPOSTA DA REQUEST)*/
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());


                /*PRINT DO CORPO DO REQUEST*/
                String json = response.body();
                System.out.println(json);


                //Titulo meuTitulo = gson.fromJson(json, Titulo.class);
                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);
                //Tentativa de fazer o meuTitulo com o formato especifico
                //try{
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo já convertido: ");
                System.out.println(meuTitulo);
                //Escrita do filme em um arquivo
                titulos.add(meuTitulo);
            }catch(NumberFormatException e){ //Ocorre um erro e ele captura um possivel erro
                System.out.println("Aconteceu um erro!: ");
                System.out.println(e.getMessage());
            }catch(IllegalArgumentException e){ //nome com palavras separadas
                System.out.println("Algum erro de argumento na busca, verifique o endereço!");
            }catch(ErroConversaoDeAnoException e){// Excecao PERSONALIZADA
                System.out.println(e.getMessage());
            }

            //Exceções: são prevísiveis e é possível ajustar-lá
            //IOException: que indica algum problema relacionado com leitura/escrita de dados.
        }
        System.out.println(titulos);
        FileWriter escrita = new FileWriter("filmes.json");
        //escrita em json
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println("Finalizou!");
    }
}
