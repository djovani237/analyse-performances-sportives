=====================================================
               RAPPORT INDIVIDUEL  BOUSLAH CELIA

=====================================================


Rôle : Développeuse & Responsable Modélisation et Données

Fichiers et classes pris en charge :

1. Architecture du Modèle de données :

   - Athlete.java : Classe abstraite de base regroupant les attributs communs (nom, discipline, liste de performances), le calcul de la moyenne et l'implémentation de la comparaison d'athlètes.

   - AthleteLancer.java : Sous-classe concrète représentant les athlètes de lancer, avec sélection de la distance maximale comme meilleure performance.

2. Gestion des erreurs et exceptions :

   - DonneesInvalidesException.java : Exception personnalisée créée pour capturer et gérer les données d'entrées invalides (performances négatives ou nulles).

3. Fichier de données & Révisions :

   - Competition.csv : Conception et création du fichier de données d'entrée contenant plus de 15 résultats de compétitions pour différentes disciplines, incluant des données invalides pour tester le système d'exceptions.


Principes SOLID appliqués :

- SRP (Principe de Responsabilité Unique) : Découplage de la validation des données via des exceptions dédiées (DonneesInvalidesException).

- Héritage & Polymorphisme : Factorisation du code commun dans la classe abstraite Athlete.
