package util;

import model.Athlete;
import model.AthleteLancer;
import model.AthleteCourse;
import exception.DonneesInvalidesException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GestionnaireCSV { // Déclare la classe utilitaire publique GestionnaireCSV.

    public static Map<String, Athlete> chargerDonnees(String cheminFichier) {
        // Méthode statique accessible sans instanciation, prenant le chemin du fichier CSV en entrée
        // et retournant un dictionnaire (Map) d'athlètes.

        Map<String, Athlete> athletes = new HashMap<>();
        // Initialise une Map vide pour associer une clé unique (String) à chaque objet Athlete.

        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            // Ouvre le fichier CSV avec try-with-resources pour garantir sa fermeture automatique à la fin du bloc.

            String ligne; // Variable temporaire recevant le contenu de la ligne courante.
            boolean premiereLigne = true; // Drapeau servant à identifier la ligne d'en-tête du fichier CSV.

            while ((ligne = br.readLine()) != null) { // Parcourt le fichier ligne par ligne jusqu'à atteindre la fin (null).

                if (premiereLigne) { // Si on se trouve sur la première ligne (l'en-tête CSV)...
                    premiereLigne = false; // Désactive le drapeau pour les lignes suivantes.
                    continue; // Saute l'en-tête et passe directement à la ligne suivante.
                }

                String[] elements = ligne.split(","); // Découpe la ligne en un tableau de chaînes à chaque virgule.

                if (elements.length < 3) { // Vérifie que la ligne contient bien au moins 3 colonnes (Nom, Discipline, Performance).
                    System.err.println("[Erreur Format] Ligne incomplète ignorée : " + ligne); // Affiche un message d'erreur.
                    continue; // Ignore la ligne incomplète et passe à la suivante.
                }

                String nom = elements[0].trim(); // Récupère le nom (colonne 1) en supprimant les espaces superflus.
                String discipline = elements[1].trim(); // Récupère la discipline (colonne 2) sans espaces superflus.
                String perfStr = elements[2].trim(); // Récupère la valeur de la performance sous forme de texte.

                try { // Bloc try interne pour intercepter les erreurs de conversion numérique et de validation.

                    double perf = Double.parseDouble(perfStr); // Convertit le texte de la performance en nombre décimal (double).

                    String cle = nom + "_" + discipline; // Crée une clé unique combinant le nom et la discipline (ex: "Bolt_Course").

                    Athlete athlete = athletes.get(cle); // Recherche si cet athlète existe déjà dans la Map.

                    if (athlete == null) { // Si l'athlète n'existe pas encore dans la Map...
                        if (discipline.equalsIgnoreCase("Course")) { // Si la discipline est "Course"...
                            athlete = new AthleteCourse(nom); // Crée une instance de AthleteCourse.
                        } else if (discipline.equalsIgnoreCase("Lancer")) { // Si la discipline est "Lancer"...
                            athlete = new AthleteLancer(nom); // Crée une instance de AthleteLancer.
                        } else { // Si la discipline renseignée n'est pas prise en charge...
                            System.err.println("[Discipline Inconnue] " + discipline + " pour " + nom); // Affiche un avertissement.
                            continue; // Saute cette entrée.
                        }
                        athletes.put(cle, athlete); // Enregistre le nouvel athlète dans la Map avec sa clé unique.
                    }

                    athlete.ajouterPerformance(perf);
                    // Ajoute la performance à l'athlète (peut lever DonneesInvalidesException si la valeur est <= 0).

                } catch (NumberFormatException e) { // Intercepte le cas où la performance n'est pas un nombre (ex: "ABC").
                    System.err.println("[Erreur Format] Valeur numérique invalide pour " + nom + " : '" + perfStr + "'");
                } catch (DonneesInvalidesException e) { // Intercepte l'exception de donnée négative ou nulle.
                    System.err.println("[Donnée Invalide] " + e.getMessage());
                }
            } // Fin de la boucle while.

        } catch (IOException e) { // Intercepte un problème d'accès ou de lecture du fichier CSV.
            System.err.println("[Erreur Fichier] Impossible de lire le fichier : " + e.getMessage());
        }

        return athletes; // Retourne le dictionnaire contenant les athlètes instanciés et leurs performances.
    }
}
