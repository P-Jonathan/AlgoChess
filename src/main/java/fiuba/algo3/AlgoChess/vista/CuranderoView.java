package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CuranderoView extends UnidadView {
    public CuranderoView(TableroView tableroView, Unidad curandero) {
        super(tableroView, curandero, 1);
    }

    @Override
    public Image getImage() {
        // Extraigo el sprite que me interesa del spritesheet usando la clase BufferedImage
        try {
            BufferedImage bf = ImageIO.read(new File("C://Users//andre//Documents//misProyectos//AlgoChess//src//main//resources//curandero.png"));
            BufferedImage subimage = bf.getSubimage(0,  0, 32, 32);
            Image image = SwingFXUtils.toFXImage(subimage, null) ;
            return image;
        } catch(IOException e) {
            System.out.println("Error cargando imagen");
        }

        return new Image("curandero.png");
    }
}
