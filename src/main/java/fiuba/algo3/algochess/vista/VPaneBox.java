package fiuba.algo3.algochess.vista;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.File;

public class VPaneBox extends VBox {
    private static final String STYLE_PATH = "ChatStyle.css";

    public VPaneBox() {
        //this.getStylesheets().add(new File(STYLE_PATH).toString());
    }

    public void add(Node view) {
        this.getChildren().remove(view);
        this.getChildren().add(view);
    }

    public void remove(Node view) {
        this.getChildren().remove(view);
    }

    public void remove(int index) {
        this.getChildren().remove(index);
    }
}
