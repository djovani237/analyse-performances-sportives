package model; // Indique que cette classe appartient au package (dossier) "model".

public class AthleteLancer extends Athlete { // Déclare la classe concrète AthleteLancer qui hérite ("extends") de la classe abstraite Athlete.

    public AthleteLancer(String nom) { // Constructeur de la classe AthleteLancer prenant le nom de l'athlète en paramètre.

        super(nom, "Lancer"); // Appelle le constructeur de la classe parente (Athlete) en lui passant le nom et la discipline "Lancer".

    } // Ferme le bloc du constructeur.

    @Override // Annotation indiquant qu'on redéfinit la méthode abstraite getMeilleurePerformance() héritée de la classe Athlete.

    public double getMeilleurePerformance() { // Déclaration de la méthode calculant la meilleure performance au lancer.

        if (performances.isEmpty()) return 0.0; // Si la liste des performances est vide, retourne 0.0 pour éviter toute erreur.

        double max = performances.get(0); // Initialise la variable "max" avec le premier lancer enregistré dans la liste.

        for (double p : performances) { // Parcourt chaque performance "p" enregistrée dans la liste "performances".

            if (p > max) max = p; // Si le lancer courant "p" est supérieur au lancer maximum actuel, met à jour "max".

        } // Ferme la boucle for.

        return max; // Retourne le lancer le plus long (la meilleure performance).

    }

}

