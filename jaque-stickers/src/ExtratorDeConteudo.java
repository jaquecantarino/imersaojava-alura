import java.util.List;

public interface ExtratorDeConteudo {

	//para oo, serve para retornar a lista no c�digo que vai busca-la
	
	 List<Conteudo> extraiConteudos(String json);
}
