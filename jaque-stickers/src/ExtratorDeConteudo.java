import java.util.List;

public interface ExtratorDeConteudo {

	//para oo, serve para retornar a lista no código que vai busca-la
	
	 List<Conteudo> extraiConteudos(String json);
}
