package fr.unilim.iut.spaceinvaders;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import fr.unilim.iut.spaceinvaders.moteurjeu.DessinJeu;

public class DessinSpaceInvaders implements DessinJeu {

	private SpaceInvaders jeu;
	
	
	public DessinSpaceInvaders(SpaceInvaders jeu) {
		this.jeu = jeu;
	}

	public void dessiner(BufferedImage im) {
		if (this.jeu.aUnVaisseau()) {
		   Vaisseau vaisseau = this.jeu.getVaisseau();
		   this.dessinerUnVaisseau(vaisseau, im);
		}
		if (this.jeu.aUnMissile()) {
			Missile missile = this.jeu.getMissile();
			this.dessinerUnMissile(missile, im);
		}
	}

	private void dessinerUnVaisseau(Vaisseau vaisseau, BufferedImage im) {
		   
		Graphics2D crayon = (Graphics2D) im.getGraphics();

		crayon.setColor(Color.black);
		crayon.fillRect(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusBasse(), vaisseau.dimension.longueur(), vaisseau.dimension.hauteur());

	}
	
	private void dessinerUnMissile(Missile missile, BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();

		crayon.setColor(Color.blue);
		crayon.fillRect(missile.abscisseLaPlusAGauche(), missile.ordonneeLaPlusBasse(), missile.dimension.longueur, missile.dimension.hauteur);
	}

}
