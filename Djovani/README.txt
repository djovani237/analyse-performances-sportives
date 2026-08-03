=====================================================
         RAPPORT INDIVIDUEL - DJOVANI
=====================================================

Rôle : Chef d'équipe / Développeur principal
Projet : Analyse de performances sportives

1. ARCHITECTURE ET CONCEPTION POO
---------------------------------
J'ai conçu l'architecture globale du projet en respectant les principes SOLID (notamment le principe Ouvert/Fermé - OCP) :
Fichiers et classes pris en charge :
1. Modèle de données :
   - AthleteCourse.java : Sous-classe représentant les athlètes de course. Implémentation de la logique où le temps le plus petit constitue la meilleure performance.

2. Interfaces & Contrats :
   - PerformanceEvaluable.java : Interface définissant les méthodes nécessaires pour l'évaluation, l'analyse et la comparaison des performances sportives.

3. Traitement des fichiers :
   - GestionnaireCSV.java : Classe utilitaire chargée de la lecture du fichier CSV, du découpage des lignes, du filtrage des erreurs de format et de l'attribution des performances aux athlètes.

4. Exécution & Coordination :
   - Main.java : Point d'entrée de l'application. Orchestration du chargement des données, de l'exécution des analyses statistiques et de l'affichage des résultats dans la console.

5. Gestion de projet & GitHub :
   - Configuration du dépôt Git, gestion des branches et de la coordination de l'équipe.
   - Rédaction du README.md principal et structuration globale du projet.

6. Révisions :
   -- Révision globale du code : Relecture, correction de bugs, nettoyage et optimisation générale du code de l'application.

Principes SOLID appliqués :
- SRP (Principe de Responsabilité Unique) : Séparation stricte entre l'exécution (Main.java), l'évaluation (PerformanceEvaluable) et le chargement de données (GestionnaireCSV.java).
- OCP (Principe Ouvert/Fermé) : Conception extensible permettant d'ajouter de nouvelles disciplines sans altérer la logique de la méthode main.
