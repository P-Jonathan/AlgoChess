package fiuba.algo3.AlgoChess.vista;

import java.io.File;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class ReproductorMusica {
	String cancionActual;
	
	public ReproductorMusica() {
		cancionActual = "110 Commander in Training.mp3";
	}
	
	public void cambiarMusica(String nombre) {
		cancionActual = nombre;
	}
	public void reproducirMusica() {
		String path = "src/main/resources/"+cancionActual;
	    
	    Media media = new Media(new File(path).toURI().toString());  
	    
	    AudioClip mediaPlayer = new AudioClip(media.getSource());  
	    
	    mediaPlayer.play();

	}
}
