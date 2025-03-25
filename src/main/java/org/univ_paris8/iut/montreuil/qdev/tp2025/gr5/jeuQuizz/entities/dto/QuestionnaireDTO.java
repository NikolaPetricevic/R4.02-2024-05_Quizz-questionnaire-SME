package org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.entities.dto;

import java.util.ArrayList;

public class QuestionnaireDTO {

    static int compteur = 0;
    private int id;
    private String titre;
    private ArrayList<QuestionDTO> questions;

    public QuestionnaireDTO(String titre, ArrayList<QuestionDTO> questions) {
        this.id = compteur++;
        this.titre = titre;
        this.questions = questions;
    }

    public QuestionnaireDTO(String titre) {
        this.id = compteur++;
        this.titre = titre;
        this.questions = new ArrayList<>();
    }

    public void ajouterQuestion(QuestionDTO question) {
        this.questions.add(question);
    }

    public ArrayList<QuestionDTO> getQuestions() {
        return questions;
    }


}
