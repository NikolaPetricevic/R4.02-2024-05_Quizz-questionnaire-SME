package org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.utils.exceptions.fournirListeQuestionnaireExceptions;

public class FichierCorrompuException extends FournirQuestionnaireException {

    public FichierCorrompuException() {
        super("Le fichier est corrompu");
    }
}
