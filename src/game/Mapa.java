package game;

/**
* Clase Mapa. Clase utilidad que presenta
* 	- Diferentes niveles utilizables
* 	- Pintar mapa en pantalla
* 	- Buscar objetos dentro del mapa para añadirlos a la escena automáticamante
* 
* Futura mejora: carga mediante ficheros
* 
* @author Pakito
* 
*/
public class Mapa {
	public final static String NIVEL_01=""
			+ "####################"
			+ "#       .          #"
			+ "#               O  #"
			+ "#   J              #"
			+ "#                  #"
			+ "#                  #"
			+ "#                  #"
			+ "#    O             #"
			+ "#     .  #####     #"
			+ "#                  #"
			+ "#                  #"
			+ "#            O    .#"
			+ "#                  #"
			+ "#                  #"
			+ "####################";
	public final static int AN_NIVEL_01=20;
	public final static int AL_NIVEL_01=15;
	
	public final static String NIVEL_02=""
			+ "#########################"
			+ "#       .               #"
			+ "#             #  O      #"
			+ "#   J         #         #"
			+ "#             #         #"
			+ "#             #         #"
			+ "#            #          #"
			+ "#    O       #          #"
			+ "#     .  ######         #"
			+ "#         #    #####    #"
			+ "#          #            #"
			+ "#         #   O    .    #"
			+ "#         #             #"
			+ "#         #             #"
			+ "#########################";
	public final static int AN_NIVEL_02=22;
	public final static int AL_NIVEL_02=15;
	
	public final static char C_JUGADOR='J';
	public final static char C_PARED='#';
	public final static char C_CAJA='O';
	public final static char C_OBJETIVO='.';
	
	
	public static String mapaPantalla(char[][] mapa,int ancho, int alto) {
		String mapaPantalla="";
		mapaPantalla=mapaPantalla+"\n-------SOKOBAN-------\n";
		mapaPantalla=mapaPantalla+"a=izquierda\n";
		mapaPantalla=mapaPantalla+"w=arriba\n";
		mapaPantalla=mapaPantalla+"s=abajo\n";
		mapaPantalla=mapaPantalla+"d=derecha\n";
		mapaPantalla=mapaPantalla+"\nq=abandonar\n";
		mapaPantalla=mapaPantalla+"\n---------------------\n";
		for (int y=0;y<alto;y++) {
			for (int x=0;x<ancho;x++) {
				mapaPantalla=mapaPantalla+mapa[x][y];
			}
			mapaPantalla=mapaPantalla+'\n';
		}
		return mapaPantalla;
	}
	
	
	public static void buscarObjetos(String mapa,int ancho, int alto,Escena e) {
		for (int x=0;x<ancho;x++) {
			for (int y=0;y<alto;y++)
				if(mapa.charAt(x+y*ancho)==Mapa.C_JUGADOR) {
					Jugador j=new Jugador();
					j.setPosx(x);
					j.setPosy(y);
				}else if(mapa.charAt(x+y*ancho)==Mapa.C_CAJA){
					GameObject caja=new GameObject();
					caja.setPosx(x);
					caja.setPosy(y);
					e.anyadirObjeto(caja);
				}else if(mapa.charAt(x+y*ancho)==Mapa.C_OBJETIVO){
					GameObject objetivo=new GameObject();
					objetivo.setPosx(x);
					objetivo.setPosy(y);
					e.anyadirObjeto(objetivo);
					e.numObjetivos++;
				}
		}		
	}
		
}
