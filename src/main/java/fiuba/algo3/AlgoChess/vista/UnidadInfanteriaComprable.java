package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UnidadInfanteriaComprable{
    private Tablero tablero;
    private ImageView unitImage;

    public UnidadInfanteriaComprable(Tablero tablero, Shop shop) {
        this.tablero = tablero;

        unitImage = new ImageView();
        unitImage.setScaleX(2);
        unitImage.setScaleY(2);
        unitImage.setFitHeight(32);
        unitImage.setFitWidth(32);

        unitImage.setImage(getImage());
        shop.addViewOnMap(unitImage, 0);

        unitImage.setOnMouseClicked(new ComprarUnidad(tablero));
    }

    public Image getImage() {
        // Extraigo el sprite que me interesa del spritesheet usando la clase BufferedImage
        try {
            BufferedImage bf = ImageIO.read(new File("C://Users//andre//Documents//misProyectos//AlgoChess//src//main//resources//infanteria.png"));
            BufferedImage subimage = bf.getSubimage(4 * 48, 0, 48, 48);
            Image image = SwingFXUtils.toFXImage(subimage, null) ;
            return image;
        } catch(IOException e) {
            System.out.println("Error cargando imagen");
        }

        return new Image("infanteria.png");
    }
}
