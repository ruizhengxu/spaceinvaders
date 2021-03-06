# spaceinvaders
# ajout d'un nouveau fichier dans mon répertorie

# Semaine du 29/04 au 03/05
## Description du travail effectué
   * Création de classe Position et Dimension;
   * Refactoring de la méthode positionnerUnNouveauVaisseau qui prend désormais deux paramètres new Dimension(x,y) et new Position(x,y);
   * Remplacament de toutes les méthodes positionnerUnNouveauVaisseau par la nouvelle,
   * Mise en place du refatoring autour de la position du Vaisseau (on met Position origine au lieu de int x et int y).
   * Mise en place du refatoring autour de la dimension du Vaisseau (on met Dimension dimension au lieu de int longueur et int hauteur)
   * Mise à jour du diagramme de classe
## Diagramme de classes
   ![alt text](https://github.com/ruizhengxu/spaceinvaders/blob/master/imageDiagramClass/spaceInvadersDiagramClass.png)
## Nuage de mots
   ![alt text](https://github.com/ruizhengxu/spaceinvaders/blob/master/imageWordCloud/spaceinvadersWordCloud.png)

---

# Semaine du 06/05 au 10/05
## Description du travail effectué
   * Ajouter la vitesse au Vaisseau sans régression de comportement
   * Faire en sorte que le déplacement se fasse correctement pour une vitesse quelconque
   * Intégration du moteur graphique
   * Refactoring de la classe SpaceInvaders en déplaçant les constantes dans la classe Constante
   * Création d'une nouvelle classe Sprite
   * Refactoring de la classe Vaisseau
   
## Diagramme de classes
   ![alt text](https://github.com/ruizhengxu/spaceinvaders/blob/master/imageDiagramClass/spaceInvadersDiagramClass2.png)

## Nuage de mots
   ![alt text](https://github.com/ruizhengxu/spaceinvaders/blob/master/imageWordCloud/spaceinvadersWordCloud2.png)

---

# Semaine du 13/05 au 17/05
## Description du travail effectué
   ### Tirer un missile en TDD 
   * Ecrire un premier un test (cas normal de tirerUnMissile)
   * Ajout de la méthode tirerUnMissile dans la classe Vaisseau, SpaceInvaders
   * Ajout de la méthode aUnMissileQuiOccupeLaPosition, aUnMissle et aUnVaisseauQuiOccupeLaPosition dans SpaceInvaders
   * Création de la classe Missile qui hérite de Sprite et de son constructeur
   * Ajout de test pour le missile lorsque il dépasse l'espace jeu
   
   ### Intégration de la missile
   * Ajout de la méthode dessinerUnMissile
   * Création d'un misssile lorsque l'utilisateur appuie sur ESPACE
   
   ### Faire déplacer le missile à la verticale de manière autonome
   * Création de la classe enum Direction
   * Refactoring de la classe Sprite sur les méthodes se déplacer à gauche ou à droite
   * Implémentation de la méthode evoluer pour que le missile déplace automatiquement
   
   ### Création de nouveau package model
   
   ### Création de nouvelle classe Envahisseur
   * Implémentation des nouveaux tests pour l'envahisseur
   * Génération des nouvelles méthodes(positionner un nouveau envahisseur, déplacer l'envahisseur) pour faire passer les tests
   * Implémentation de la méthode évoluer pour que l'envahisseur fasse des aller-retour dans le jeu

## Diagramme de classes
   ![alt text](https://github.com/ruizhengxu/spaceinvaders/blob/master/imageDiagramClass/spaceInvadersDiagramClass3.png)

## Nuage de mots
   ![alt text](https://github.com/ruizhengxu/spaceinvaders/blob/master/imageWordCloud/spaceinvadersWordCloud3.png)

# Semaine du 20/05 au 25/05
## Description du travail effectué
   ### Création de nouvelle classe Collision
   * Implémentation des nouveaux tests pour gérer les collisions entre le missile et l'envahisseur
   * Implémentation de la méthode déplacerMissile pour contrôler la collision

## Diagramme de classes
   ![alt text](https://github.com/ruizhengxu/spaceinvaders/blob/master/imageDiagramClass/spaceInvadersDiagramClass4.png)
   
## Nuage de mots
   ![alt text](https://github.com/ruizhengxu/spaceinvaders/blob/master/imageWordCloud/spaceinvadersWordCloud4.png)

# Semaine du 27/05 au 31/05
## Description du travail effectué

   ### Fin de la fonctionnalité colission
   * La fonctionnalité colission est finie
   * Implémentation des nouveaux tests pour la collision en utilisant assertTrue() et assertFalse()
   
   ### Implémentation de la fonctionnalité fin de la partie
   * Implémention de la classe DessinSpaceinvaders et de la classe Spaceinvaders pour gérer la fin de la partie
   * La partie est finie lorsque le missile détruit l'envahisseur, donc tous les sprites sont détruits
   * EtreFini() retourne true lorsque notre vaisseau est null
   * Dessin d'un text qui annonce la fin de la partie avec Graphic2D

## Diagramme de classes
   ![alt text](https://github.com/ruizhengxu/spaceinvaders/blob/master/imageDiagramClass/spaceInvadersDiagramClass5.png)
   
## Nuage de mots
   ![alt text](https://github.com/ruizhengxu/spaceinvaders/blob/master/imageWordCloud/spaceinvadersWordCloud5.png)

