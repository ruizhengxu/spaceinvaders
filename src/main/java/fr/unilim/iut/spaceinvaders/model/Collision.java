package fr.unilim.iut.spaceinvaders.model;

public class Collision {
	
	public boolean detecterCollision(Missile missile, Envahisseur envahisseur) {
		return(this.collisionAbscisse(missile, envahisseur) && this.collisionOrdonnee(missile, envahisseur));
	}
	
	private boolean collisionAbscisse(Missile missile, Envahisseur envahisseur) {
		return(missile.abscisseLaPlusAGauche() <= envahisseur.abscisseLaPlusADroite() &&
				missile.abscisseLaPlusADroite() >= envahisseur.abscisseLaPlusAGauche());
	}
	
	private boolean collisionOrdonnee(Missile missile, Envahisseur envahisseur) {
		return(missile.ordonneeLaPlusBasse() <= envahisseur.ordonneeLaPlusHaute() &&
				missile.ordonneeLaPlusHaute() >= envahisseur.ordonneeLaPlusBasse());
	}
	
}
