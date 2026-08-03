package exception;
// Indique le package (le dossier) dans lequel la classe est rangée.

public class DonneesInvalidesException extends Exception {
// Déclare la classe d'exception personnalisée accessible partout ("public"),
// qui hérite ("extends") de la classe standard Java "Exception".

    public DonneesInvalidesException(String message) {
        // Déclare le constructeur public de la classe, qui prend un texte ("message") en paramètre
        // pour décrire l'erreur survenue.

        super(message);
        // Transmet le message d'erreur au constructeur de la classe parente ("Exception")
        // afin d'enregistrer la description de l'erreur dans la pile d'exécution Java.

    }

}
