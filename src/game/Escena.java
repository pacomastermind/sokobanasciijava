package game;

import java.io.IOException;

/**
* Clase Escena. Almacena todos los elementos necesarios para representar un juego:
* 	- Mapa
* 	- Jugador
* 	- GameObjects:
* 		- Cajas
* 		- Objetivos
* 
* Futura mejora: Pintado del mapa por objetos y no por char
* 
* @author Pakito
* 
*/
public class Escena {
	
	private char[][] mapa;
	private int anchoMapa;
	private int altoMapa;
	
	private GameObject objetos[];
	private int numObjetos;
	
	private Jugador jugador;
	
	public int numObjetivos=0;

	public Escena() {
		this.objetos=new GameObject[20];
		this.numObjetos=0;
	}
	
	public void anyadirMapa(String mapa,int anchoMapa,int altoMapa) {
		this.mapa=new char[anchoMapa][altoMapa];
		this.anchoMapa=anchoMapa;
		this.altoMapa=altoMapa;
		//REllenamos el mapa
		for (int y=0;y<altoMapa;y++) {
			for (int x=0;x<anchoMapa;x++) {
				this.mapa[x][y]=mapa.charAt(x+y*anchoMapa);
				//Comprobamos los GameObjects
				if(mapa.charAt(x+y*anchoMapa)==Mapa.C_JUGADOR) {
					this.jugador=new Jugador(this);
					this.jugador.setPosx(x);
					this.jugador.setPosy(y);
				}else if(mapa.charAt(x+y*anchoMapa)==Mapa.C_CAJA){
					GameObject caja=new GameObject();
					caja.setPosx(x);
					caja.setPosy(y);
					this.anyadirObjeto(caja);
				}else if(mapa.charAt(x+y*anchoMapa)==Mapa.C_OBJETIVO){
					GameObject objetivo=new GameObject();
					objetivo.setPosx(x);
					objetivo.setPosy(y);
					this.anyadirObjeto(objetivo);
					this.numObjetivos++;
				}
			}
		}
	}
	
	public void anyadirObjeto(GameObject obj) {
		this.objetos[this.numObjetos]=obj;
		this.numObjetos++;
	}
	
	public void borraPantalla() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
		} catch (IOException | InterruptedException e) {
			System.out.println(e);		}
	}
	
	public Jugador getJugador() {
		return this.jugador;
	}
	
	public char[][] getMapa() {
		return this.mapa;
	}
	
	@Override
	public String toString() {
		String mapaPantalla=Mapa.mapaPantalla(this.mapa, this.anchoMapa, this.altoMapa);
		this.borraPantalla();
		return mapaPantalla;
	}

}
