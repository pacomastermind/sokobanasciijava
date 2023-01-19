package game;

/**
* Clase GameObject. Evolución de un GameObject y que permite controlar el movimiento
* dentro de un escenario

* Futura mejora: añadirle límites y eventos
* 
* @author Pakito
* 
*/
public class GameObject {
	
	public int id;
	public char visualChar;
	private int posx;
	private int posy;

	public GameObject() {
		this.id=0;
		this.posx=0;
		this.posy=0;
		this.visualChar=' ';
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		if(posx<0)this.posx = 0;
		else this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		if(posy<0)this.posy = 0;
		else this.posy = posy;
	}

}
