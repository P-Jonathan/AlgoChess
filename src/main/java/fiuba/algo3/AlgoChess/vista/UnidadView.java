package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.modelo.unidades.Observer;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class UnidadView extends Button implements Observer {
    private double unitScale;
    private TableroView stage;
    private ImageView unitImage;

    private Unidad unidad;

    private int vidaUnidad;

    public UnidadView(TableroView stage, Unidad unidad, double unitScale) {
        this.stage = stage;
        this.unidad = unidad;
        this.unitScale = unitScale;
        vidaUnidad = unidad.getVida();

        unidad.addObserver(this);

        unitImage = new ImageView();
        unitImage.setScaleX(unitScale);
        unitImage.setScaleY(unitScale);
        unitImage.setFitHeight(32);
        unitImage.setFitWidth(32);

        unitImage.setImage(getImage());
        stage.addViewOnMap(unitImage, unidad.getX(), unidad.getY());

        unitImage.setOnMouseClicked(e-> {
            stage.accionCon(unidad);
        });
    }

    @Override
    public void change() {
        int vidaActual = unidad.getVida();

        if(vidaActual != vidaUnidad) {
            System.out.println("La unidad ha recibido danio. Vida actual: " + vidaActual);
            vidaUnidad = vidaActual;
        }

        stage.addViewOnMap(unitImage, unidad.getX(), unidad.getY());
    }

    public TableroView getStage() { return stage; }
    public ImageView getImageView() { return unitImage; }
    public Unidad getUnidad() { return unidad; }

    public abstract Image getImage();
}
