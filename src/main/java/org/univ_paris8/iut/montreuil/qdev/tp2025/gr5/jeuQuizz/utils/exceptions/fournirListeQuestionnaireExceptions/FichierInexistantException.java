package org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.utils.exceptions.fournirListeQuestionnaireExceptions;

public class FichierInexistantException extends FournirQuestionnaireException {

    public FichierInexistantException() {
        super("Le fichier n'existe pas");
    }
}
