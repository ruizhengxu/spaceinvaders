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

	public void dessiner(BufferedImage image) {
		SpaceInvaders s = (SpaceInvaders) jeu;
		Vaisseau vaisseau = s.getVaisseau();
		Graphics2D crayon = (Graphics2D) image.getGraphics();
		crayon.setColor(Color.black);
		crayon.fillRect(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusBasse(), vaisseau.getDimension().longueur, vaisseau.getDimension().hauteur);
	}

}
