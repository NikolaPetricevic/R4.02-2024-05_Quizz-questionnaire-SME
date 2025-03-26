package org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.services.impl.FournirListeQuestionnaires;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.utils.exceptions.fournirListeQuestionnaireExceptions.FournirQuestionnaireException;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        FournirListeQuestionnaires fournirListeQuestionnaires = new FournirListeQuestionnaires();

        try {
            ArrayList<QuestionnaireDTO> questionnaires;
            questionnaires = fournirListeQuestionnaires.fournirListeQuestionnaires("src/main/java/org/univ_paris8/iut/montreuil/qdev/tp2025/gr5/jeuQuizz/utils/questionsQuizz_V1.1 (copie).csv");
            for (QuestionnaireDTO q: questionnaires) {
                for (QuestionDTO question: q.getQuestions()) {
                    System.out.println(question.getLibelle());
                }
            }
        }
        catch(FournirQuestionnaireException e) {
            System.out.println(e.getMessage());
        }
    }
}