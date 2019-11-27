package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class JineteView extends UnidadView {
    public JineteView(TableroView tableroView, Unidad jinete) {
        super(tableroView, jinete, 1);
    }

    @Override
    public Image getImage() {
        // Extraigo el sprite que me interesa del spritesheet usando la clase BufferedImage
        try {
            BufferedImage bf = ImageIO.read(new File("C://Users//andre//Documents//misProyectos//AlgoChess//src//main//resources//jinete.png"));
            BufferedImage subimage = bf.getSubimage(4 * 32, 0, 32, 32);
            Image image = SwingFXUtils.toFXImage(subimage, null) ;
            return image;
        } catch(IOException e) {
            System.out.println("Error cargando imagen");
        }

        return new Image("jinete.png");
    }
}
