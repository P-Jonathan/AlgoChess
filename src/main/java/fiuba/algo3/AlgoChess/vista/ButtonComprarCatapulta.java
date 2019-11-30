package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.controlador.buttonHandler.ComprarCatapultaHandler;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextAlignment;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ButtonComprarCatapulta extends Button {

    public ButtonComprarCatapulta(Tablero tablero, TableroView tableroView) {
        super();
        this.setMinSize(320,56);
        this.setMaxSize(320,56);
        this.setGraphic(getImageView());
        this.setText("Catapulta");
        this.setTextAlignment(TextAlignment.CENTER);
        this.setOnAction(new ComprarCatapultaHandler(tablero, tableroView));
    }

    private ImageView getImageView() {
        ImageView imageView = new ImageView(getImage());
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);

        return imageView;
    }

    private Image getImage() {
        // Extraigo el sprite que me interesa del spritesheet usando la clase BufferedImage
        try {
            BufferedImage bf = ImageIO.read(new File("src/main/resources/caras.png"));
            BufferedImage subimage = bf.getSubimage(6 * 27, 0, 27, 19);
            Image image = SwingFXUtils.toFXImage(subimage, null) ;
            return image;
        } catch(IOException e) {
            System.out.println("Error cargando imagen");
        }

        return new Image("caras.png");
    }

}