package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.controlador.CatapultaController;
import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.unidades.Observer;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CatapultaView extends Button implements Observer {
    private TableroView tableroView;
    private Unidad unidad;
    private ImageView unitImage;
    private double vidaUnidad;
    private VidaView barraVida;

    public CatapultaView(TableroView tableroView, Unidad unidad) {
        this.unidad = unidad;
        this.tableroView = tableroView;
        this.vidaUnidad = unidad.getVida();

        unidad.addObserver(this);

        unitImage = new ImageView();
        unitImage.setScaleX(1.2);
        unitImage.setScaleY(1.2);
        unitImage.setFitHeight(38);
        unitImage.setFitWidth(48);

        barraVida = new VidaView(vidaUnidad);
        unitImage.setImage(getImage());

        tableroView.addViewOnMap(barraVida, unidad.getX(), unidad.getY());
        tableroView.addViewOnMap(unitImage, unidad.getX(), unidad.getY());

        unitImage.setOnMouseClicked(new CatapultaController(unidad, tableroView));
    }

    public Image getImage() {
        // Extraigo el sprite que me interesa del spritesheet usando la clase BufferedImage
        try {
            BufferedImage bf = ImageIO.read(new File("src/main/resources/catapulta.png"));
            BufferedImage subimage = bf.getSubimage(4 * 32, 0, 32, 32);
            return SwingFXUtils.toFXImage(subimage, null);
        } catch(IOException e) {
            System.out.println("Error cargando imagen");
        }

        return new Image("catapulta.png");
    }

    @Override
    public void change() {
        double vidaActual = unidad.getVida();

        if(vidaActual != vidaUnidad) {
            vidaUnidad = vidaActual;
            barraVida.actualizarBarra(vidaUnidad);
        }
    }
}
