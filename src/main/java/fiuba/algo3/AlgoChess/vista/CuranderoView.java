package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.controlador.CuranderoController;
import fiuba.algo3.AlgoChess.modelo.unidades.Observer;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CuranderoView implements Observer {
    private TableroView tableroView;
    private Unidad unidad;
    private ImageView unitImage;

    public CuranderoView(TableroView tableroView, Unidad unidad) {
        this.tableroView = tableroView;
        this.unidad = unidad;

        unidad.addObserver(this);

        unitImage = new ImageView();
        unitImage.setScaleX(2);
        unitImage.setScaleY(2);
        unitImage.setFitHeight(32);
        unitImage.setFitWidth(32);

        unitImage.setImage(getImage());
        tableroView.addViewOnMap(unitImage, unidad.getX(), unidad.getY());

        unitImage.setOnMouseClicked(new CuranderoController(unidad, tableroView));
    }

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

    @Override
    public void change() {
        tableroView.addViewOnMap(unitImage, unidad.getX(), unidad.getY());
    }
}
