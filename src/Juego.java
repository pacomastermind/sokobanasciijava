import java.io.IOException;

import game.Escena;
import game.Jugador;
import game.Mapa;
import util.RawConsoleInput;

public class Juego {

	public static void main(String[] args) {
		//Entrada de pantalla
		String splashScreen=""
				+ " _______  _______  ___   _  _______  _______  _______  __    _ \n"
				+ "|       ||       ||   | | ||       ||  _    ||   _   ||  |  | |\n"
				+ "|  _____||   _   ||   |_| ||   _   || |_|   ||  |_|  ||   |_| |\n"
				+ "| |_____ |  | |  ||      _||  | |  ||       ||       ||       |\n"
				+ "|_____  ||  |_|  ||     |_ |  |_|  ||  _   | |       ||  _    |\n"
				+ " _____| ||       ||    _  ||       || |_|   ||   _   || | |   |\n"
				+ "|_______||_______||___| |_||_______||_______||__| |__||_|  |__|\n";
		System.out.println(splashScreen);		
        long start = System.currentTimeMillis();
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        //Comienza el juego con la carga del nivel
		Escena nivel=new Escena();
		nivel.anyadirMapa(Mapa.NIVEL_01,Mapa.AN_NIVEL_01,Mapa.AL_NIVEL_01);
		
		
		//Comienza el juego
		int tecla;
		while(true) {
			try {
				System.out.println(nivel);
				if(nivel.numObjetivos==0) {
					System.out.println("\n OBJETIVOS CONSEGUIDO \n");
					break;
				}
				tecla=RawConsoleInput.read(true);
				if((char)tecla=='q') break;
				if((char)tecla=='a') nivel.getJugador().movIzd(nivel.getMapa());
				if((char)tecla=='d') nivel.getJugador().movDrc(nivel.getMapa());
				if((char)tecla=='w') nivel.getJugador().movArr(nivel.getMapa());
				if((char)tecla=='s') nivel.getJugador().movAbj(nivel.getMapa());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
