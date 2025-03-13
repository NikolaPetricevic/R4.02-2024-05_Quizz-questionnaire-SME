package org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.entities.dto.QuestionnaireDTO;

import java.util.ArrayList;

public interface FournirListeQuestionnairesInterface {

    public ArrayList<QuestionnaireDTO> fournirListeQuestionnaires(String cheminCSV);
}
