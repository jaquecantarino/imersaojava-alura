
public class Conteudo {

	// Para criar e armazenar o conteudo

	private final String titulo;
	private final String urlImagem;

	public Conteudo(String titulo, String urlImagem) {
		this.titulo = titulo;
		this.urlImagem = urlImagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

}
