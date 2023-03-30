import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;

public class GeneratorX {
    

public void criar(InputStream inputStream, String nomeArquivo) throws Exception {


// leitura da imagem
//BufferedImage imageOriginal = ImageIO.read(new File("entrada/filme.jpg"));
BufferedImage imageOriginal = ImageIO.read(inputStream);
// criar imagem
int largura = imageOriginal.getWidth();
int altura = imageOriginal.getHeight();
int novaAltura = altura + 200;
BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

// copiar nova imagem
Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
graphics.drawImage(imageOriginal, 0, 0, null);



// CONFIGURAR A FONTE
var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 28);
graphics.setColor(Color.YELLOW);
graphics.setFont(fonte);



// escrever uma frase em uma nova imagem
graphics.drawString("USE E ABUSE", 30, novaAltura - 60);


// escrever a nova imagem em um arquivo

ImageIO.write(novaImagem, "png", new File(nomeArquivo));



}

}
