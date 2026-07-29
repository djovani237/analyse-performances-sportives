package util;

import exception.DonneesInvalidesException;
import model.Athlete;
import model.AthleteCourse;
import model.AthleteLancer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GestionnaireCSV {

    public static Map<String, Athlete> chargerDonnees(String cheminFichier) {
        Map<String, Athlete> athletes = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            boolean premiereLigne = true;

            while ((ligne = br.readLine()) != null) {
                if (premiereLigne) {
                    premiereLigne = false;
                    continue;
                }

                String[] elements = ligne.split(",");
                if (elements.length < 3) {
                    System.err.println("[Erreur Format] Ligne incomplète ignorée : " + ligne);
                    continue;
                }

                String nom = elements[0].trim();
                String discipline = elements[1].trim();
                String perfStr = elements[2].trim();

                try {
                    double perf = Double.parseDouble(perfStr);
                    String cle = nom + "_" + discipline;
                    Athlete athlete = athletes.get(cle);

                    if (athlete == null) {
                        if (discipline.equalsIgnoreCase("Course")) {
                            athlete = new AthleteCourse(nom);
                        } else if (discipline.equalsIgnoreCase("Lancer")) {
                            athlete = new AthleteLancer(nom);
                        } else {
                            System.err.println("[Discipline Inconnue] " + discipline + " pour " + nom);
                            continue;
                        }
                        athletes.put(cle, athlete);
                    }

                    athlete.ajouterPerformance(perf);

                } catch (NumberFormatException e) {
                    System.err.println("[Erreur Format] Valeur numérique invalide pour " + nom + " : '" + perfStr + "'");
                } catch (DonneesInvalidesException e) {
                    System.err.println("[Donnée Invalide] " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("[Erreur Fichier] Impossible de lire le fichier : " + e.getMessage());
        }

        return athletes;
    }
}