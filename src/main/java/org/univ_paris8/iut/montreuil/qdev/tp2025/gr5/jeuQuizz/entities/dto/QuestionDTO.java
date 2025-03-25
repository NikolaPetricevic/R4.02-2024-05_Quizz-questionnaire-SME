package org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.entities.dto;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.utils.enums.Langue;

public class QuestionDTO {

    static int compteur = 0;
    private int id;
    private int idQuestionnaire;
    private int numQuestion;
    private Langue langue;
    private String libelle;
    private String reponse;
    private int difficulte;
    private String explication;
    private String reference;

    public QuestionDTO(int idQuestionnaire, int numQuestion, Langue langue, String libelle, String reponse, int difficulte, String explication, String reference) {
        this.id = compteur++;
        this.idQuestionnaire = idQuestionnaire;
        this.numQuestion = numQuestion;
        this.langue = langue;
        this.libelle = libelle;
        this.reponse = reponse;
        this.difficulte = difficulte;
        this.explication = explication;
        this.reference = reference;
    }
}
