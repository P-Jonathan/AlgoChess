package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class UnidadView extends Button {
    private double unitScale;
    private TableroView stage;
    private ImageView unitImage;

    private Unidad unidad;

    public UnidadView(TableroView stage, Unidad unidad, double unitScale) {
        this.stage = stage;
        this.unidad = unidad;
        this.unitScale = unitScale;

        unitImage = new ImageView();
        unitImage.setScaleX(unitScale);
        unitImage.setScaleY(unitScale);
        unitImage.setFitHeight(32);
        unitImage.setFitWidth(32);

        unitImage.setImage(getImage());
        stage.addViewOnMap(unitImage, unidad.getX(), unidad.getY());
        draw();

        unitImage.setOnMouseClicked(e-> {
            stage.accionCon(unidad, unitImage);
        });
    }

    public abstract Image getImage();

    public void draw() {
        unitImage.setTranslateX(0);
        unitImage.setTranslateY(0);
        //stage.updateView(unitImage);
    }

}
