import util.GestionnaireCSV;
import model.Athlete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CHARGEMENT ET VALIDATION DES DONNÉES ===");
        Map<String, Athlete> carteAthletes = GestionnaireCSV.chargerDonnees("competitions.csv");

        List<Athlete> listeAthletes = new ArrayList<>(carteAthletes.values());

        System.out.println("\n=== RÉSULTATS ET STATISTIQUES DES ATHLÈTES ===");
        for (Athlete a : listeAthletes) {
            System.out.printf("Nom: %-10s | Discipline: %-7s | Meilleure: %-5.2f | Moyenne: %-5.2f | Nb Perfs: %d%n",
                    a.getNom(),
                    a.getDiscipline(),
                    a.getMeilleurePerformance(),
                    a.getMoyennePerformances(),
                    a.getPerformances().size());
        }

        System.out.println("\n=== CLASSEMENT GÉNÉRAL (Tri Comparable) ===");
        Collections.sort(listeAthletes);

        int rang = 1;
        for (Athlete a : listeAthletes) {
            System.out.printf("%d. %-10s (%s) - Score de référence: %.2f%n",
                    rang++,
                    a.getNom(),
                    a.getDiscipline(),
                    a.getMeilleurePerformance());
        }
    }
}