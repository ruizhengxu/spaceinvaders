package fr.unilim.iut.spaceinvaders.model;

import fr.unilim.iut.spaceinvaders.moteurjeu.Commande;
import fr.unilim.iut.spaceinvaders.moteurjeu.Jeu;
import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.MissileException;

public class SpaceInvaders implements Jeu{
		
	int longueur;
    int hauteur;
    Vaisseau vaisseau;
    Missile missile;
    Envahisseur envahisseur;
    Direction directionEnvahisseur;
    Collision collision;
    
    

    public SpaceInvaders(int longueur, int hauteur) {
    	this.longueur = longueur;
    	this.hauteur = hauteur;
    	this.directionEnvahisseur = Direction.DROITE;
    	this.collision = new Collision();
    }
    
    public Vaisseau getVaisseau() {
		return this.vaisseau;
	}
    
    public Missile getMissile() {
		return this.missile;
	}
    
    public Envahisseur getEnvahisseur() {
		return this.envahisseur;
	}
    

	public String recupererEspaceJeuDansChaineASCII() {
		StringBuilder espaceDeJeu = new StringBuilder();
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < longueur; x++) {
                espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
            }
            espaceDeJeu.append(Constante.MARQUE_FIN_LIGNE);
        }
        return espaceDeJeu.toString();
	}
	

	public char recupererMarqueDeLaPosition(int x, int y) {
		char marque;
		if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
		      marque= Constante.MARQUE_VAISSEAU;
		else if(this.aUnMissileQuiOccupeLaPosition(x,y))
		      marque= Constante.MARQUE_MISSILE;
		else if(this.aUnEnvahisseurQuiOccupeLaPosition(x,y))
			  marque= Constante.MARQUE_ENVAHISSEUR;
		else
			marque = Constante.MARQUE_VIDE;
		return marque;
	}
	

	private boolean aUnEnvahisseurQuiOccupeLaPosition(int x, int y) {
		return this.aUnEnvahisseur() && envahisseur.occupeLaPosition(x, y);
	}

	public boolean aUnEnvahisseur() {
		return envahisseur != null;
	}

	private boolean aUnMissileQuiOccupeLaPosition(int x, int y) {
		return this.aUnMissile() && missile.occupeLaPosition(x, y);
	}

	public boolean aUnMissile() {
		return missile != null;
	}

	private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
		return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
	}

	
	public boolean aUnVaisseau() {
		return vaisseau != null;
	}


	private boolean estDansEspaceJeu(int x, int y) {
		return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
	}


	public void deplacerVaisseauVersLaDroite() {
		if (vaisseau.abscisseLaPlusADroite() < (longueur - 1)) {
			vaisseau.deplacerHorizontalementVers(Direction.DROITE);
			if (!estDansEspaceJeu(vaisseau.abscisseLaPlusADroite(), vaisseau.ordonneeLaPlusHaute())) {
				vaisseau.positionner(longueur - vaisseau.getDimension().longueur(), vaisseau.ordonneeLaPlusHaute());
			}
		}
	}


	public void deplacerVaisseauVersLaGauche() {
		if (0 < vaisseau.abscisseLaPlusAGauche())
			vaisseau.deplacerHorizontalementVers(Direction.GAUCHE);
		if (!estDansEspaceJeu(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusHaute())) {
			vaisseau.positionner(0, vaisseau.ordonneeLaPlusHaute());
		}
	}

	
	public void positionnerUnNouveauVaisseau(Dimension dimension, Position position, int vitesse) {
		int x = position.abscisse();
		int y = position.ordonnee();
		
		if (!estDansEspaceJeu(x, y))
			throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");

		int longueurVaisseau = dimension.longueur();
		int hauteurVaisseau = dimension.hauteur();
		
		if (!estDansEspaceJeu(x + longueurVaisseau - 1, y))
			throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers la droite à cause de sa longueur");
		if (!estDansEspaceJeu(x, y - hauteurVaisseau + 1))
			throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers le bas à cause de sa hauteur");

		vaisseau = new Vaisseau(dimension,position,vitesse);
	}
	
	public void deplacer(Commande c) {
		
		if (c.gauche)
		{
			this.deplacerVaisseauVersLaGauche();
		}

		if (c.droite)
		{
			this.deplacerVaisseauVersLaDroite();
		}
		
	}


	public void evoluer(Commande commandeUser) {
		
		this.deplacer(commandeUser);
		
		if (commandeUser.tir && !this.aUnMissile()) {
			tirerUnMissile(new Dimension(Constante.MISSILE_LONGUEUR, Constante.MISSILE_HAUTEUR), Constante.MISSILE_VITESSE);
		}
		
		if(this.aUnMissile()) {
			this.deplacerMissile();
		}
		if(this.aUnEnvahisseur()) {
			this.deplacerEnvahisseur();
		}
		
	}

	public boolean etreFini() {
		// Le jeu n'est jamais fini
		return false;
	}
	
	public void initialiserJeu() {
		Position positionVaisseau = new Position(this.longueur/2,this.hauteur-1);
		Dimension dimensionVaisseau = new Dimension(Constante.VAISSEAU_LONGUEUR, Constante.VAISSEAU_HAUTEUR);
		
		Position positionEnvahisseur = new Position(this.longueur/2, 80);//this.hauteur-(this.hauteur-Constante.ENVAHISSEUR_HAUTEUR));
		Dimension dimensionEnvahisseur = new Dimension(Constante.ENVAHISSEUR_LONGUEUR, Constante.ENVAHISSEUR_HAUTEUR);
		
		positionnerUnNouveauVaisseau(dimensionVaisseau, positionVaisseau, Constante.VAISSEAU_VITESSE);
		positionnerUnNouveauEnvahisseur(dimensionEnvahisseur, positionEnvahisseur, Constante.ENVAHISSEUR_VITESSE);
	 }

	public void tirerUnMissile(Dimension dimensionMissile, int vitesseMissile) {
		
		   if ((vaisseau.dimension.hauteur + dimensionMissile.hauteur()) > this.hauteur )
			   throw new MissileException("Pas assez de hauteur libre entre le vaisseau et le haut de l'espace jeu pour tirer le missile");
							
		   this.missile = this.vaisseau.tirerUnMissile(dimensionMissile,vitesseMissile);
    }

	public void deplacerMissile() {
		this.missile.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		if(this.missile.ordonneeLaPlusHaute() <= 0) {
			this.missile=null;
		}
		if(this.aUnEnvahisseur() && this.aUnMissile() && collision.detecterCollision(this.missile, this.envahisseur)) {
			this.envahisseur = null;
			this.missile = null;
		}
	}

	public void positionnerUnNouveauEnvahisseur(Dimension dimension, Position position, int i) {
		int x = position.abscisse();
		int y = position.ordonnee();
		
		if (!estDansEspaceJeu(x, y))
			throw new HorsEspaceJeuException("La position de l'envahisseur est en dehors de l'espace jeu");

		int longueurEnvahisseur = dimension.longueur();
		int hauteurEnvahisseur = dimension.hauteur();
		
		if (!estDansEspaceJeu(x + longueurEnvahisseur - 1, y))
			throw new DebordementEspaceJeuException("L'envahisseur déborde de l'espace jeu vers la droite à cause de sa longueur");
		if (!estDansEspaceJeu(x, y - hauteurEnvahisseur + 1))
			throw new DebordementEspaceJeuException("L'envahisseur déborde de l'espace jeu vers le bas à cause de sa hauteur");

		envahisseur = new Envahisseur(dimension,position,i);
	}
	
	public void deplacerEnvahisseur() {
		if(envahisseur.abscisseLaPlusAGauche() == 0 || envahisseur.abscisseLaPlusADroite() == this.longueur - 1) {
			if(this.directionEnvahisseur.equals(Direction.DROITE)) {
				this.directionEnvahisseur = Direction.GAUCHE;
			}
			else {
				this.directionEnvahisseur = Direction.DROITE;
			}
		}
		if(envahisseur.abscisseLaPlusADroite() < (longueur - 1) || 0 < envahisseur.abscisseLaPlusAGauche()) {
			envahisseur.deplacerHorizontalementVers(this.directionEnvahisseur);
		}
		positionnerEnvahisseurSiHorsEspaceJeu();
	}

	private void positionnerEnvahisseurSiHorsEspaceJeu() {
		
		if (!estDansEspaceJeu(envahisseur.abscisseLaPlusADroite(), envahisseur.ordonneeLaPlusHaute())) {
			envahisseur.positionner(longueur - envahisseur.getDimension().longueur(), envahisseur.ordonneeLaPlusHaute());
		}
		if (!estDansEspaceJeu(envahisseur.abscisseLaPlusAGauche(), envahisseur.ordonneeLaPlusHaute())) {
			envahisseur.positionner(0, envahisseur.ordonneeLaPlusHaute());
		}
		
	}
	
	
	
}
