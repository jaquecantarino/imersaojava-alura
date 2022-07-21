import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception {
		//ALGORITMO:
		// fazer uma conex�o http.
		// criar uma busca do top 250 filmes do imdb
		// separar/extrair somentes as informa��es que vamos precisar usar - os dados s�o: t�tulo, poster e classifica��o.
		// exibir e manipular as informa��es do jeito que quisermos.
		
		//Criar uma variavel com a url que vamos consumir
		String url = "https://alura-filmes.herokuapp.com/conteudos";
		
		//vamos criar uma URI para usa-la no request
		URI endereco = URI.create(url);
		
		//Usando o pacote java.net vamos fazer o consumo da API pela conex�o html.
		/* Esse httpcliente existe a partir do Java 11. Podemos usar o var nessas vers�es mais recentes do java */
		var client = HttpClient.newHttpClient(); /* cria um novo client no http */
		
		//vamos criar um request para fazer um builder, vamos dar um get para criar um retorno.
		var request = HttpRequest.newBuilder(endereco).GET().build(); /* cria um novo request */
		
		//Vamos enviar o request
		//aqui poderiamos colocar var no lugar de HttpResponse, mas para melhor entendimento o ideal � deixar o tipo exato da var
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());/* cria um response */
		//aqui pegamos do response o body, que � aquele monte de texto que a API nos retorna.
		String body = response.body();
		
		//Vamos imprimir o body do response.
		System.out.println(body);
		
		//agora vamos transformar o body do get em uma lista de elementos.
		//vamos criar o parser, que sabe pegar o string de retorno e transformar em uma lista de elementos.
		var parser = new JsonParser(); /* para extrair os dados, criado outro arquivo com regras do regex */
		//aqui vamos usar as informa��es que separamos: t�tulo, poster e classifica��o
		//nossa retorno vai ser uma lista
		List<Map<String, String>> listaDeFilmes =  parser.parse(body);
		
		/*adicional que escolhi manter: quantidade de resultados (deve ser 250) */ System.out.println("TOP "+listaDeFilmes.size()+" Filmes\n");
		
		//quis criar um valor x para mostrar a posi��o do filme sem que precise contar.
		//criei uma variavel para contar
		int contador=1;
		
		// traz o gerador de stickers
		var gerador = new GeradorStickers();
		//para exibir as informa��es manipuladas, vamos criar uma lista filtrando as infos que queremos.
		for (Map<String, String> filme : listaDeFilmes) {
			
			/* adicionando a parte de criar stickers */
			String urlImagem = filme.get("image"); /* pega o url da imagem e armazena na String */
			String titulo = filme.get("title"); /* pega o titulo para salvar a figurinha */ /* figurinha salva na pasta saida da ra�z*/
			
			
			/* cria o Input Stream para ser usado la no GeradorStickers */
			InputStream inputStream = new URL(urlImagem).openStream();
			String nomeArquivo = titulo + ".png"; /* cria o nome do arquivo da imagem para salvar*/
			
			
			System.out.println(contador+"�"); /* exibe a posi��o do filme */
			System.out.println(titulo); /* usamos o mesmo nome da identifica��o que est� nos dados que estamos usamos */
            System.out.println(urlImagem);
            System.out.println(filme.get("imDbRating"));
            System.out.println();	
            contador++; /* soma 1 ao contado de posi��o ao final de cada exibi��o */
		}
		
		
		
		//System.out.println("chegou aqui"); /* enviando para console para testar */
	}

}

//REFERENCIA: JAVA DOC.
// https://docs.oracle.com/javame/8.0/api/httpclient/api/index.html