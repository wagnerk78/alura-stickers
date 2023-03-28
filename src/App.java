import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
    String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
    URI endereco = URI.create(url);
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(endereco).GET().build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    String body = response.body();
    
    // Extração de dados
    var parser = new JsonParser();
    List<Map<String, String>> listaDeFilmes = parser.parse(body);
    
    // Exibir e manipular os dados
    for (Map<String, String> filme: listaDeFilmes) {
        String title = "\u001b[31m \u001b[1mNome do filme: \u001b[m";
        String image = "\u001b[33m \u001b[1mImagem: \u001b[m";
        String rating = "\u001b[32m \u001b[1mAvaliação: \u001b[m";
        System.out.println(title + filme.get("title"));
        System.out.println(image + filme.get("image"));
        System.out.println(rating + filme.get("imDbRating"));
        System.out.println("\n");
        
        
       

    }
        
    }
  



    }

