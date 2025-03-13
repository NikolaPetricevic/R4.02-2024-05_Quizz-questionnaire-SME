package org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.services.interfaces.FournirListeQuestionnairesInterface;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.utils.exceptions.fournirListeQuestionnaireExceptions.FournirQuestionnaireException;

import java.util.ArrayList;

public class FournirListeQuestionnaires implements FournirListeQuestionnairesInterface {

    @Override
    public ArrayList<QuestionnaireDTO> fournirListeQuestionnaires(String cheminCSV) {
        try {

        }
        catch (FournirQuestionnaireException e) {

        }
    }
}
