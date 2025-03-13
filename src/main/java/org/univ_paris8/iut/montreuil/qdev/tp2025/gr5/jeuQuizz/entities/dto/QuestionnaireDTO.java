package org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.entities.dto;

import java.util.ArrayList;

public class QuestionnaireDTO {

    static int compteur = 0;
    private int id;
    private String titre;
    private ArrayList<QuestionDTO> questions;

    public QuestionnaireDTO(String titre, ArrayList<QuestionDTO> questions) {
        this.titre = titre;
        this.questions = questions;
    }
}
