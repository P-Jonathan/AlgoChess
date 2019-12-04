package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.controlador.UnidadInfanteriaController;
import fiuba.algo3.algochess.modelo.unidades.Observer;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UnidadInfanteriaView implements Observer {
    private TableroView tableroView;
    private Unidad unidad;
    private ImageView unitImage;
    private double vidaUnidad;
    private VidaView barraVida;

    public UnidadInfanteriaView(TableroView tableroView, Unidad unidad) {
        this.tableroView = tableroView;
        this.unidad = unidad;
        vidaUnidad = unidad.getVida();

        unidad.addObserver(this);

        unitImage = new ImageView();
        unitImage.setScaleX(2);
        unitImage.setScaleY(2);
        unitImage.setFitHeight(32);
        unitImage.setFitWidth(32);

        barraVida = new VidaView(vidaUnidad);
        unitImage.setImage(getImage());

        tableroView.addViewOnMap(barraVida, unidad.getX(), unidad.getY());
        tableroView.addViewOnMap(unitImage, unidad.getX(), unidad.getY());

        unitImage.setOnMouseClicked(new UnidadInfanteriaController(unidad, tableroView));
    }

    public Image getImage() {
        // Extraigo el sprite que me interesa del spritesheet usando la clase BufferedImage
        try {
            BufferedImage bf = ImageIO.read(new File("src/main/resources/infanteria.png"));
            BufferedImage subimage = bf.getSubimage(4 * 48, 0, 48, 48);
            Image image = SwingFXUtils.toFXImage(subimage, null) ;
            return image;
        } catch(IOException e) {
            System.out.println("Error cargando imagen");
        }

        return new Image("infanteria.png");
    }

    @Override
    public void change() {
        double vidaActual = unidad.getVida();

        if(vidaActual <= 0) {
            tableroView.removeView(unitImage);
            tableroView.removeView(barraVida);
        } else if(vidaActual != vidaUnidad) {
            vidaUnidad = vidaActual;
            barraVida.actualizarBarra(vidaUnidad);
        } else {
            tableroView.updateView(unitImage, unidad.getX(), unidad.getY());
            tableroView.updateView(barraVida, unidad.getX(), unidad.getY());
        }
    }
}
