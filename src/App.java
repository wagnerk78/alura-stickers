import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
    
    //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2023-03-27&end_date=2023-03-28";
    //ExtratorDeConteudos extrator = new ExtratorDeConteudoDaNasa();

    //String url = "https://mocki.io/v1/dd0a4781-599c-442b-a356-98d4a1d0e42c";
    //ExtratorDeConteudos extrator = new ExtratorDeConteudodoIMDB();
 
    String url = "http://localhost:8080/linguagens";
    ExtratorDeConteudos extrator = new ExtratorDeConteudodoIMDB();

    var http = new ClienteHttp();
    String json = http.buscaDados(url);
    
    // Extração de dados
    
    
    // Exibir e manipular os dados
    
    List<Conteudo> conteudos = extrator.extraiConteudos(json);

    var geradora = new GeneratorX();

    for (int i=0; i< 2; i++) {

        Conteudo conteudo = conteudos.get(i);
        
        InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();
        String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";
        
        
        geradora.criar(inputStream, nomeArquivo);

        System.out.println(conteudo.getTitulo());
        System.out.println();
        
        
       

    }
        
    
  


    }
}

