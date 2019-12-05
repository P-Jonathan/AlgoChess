package fiuba.algo3.algochess.vista.chatbox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.List;
import java.util.LinkedList;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.TextAlignment;

public class ChatBox extends Pane {
    private static final String STYLE_PATH = "ChatStyle.css";
    private static final int DEFAULT_WIDTH = 320;
    private static final int DEFAULT_HEIGHT = 200;

    private List<Label> messages;

    private ScrollPane scrollPane;
    private VBox chat;

    public ChatBox() {
        //this.getStylesheets().add(new File(STYLE_PATH).toString());
        //this.getStyleClass().add("scrollpanel");
        messages = new LinkedList<>();
        scrollPane = new ScrollPane();
        chat = new VBox();
        chat.setPadding(new Insets(10));

        this.setPrefSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        chat.setPrefSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        scrollPane.setPrefSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        scrollPane.setContent(chat);
        //chat.getStyleClass().add("chatbox");

        this.getChildren().add(scrollPane);
    }

    public void addMessage(String message) {
        Label label = new Label(message);
        label.setAlignment(Pos.CENTER_LEFT);
        label.setMinWidth(DEFAULT_WIDTH - 10);
        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.JUSTIFY);
        messages.add(label);
        chat.getChildren().add(label);
    }

    public void update() {
        chat.getChildren().removeAll(messages);
        chat.getChildren().addAll(messages);
    }

    public void clear() {
        chat.getChildren().clear();
        messages.clear();
    }
}
