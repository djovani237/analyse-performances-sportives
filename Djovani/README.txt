=====================================================
         RAPPORT INDIVIDUEL - DJOVANI
=====================================================

Rôle : Chef d'équipe / Développeur principal
Projet : Analyse de performances sportives

1. ARCHITECTURE ET CONCEPTION POO
---------------------------------
J'ai conçu l'architecture globale du projet en respectant les principes SOLID (notamment le principe Ouvert/Fermé - OCP) :
- Interface 'PerformanceEvaluable' : Définit le contrat d'évaluation des statistiques.
- Classe abstraite 'Athlete' : Factorise le nom, la discipline et les performances. Implémente 'Comparable<Athlete>' pour le classement automatique.
- Classes filles 'AthleteCourse' et 'AthleteLancer' : Redéfinissent 'getMeilleurePerformance()' selon la logique métier de chaque discipline (minimum pour la course, maximum pour le lancer).

2. GESTION DES EXCEPTIONS ET FICHIERS
--------------------------------------
- Création de 'DonneesInvalidesException' pour lever une alerte lorsque les performances sont négatives ou nulles.
- Développement de 'GestionnaireCSV' utilisant un BufferedReader et try-with-resources.
- Capture sélective des exceptions (NumberFormatException et DonneesInvalidesException) pour ignorer les lignes corrompues sans interrompre le traitement complet du fichier CSV.

3. STRATÉGIE DE TEST ET VERSIONNEMENT
--------------------------------------
- Création du fichier 'competitions.csv' intégrant 15 résultats avec des cas limites (-5.0, 0.0, 'abc') pour valider la robustesse du code.
- Gestion du dépôt GitHub : création des branches, commits fréquents avec messages explicitants, et structuration des répertoires.