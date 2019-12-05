package fiuba.algo3.algochess.vista.comprabutton;

import fiuba.algo3.algochess.controlador.buttonHandler.CompraDeUnidadController;
import fiuba.algo3.algochess.vista.TableroView;
import fiuba.algo3.algochess.vista.Sprite;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextAlignment;

public abstract class CompraDeUnidadView extends Button {
    private static final int DEFAULT_BUTTON_WIDTH = 320;
    private static final int DEFAULT_BUTTON_HEIGHT = 56;

    protected CompraDeUnidadController cuc;
    protected TableroView tableroView;
    protected Sprite sprite;

    public CompraDeUnidadView(CompraDeUnidadController cuc, TableroView tableroView, Sprite sprite) {
        this.tableroView = tableroView;
        this.sprite = sprite;
        this.cuc = cuc;
/*
        this.setMinSize(sprite.getOutWidth(), sprite.getOutHeight());
        this.setMaxSize(sprite.getOutWidth(), sprite.getOutHeight());*/
        this.setMinSize(DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT);
        this.setMaxSize(DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT);
        this.setTextAlignment(TextAlignment.CENTER);
        this.setGraphic(getImageView());
        this.setText("Buy Button");
        this.setOnAction(cuc);
    }

    private ImageView getImageView() {
        ImageView imageView = new ImageView(getImage());
        imageView.setFitHeight(getImage().getHeight());
        imageView.setFitWidth(getImage().getWidth());

        return imageView;
    }

    private Image getImage() {
        return SwingFXUtils.toFXImage(sprite.getActualFrame(), null) ;
    }
}
