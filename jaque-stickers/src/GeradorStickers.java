import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class GeradorStickers {
	
//METODO CRIA() REFATORAÇÃO DA AULA. (OPÇÃO 2) - LE DE INPUTSTREAM
	
	public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        BufferedImage imagemOriginal = ImageIO.read(inputStream);
		//InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,3,128,176_AL_.jpg").openStream();
      
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        
        graphics.drawString("TOPZERA", 100, novaAltura - 100);

        ImageIO.write(novaImagem, "png", new File("saida/figurinha_1.png"));

    }


// METODO CRIA() OPÇÃO 1 - BAIXA A IMAGEM 
//	void cria() throws IOException { //a saída do metodo será a figurinha, por isso aqui é void, não existe um return
//		
//		// ALGORITMO:
//		// Ler a imagem.
//		// Criar uma nova imagem em memoria: deve ter transparencia e um novo tamanho.
//		// Escrever uma frase na nova imagem.
//		// Escrever a imagem original para um novo arquivo.
//		
//		
//		//PARA FAZER A LEITURA DA IMAGEM:
//		BufferedImage imagemOriginal = ImageIO.read(new File("img/Filme_1.jpg"));
//		
//		//PARA MUDAR A ALTURA DA IMAGEM (PARA ADICIONAR O TEXTO)
//		int largura = imagemOriginal.getWidth();
//		int altura = imagemOriginal.getHeight();
//		int novaAltura = altura + 200;
//		
//		/* cria a nova imagem com fundo transparente*/
//		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
//		
//		//PARA COPIAR A IMAGEM ORIGINAL NA NOVA IMAGEM CRIADA. /* tudo que fiz dos graphics não importou automaticamente, precisei fazer manual */
//		/* usamos o graphic para criar a imagem */
//		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
//		/* desenhando uma imagem */
//		graphics.drawImage(novaImagem, 0, 0, null); /* usamos a imagem antiga na nova. 0,0 é a posição onde está o desenho*/
//		
//		//PARA CONFIGURAR A FONTE QUE QUERO USAR PARA ESCREVER NA FIGURINHA
//		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 50);
//		graphics.setColor(Color.GREEN);
//		graphics.setFont(fonte);
//		
//		//PARA ESCREVER NA IMAGEM
//		graphics.drawString("1º FILME", 0, novaAltura - 100); /* "" o que será escrito, posição de largura, posição de altura */
//		
//		//PARA CRIAR NO ARQUIVO NOVO DE IMAGEM
//		ImageIO.write(novaImagem, "png", new File("saida/figurinha_1.png")); /* nome da imagem, formato, new file */
//	}
	
//	//MAIN PARA TESTAR A CLASSE
//	public static void main(String[] args) throws IOException {
//		var gerador = new GeradorStickers();
//		gerador.cria();
//	}

}
