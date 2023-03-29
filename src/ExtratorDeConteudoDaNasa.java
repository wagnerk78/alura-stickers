import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudos {
    
public List<Conteudo> extraiConteudos(String json){
    
    var parser = new JsonParser();
    List<Map<String, String>> listadeAtributos = parser.parse(json);

    List<Conteudo> conteudos = new ArrayList<>();

    for (Map<String, String> atributos : listadeAtributos) {

        String titulo = atributos.get("title");
        String urlImage = atributos.get("url");
        var conteudo = new Conteudo(titulo, urlImage);

        conteudos.add(conteudo);


    }
    return conteudos;

}


}
