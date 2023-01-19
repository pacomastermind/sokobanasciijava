package game;


/**
* Clase Jugador. Evolución de un GameObject y que permite controlar el movimiento
* dentro de un escenario

* Futura mejora: añadirle límites y eventos
* 
* @author Pakito
* 
*/
public class Jugador extends GameObject{
	private Escena escena;

	public Jugador() {
		super.visualChar=Mapa.C_JUGADOR;
	}
	
	public Jugador(Escena e) {
		super.visualChar=Mapa.C_JUGADOR;
		this.escena=e;
	}
	
	private boolean esPared(char p) {
		if(p==Mapa.C_PARED) return true;
		return false;
	}
	private boolean esCaja(char p) {
		if(p==Mapa.C_CAJA) return true;
		return false;
	}
	
	private boolean esObjetivo(char p) {
		if(p==Mapa.C_OBJETIVO) return true;
		return false;
	}
	
	public void movIzd(char[][] mapa) {
		if(!esPared(mapa[this.getPosx()-1][this.getPosy()]))
		{
			//No es pared ni caja
			if(!esCaja(mapa[this.getPosx()-1][this.getPosy()])) {
				mapa[this.getPosx()][this.getPosy()]=' ';
				this.setPosx(this.getPosx()-1);
				mapa[this.getPosx()][this.getPosy()]=Mapa.C_JUGADOR;
			//Es caja
			}else{
				//A la izda de la caja no hay pared
				if(!esPared(mapa[this.getPosx()-2][this.getPosy()])) {
					//Movemos jugador
					mapa[this.getPosx()][this.getPosy()]=' ';
					this.setPosx(this.getPosx()-1);
					mapa[this.getPosx()][this.getPosy()]=Mapa.C_JUGADOR;
					//Comprobamos si tapamos objetivo
					if(esObjetivo(mapa[this.getPosx()-1][this.getPosy()])) {
						//Destruimos caja y objetivo
						mapa[this.getPosx()-1][this.getPosy()]=' ';	
						this.escena.numObjetivos--;
					}else{
						//Movemos caja (Ojo no movemos el gameObject, futuro desarrollo)
						mapa[this.getPosx()-1][this.getPosy()]=Mapa.C_CAJA;						
					}
				}
			}
		}
	}
	
	public void movDrc(char[][] mapa) {
		if(!esPared(mapa[this.getPosx()+1][this.getPosy()]))
		{
			//No es pared ni caja
			if(!esCaja(mapa[this.getPosx()+1][this.getPosy()])) {
				mapa[this.getPosx()][this.getPosy()]=' ';
				this.setPosx(this.getPosx()+1);
				mapa[this.getPosx()][this.getPosy()]=Mapa.C_JUGADOR;
			}else{
				//A la drcha de la caja no hay pared
				if(!esPared(mapa[this.getPosx()+2][this.getPosy()])) {
					//Movemos jugador
					mapa[this.getPosx()][this.getPosy()]=' ';
					this.setPosx(this.getPosx()+1);
					mapa[this.getPosx()][this.getPosy()]=Mapa.C_JUGADOR;
					//Comprobamos si tapamos objetivo
					if(esObjetivo(mapa[this.getPosx()+1][this.getPosy()])) {
						//Destruimos caja y objetivo
						mapa[this.getPosx()+1][this.getPosy()]=' ';	
						this.escena.numObjetivos--;
					}else{
						//Movemos caja (Ojo no movemos el gameObject, futuro desarrollo)
						mapa[this.getPosx()+1][this.getPosy()]=Mapa.C_CAJA;							
					}	
				}
			}
		}
	}
	
	public void movArr(char[][] mapa) {
		if(!esPared(mapa[this.getPosx()][this.getPosy()-1]))
		{
			//No es pared ni caja
			if(!esCaja(mapa[this.getPosx()][this.getPosy()-1])) {
				mapa[this.getPosx()][this.getPosy()]=' ';
				this.setPosy(this.getPosy()-1);
				mapa[this.getPosx()][this.getPosy()]=Mapa.C_JUGADOR;
			}else{
				//Arriba de la caja no hay pared
				if(!esPared(mapa[this.getPosx()][this.getPosy()-2])) {
					//Movemos jugador
					mapa[this.getPosx()][this.getPosy()]=' ';
					this.setPosy(this.getPosy()-1);
					mapa[this.getPosx()][this.getPosy()]=Mapa.C_JUGADOR;
					//Comprobamos si tapamos objetivo
					if(esObjetivo(mapa[this.getPosx()][this.getPosy()-1])) {
						//Destruimos caja y objetivo
						mapa[this.getPosx()][this.getPosy()-1]=' ';	
						this.escena.numObjetivos--;
					}else{
						//Movemos caja (Ojo no movemos el gameObject, futuro desarrollo)
						mapa[this.getPosx()][this.getPosy()-1]=Mapa.C_CAJA;								
					}				
				}				
			}
		}
	}
	
	public void movAbj(char[][] mapa) {
		if(!esPared(mapa[this.getPosx()][this.getPosy()+1]))
		{
			//No es pared ni caja
			if(!esCaja(mapa[this.getPosx()][this.getPosy()+1])) {
				mapa[this.getPosx()][this.getPosy()]=' ';
				this.setPosy(this.getPosy()+1);
				mapa[this.getPosx()][this.getPosy()]=Mapa.C_JUGADOR;
			}else{
				//Abajo de la caja no hay pared
				if(!esPared(mapa[this.getPosx()][this.getPosy()+2])) {
					//Movemos jugador
					mapa[this.getPosx()][this.getPosy()]=' ';
					this.setPosy(this.getPosy()+1);
					mapa[this.getPosx()][this.getPosy()]=Mapa.C_JUGADOR;
					//Comprobamos si tapamos objetivo
					if(esObjetivo(mapa[this.getPosx()][this.getPosy()+1])) {
						//Destruimos caja y objetivo
						mapa[this.getPosx()][this.getPosy()+1]=' ';	
						this.escena.numObjetivos--;
					}else{
						//Movemos caja (Ojo no movemos el gameObject, futuro desarrollo)
						mapa[this.getPosx()][this.getPosy()+1]=Mapa.C_CAJA;						
					}			
				}
				
			}
		}
	}

}
