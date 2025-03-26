package org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.services.interfaces.FournirListeQuestionnairesInterface;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.utils.enums.Langue;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.utils.exceptions.fournirListeQuestionnaireExceptions.FichierCorrompuException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.utils.exceptions.fournirListeQuestionnaireExceptions.FormatFichierInvalideException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr5.jeuQuizz.utils.exceptions.fournirListeQuestionnaireExceptions.FournirQuestionnaireException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FournirListeQuestionnaires implements FournirListeQuestionnairesInterface {

    @Override
    public ArrayList<QuestionnaireDTO> fournirListeQuestionnaires(String cheminFichierCSV) throws FournirQuestionnaireException {
        ArrayList<QuestionnaireDTO> questionnaires = new ArrayList<>();
        QuestionnaireDTO questionnaireActuel = new QuestionnaireDTO("");
        boolean questionnaireTrouve = false;

        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichierCSV))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] champs = ligne.split(";");
                if (champs.length < 8) {
                    continue;
                }

                try {
                    int idQuestionnaire = Integer.parseInt(champs[0].replaceAll("[^0-9]", ""));
                    int numQuestion = Integer.parseInt(champs[1]);
                    Langue langue = Langue.valueOf(champs[2]);
                    String libelle = champs[3];
                    String reponse = champs[4];
                    int difficulte = Integer.parseInt(champs[5]);
                    String explication = champs[6];
                    String reference = champs[7];

                    for(QuestionnaireDTO q: questionnaires) {
                        if (q.getId() == idQuestionnaire) {
                            questionnaireActuel = q;
                            questionnaireTrouve = true;
                            break;
                        }
                    }

                    if(!questionnaireTrouve) {
                        questionnaireActuel = new QuestionnaireDTO("Questionnaire " + idQuestionnaire);
                        questionnaires.add(questionnaireActuel);
                    }

                    QuestionDTO question = new QuestionDTO(idQuestionnaire, numQuestion, Langue.fr, libelle, reponse, difficulte, explication, reference);
                    questionnaireActuel.ajouterQuestion(question);

                    questionnaireTrouve = false;
                } catch (IllegalArgumentException e) {
                    throw new FormatFichierInvalideException();
                }
            }
        } catch (IOException e) {
            throw new FichierCorrompuException();
        }

        return questionnaires;
    }
}
