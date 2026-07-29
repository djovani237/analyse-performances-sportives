\# 🏃 Analyse de Performances Sportives



\[!\[Java Version](https://img.shields.io/badge/Java-25-orange.svg)](https://www.oracle.com/java/)

\[!\[License](https://img.shields.io/badge/License-Academic-blue.svg)](#)



Application Java d'analyse et de classement de performances d'athlètes à partir de fichiers CSV, développée dans le cadre du cours de Programmation Avancée.



\---



\## 🎯 Objectifs du Projet



\- \*\*Architecture Orientée Objet (POO) :\*\* Respect des principes SOLID (notamment le principe Ouvert/Fermé).

\- \*\*Gestion des Exceptions :\*\* Traitement des anomalies sans interruption du programme principal.

\- \*\*Manipulation d'I/O :\*\* Lecture et parsing optimisés de fichiers CSV via `BufferedReader`.

\- \*\*Tri \& Algorithmique :\*\* Implémentation du contrat `Comparable` pour établir un classement général dynamique.



\---



\## 🏗️ Architecture du Code



```text

analyse-performances-sportives/

├── src/

│   ├── exception/

│   │   └── DonneesInvalidesException.java   # Exception personnalisée (valeurs <= 0)

│   ├── model/

│   │   ├── PerformanceEvaluable.java        # Interface d'évaluation des perfs

│   │   ├── Athlete.java                     # Classe abstraite parente (Comparable)

│   │   ├── AthleteCourse.java               # Spécialisation Course (min = meilleur)

│   │   └── AthleteLancer.java               # Spécialisation Lancer (max = meilleur)

│   ├── util/

│   │   └── GestionnaireCSV.java             # Parsing \& validation robuste du CSV

│   └── Main.java                            # Point d'entrée de l'application

├── competitions.csv                         # Jeu de données de test (avec anomalies)

├── contributions.txt                        # Suivi de la répartition du travail

└── README.md                                # Présentation du projet

