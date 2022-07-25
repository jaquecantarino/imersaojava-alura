import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClientHttp {

	// crio um metodo publico que vai buscar o dado, vai fazer todos os passos de
	// busca do http que a primeira parte do código até a aula 2 fazia.
	public String buscaDados(String url) {
		
		try {
			URI endereco = URI.create(url);
	        var client = HttpClient.newHttpClient();
	        var request = HttpRequest.newBuilder(endereco).GET().build();
	        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	        String body = response.body();
			return body;
			
		} catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
	}

}
